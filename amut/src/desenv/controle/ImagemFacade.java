package desenv.controle;

import java.io.Serializable;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Imagem;
import desenv.modelo.persistencia.ImagemDAO;

public class ImagemFacade extends GenericFacade<Imagem> implements
		Serializable, IGenericFacade<Imagem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImagemDAO userDAO = new ImagemDAO();

	public ImagemFacade() {
		setClasseDAO(userDAO);
	}



}
