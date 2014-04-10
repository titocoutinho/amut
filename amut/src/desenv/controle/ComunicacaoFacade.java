package desenv.controle;

import java.io.Serializable;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Comunicacao;
import desenv.modelo.persistencia.ComunicacaoDAO;

public class ComunicacaoFacade extends GenericFacade<Comunicacao> implements
		Serializable, IGenericFacade<Comunicacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComunicacaoDAO userDAO = new ComunicacaoDAO();

	public ComunicacaoFacade() {
		setClasseDAO(userDAO);
	}

	
}
