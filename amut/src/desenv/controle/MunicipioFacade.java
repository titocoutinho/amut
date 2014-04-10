package desenv.controle;

import java.io.Serializable;
import java.util.List;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Municipio;
import desenv.modelo.persistencia.MunicipioDAO;

public class MunicipioFacade extends GenericFacade<Municipio> implements
		Serializable, IGenericFacade<Municipio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MunicipioDAO userDAO = new MunicipioDAO();

	public MunicipioFacade() {
		setClasseDAO(userDAO);
	}

	public List<Municipio> pesquisaPorFiltro(String nome) {
		return null;
	}

	
}
