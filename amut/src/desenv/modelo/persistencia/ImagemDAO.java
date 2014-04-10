package desenv.modelo.persistencia;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Imagem;

public class ImagemDAO extends GenericDAO<Imagem> implements IGenericDAO<Imagem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImagemDAO() {
		super(Imagem.class);
	}

}
