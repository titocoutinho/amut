package desenv.controle;

import java.io.Serializable;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.SubCategoria;
import desenv.modelo.persistencia.SubCategoriaDAO;

public class SubCategoriaFacade extends GenericFacade<SubCategoria> implements
		Serializable, IGenericFacade<SubCategoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubCategoriaDAO dao = new SubCategoriaDAO();

	public SubCategoriaFacade() {
		setClasseDAO(dao);
	}

	
}
