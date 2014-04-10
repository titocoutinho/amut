package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.CaracteristicaFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.entidade.Caracteristica;

@ManagedBean
@ViewScoped
public class CaracteristicaManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String CARACTERISTICA_SELECIONADO = "caracteristicaSelecionado";
	
	private Caracteristica caracteristica;
	
	private List<Caracteristica> caracteristicas;
	private List<Caracteristica> filtrados = new ArrayList<Caracteristica>();
	
	private CaracteristicaFacade facade;
	
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
			getFacade().salvar(getCaracteristica());
			closeDialog();
			displayInfoMessageToUser("Caracteristica criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Caracteristica, tente novamente!");
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
		caracteristica = new Caracteristica();
		
		
	}

	@Override
	public void carregarLista() {
		caracteristicas = getFacade().listarTudo();
		filtrados = caracteristicas;
	}
	
	public CaracteristicaFacade getFacade() {
		if(facade == null){
			facade = new CaracteristicaFacade();
		}
		return facade;
	}
	public void setFacade(CaracteristicaFacade facade) {
		this.facade = facade;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<Caracteristica> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Caracteristica> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
