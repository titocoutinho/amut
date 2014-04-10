package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.MunicipioFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Municipio;

@ManagedBean
@ViewScoped
public class MunicipioManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String MUNICIPIO_SELECIONADO = "municipioSelecionado";
	
	private Municipio municipio;
	
	private List<Municipio> municipios;
	private List<Municipio> filtrados = new ArrayList<Municipio>();
	
	private MunicipioFacade facade;
	
	private String nome;

	

	@Override
	@PostConstruct
	public void load() {
		facade = new MunicipioFacade();
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getFacade().salvar(getMunicipio());
			closeDialog();
			displayInfoMessageToUser("Municipio criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Municipio, tente novamente!");
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
		municipio = new Municipio();
		
		
	}

	@Override
	public void carregarLista() {
		municipios = getFacade().listarTudo();
		filtrados = municipios;
	}
	
	public MunicipioFacade getFacade() {
		return facade;
	}
	public void setFacade(MunicipioFacade facade) {
		this.facade = facade;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<Municipio> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Municipio> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
