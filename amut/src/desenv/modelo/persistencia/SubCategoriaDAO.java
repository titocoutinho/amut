package desenv.modelo.persistencia;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.SubCategoria;

public class SubCategoriaDAO extends GenericDAO<SubCategoria> implements
		IGenericDAO<SubCategoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubCategoriaDAO() {
		super(SubCategoria.class);
	}

}
