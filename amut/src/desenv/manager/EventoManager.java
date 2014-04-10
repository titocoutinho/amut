package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.EventoFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.entidade.Evento;

@ManagedBean
@ViewScoped
public class EventoManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String PARAMETRO_SELECIONADO = "eventoSelecionado";
	
	private Evento evento;
	
	private List<Evento> eventos;
	private List<Evento> filtrados = new ArrayList<Evento>();
	
	private EventoFacade facade;
	
	private String nome;

	

	@Override
	@PostConstruct
	public void load() {
		facade = new EventoFacade();
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getEvento().setAtivo(Boleano.SIM);
			getFacade().salvar(getEvento());
			closeDialog();
			displayInfoMessageToUser("Evento criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Evento, tente novamente!");
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
		evento = new Evento();
		
		
	}

	@Override
	public void carregarLista() {
		eventos = getFacade().listarTudo();
		filtrados = eventos;
	}
	
	public EventoFacade getFacade() {
		
		return facade;
	}
	public void setFacade(EventoFacade facade) {
		this.facade = facade;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Evento> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Evento> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
