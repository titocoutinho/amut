package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.GaleriaFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Galeria;

@ManagedBean
@ViewScoped
public class GaleriaManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String GALERIA_SELECIONADO = "galeriaSelecionado";
	
	private Galeria galeria;
	
	private List<Galeria> galerias;
	private List<Galeria> filtrados = new ArrayList<Galeria>();
	
	private GaleriaFacade facade;
	
	private String nome;

	

	@Override
	@PostConstruct
	public void load() {
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getFacade().salvar(getGaleria());
			closeDialog();
			displayInfoMessageToUser("Galeria criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Galeria, tente novamente!");
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
		galeria = new Galeria();
		
		
	}

	@Override
	public void carregarLista() {
		galerias = getFacade().listarTudo();
		filtrados = galerias;
	}
	
	public GaleriaFacade getFacade() {
		if(facade == null){
			facade = new GaleriaFacade();
		}
		return facade;
	}
	public void setFacade(GaleriaFacade facade) {
		this.facade = facade;
	}

	public Galeria getGaleria() {
		return galeria;
	}

	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}

	public List<Galeria> getGalerias() {
		return galerias;
	}

	public void setGalerias(List<Galeria> galerias) {
		this.galerias = galerias;
	}

	public List<Galeria> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Galeria> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
