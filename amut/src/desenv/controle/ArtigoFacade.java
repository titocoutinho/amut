package desenv.controle;

import java.io.Serializable;
import java.util.List;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Artigo;
import desenv.modelo.persistencia.ArtigoDAO;
import desenv.modelo.persistencia.CategoriaDAO;

public class ArtigoFacade extends GenericFacade<Artigo> implements
		Serializable, IGenericFacade<Artigo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArtigoDAO dao = new ArtigoDAO();

	public ArtigoFacade() {
		setClasseDAO(dao);
	}

	public List<Artigo> pesquisaPorFiltro(String nome) {
		parameters.clear();
		parameters.put("titulo", nome);
		return dao.filtrados(parameters);
	}


		@Override
		public void salvar(Artigo entidade) {
			entidade.setCategoria(new CategoriaDAO().find(entidade.getCategoria().getId()));
			super.salvar(entidade);
		}

	

}
