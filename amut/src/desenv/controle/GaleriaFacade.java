package desenv.controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Galeria;
import desenv.modelo.persistencia.GaleriaDAO;

public class GaleriaFacade extends GenericFacade<Galeria> implements
		Serializable, IGenericFacade<Galeria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GaleriaDAO dao = new GaleriaDAO();
	Map<String, Object> parameters = new HashMap<String, Object>();

	public GaleriaFacade() {
		setClasseDAO(dao);
	}

	public List<Galeria> pesquisaPorFiltro(String titulo) {
		parameters.clear();parameters.put("titulo", titulo);
		return dao.filtrados(parameters);
	}



}
