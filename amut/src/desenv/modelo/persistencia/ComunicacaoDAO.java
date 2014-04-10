package desenv.modelo.persistencia;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Comunicacao;

public class ComunicacaoDAO extends GenericDAO<Comunicacao>  implements IGenericDAO<Comunicacao>  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComunicacaoDAO() {
		super(Comunicacao.class);
		
	}


}
