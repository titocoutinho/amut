package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.ParametroFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Parametro;

@ManagedBean
@ViewScoped
public class ParametroManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String PARAMETRO_SELECIONADO = "parametroSelecionado";
	
	private Parametro parametro;
	
	private List<Parametro> parametros;
	private List<Parametro> filtrados = new ArrayList<Parametro>();
	
	private ParametroFacade facade;
	
	private String nome;

	

	@Override
	@PostConstruct
	public void load() {
		facade = new ParametroFacade();
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getFacade().salvar(getParametro());
			closeDialog();
			displayInfoMessageToUser("Parametro criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Parametro, tente novamente!");
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
		parametro = new Parametro();
		
		
	}

	@Override
	public void carregarLista() {
		parametros = getFacade().listarTudo();
		filtrados = parametros;
	}
	
	public ParametroFacade getFacade() {
	
		return facade;
	}
	public void setFacade(ParametroFacade facade) {
		this.facade = facade;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public List<Parametro> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Parametro> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
