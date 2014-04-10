package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.ArtigoFacade;
import desenv.controle.CategoriaFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Artigo;
import desenv.modelo.entidade.Categoria;

@ManagedBean
@ViewScoped
public class ArtigoManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String ARTIGO_SELECIONADO = "artigoSelecionado";
	
	private Artigo artigo;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	private List<Artigo> artigos;
	private List<Artigo> filtrados = new ArrayList<Artigo>();
	
	private ArtigoFacade facade;
	
	private String nome;

	

	@Override
	@PostConstruct
	public void load() {
		
		facade = new ArtigoFacade();
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getFacade().salvar(getArtigo());
			closeDialog();
			displayInfoMessageToUser("Artigo criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Artigo, tente novamente!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void pesquisar() {
		try{
			setFiltrados(facade.pesquisaPorFiltro(nome));
		}catch(Exception e){
			displayErrorMessageToUser("Ops, nós não conseguimos realizar a pesquisa");
			e.printStackTrace();
		}
		
	}

	@Override
	public void reset() {
		artigo = new Artigo();
		
		
	}

	@Override
	public void carregarLista() {
		artigos = getFacade().listarTudo();
		categorias = new CategoriaFacade().listarTudo();
		filtrados = artigos;
	}
	
	public ArtigoFacade getFacade() {
		
		return facade;
	}
	public void setFacade(ArtigoFacade facade) {
		this.facade = facade;
	}

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	public List<Artigo> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Artigo> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getCategorias() {
		
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	
}
