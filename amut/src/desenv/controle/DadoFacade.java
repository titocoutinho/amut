package desenv.controle;

import java.io.Serializable;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Dado;
import desenv.modelo.persistencia.DadoDAO;

public class DadoFacade extends GenericFacade<Dado> implements
		Serializable, IGenericFacade<Dado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DadoDAO dao = new DadoDAO();

	public DadoFacade() {
		setClasseDAO(dao);
	}


}
