package desenv.controle;

import java.io.Serializable;
import java.util.List;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Categoria;
import desenv.modelo.persistencia.CategoriaDAO;

public class CategoriaFacade extends GenericFacade<Categoria> implements
		Serializable, IGenericFacade<Categoria> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoriaDAO dao = new CategoriaDAO();
	

	public CategoriaFacade() {
		setClasseDAO(dao);
	}

	public List<Categoria> pesquisaPorFiltro(String nome) {
		return null;
	}
	
	public List<Categoria> categoriasSemPai(){
	dao.beginTransaction();
		return dao.getCategoriaSemPai();
		
	}

}
