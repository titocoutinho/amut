package desenv.modelo.persistencia;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Evento;

public class EventoDAO extends GenericDAO<Evento> implements
		IGenericDAO<Evento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventoDAO() {
		super(Evento.class);
		// TODO Auto-generated constructor stub
	}

}
