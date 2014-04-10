package desenv.controle;

import java.io.Serializable;
import java.util.List;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Evento;
import desenv.modelo.persistencia.EventoDAO;

public class EventoFacade extends GenericFacade<Evento> implements
		Serializable, IGenericFacade<Evento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventoDAO dao = new EventoDAO();

	public EventoFacade() {
		setClasseDAO(dao);
	}

	public List<Evento> pesquisaPorFiltro(String nome) {
		parameters.clear();
		parameters.put("nome", nome);
		return dao.filtrados(parameters);
	}



}
