package desenv.controle;

import java.io.Serializable;
import java.util.List;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Caracteristica;
import desenv.modelo.persistencia.CaracteristicaDAO;

public class CaracteristicaFacade extends GenericFacade<Caracteristica> implements
		Serializable, IGenericFacade<Caracteristica> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CaracteristicaDAO dao = new CaracteristicaDAO();

	public CaracteristicaFacade() {
		setClasseDAO(dao);
	}

	public List<Caracteristica> pesquisaPorFiltro(String nome) {
		dao.beginTransaction();
		parameters.clear();
		parameters.put("nomeCaracteristica", nome);
		return dao.filtrados(parameters);
	}



}
