package desenv.modelo.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria> implements
		IGenericDAO<Categoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	

	public CategoriaDAO() {
		super(Categoria.class);
	}

	public List<Categoria> getMenu(){
		parameters.clear();
		return super.findManyResults(Categoria.CONSULTA_MENU, parameters, null, null);
	}
	
	public List<Categoria> getCategoriaSemPai(){
		parameters.clear();
		return super.findManyResults(Categoria.CONSULTA_MENU_TOTAL, parameters, null, null);
	}
	
}
