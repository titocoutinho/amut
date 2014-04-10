package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import desenv.controle.CategoriaFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaManager extends AbstractBean implements Serializable,
		IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final String PARAMETRO_SELECIONADO = "categoriaSelecionado";
	private TreeNode root;
	private TreeNode selectedNode;

	private Categoria categoria;

	private List<Categoria> categorias = new ArrayList<Categoria>()          ;
	private List<Categoria> filtrados = new ArrayList<Categoria>();
	private List<Categoria> categoriasSemPai = new ArrayList<Categoria>();

	private CategoriaFacade facade;

	private String nome;

	@Override
	@PostConstruct
	public void load() {
		facade = new CategoriaFacade();
		reset();
		carregarLista();
		geraArvore();
	}

	@Override
	public void novo() {
		
		try {
			setarPai();
			getFacade().salvar(getCategoria());
			closeDialog();
			displayInfoMessageToUser("Categoria criado com sucesso");
			carregarLista();
			reset();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Categoria, tente novamente!");
			e.printStackTrace();
		}

	}

	@Override
	public void pesquisar() {
		try {
			setFiltrados(facade.pesquisaPorFiltro(nome));
		} catch (Exception e) {
			displayErrorMessageToUser("Ops, nós não conseguimos realizar a pesquisa");
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	public void geraArvore() {
		root = new DefaultTreeNode("Principal", null);
		for (Categoria c : getCategoriasSemPai()) {
			TreeNode no = new DefaultTreeNode(c, root);
			for (Categoria y : c.getSubcategorias()) {
				TreeNode no1 = new DefaultTreeNode(y, no);

				for (Categoria x : y.getSubcategorias()) {

					TreeNode no2 = new DefaultTreeNode(x, no1);
					for (Categoria z : x.getSubcategorias()) {
						TreeNode no3 = new DefaultTreeNode(z, no2);
					}
				}
			}
		}
	}

	public void setarPai(){
		try{
		Categoria pai =(Categoria) selectedNode.getData(); 
		getCategoria().setPai(pai);
		}catch (NullPointerException e){
			
		}
		
		/*for (Categoria c : categorias) {
			if(c.getNome().toString().trim().equalsIgnoreCase(selectedNode.getData().toString().trim())){
				getCategoria().setPai(c);
				break;
			}
		}*/
	}

	@Override
	public void reset() {
		categoria = new Categoria();

	}

	@Override
	public void carregarLista() {
		categorias = getFacade().listarTudo();
		categoriasSemPai =  facade.categoriasSemPai();
		filtrados = categorias;
	}
	
	public List<Categoria> getCategoriasSemPai() {
		return categoriasSemPai;
	}
	public void setCategoriasSemPai(List<Categoria> categoriasSemPai) {
		this.categoriasSemPai = categoriasSemPai;
	}

	public CategoriaFacade getFacade() {
	
		return facade;
	}

	public void setFacade(CategoriaFacade facade) {
		this.facade = facade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Categoria> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Categoria> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

}
