package desenv.modelo.persistencia;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Caracteristica;

public class CaracteristicaDAO extends GenericDAO<Caracteristica> implements
		IGenericDAO<Caracteristica> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaracteristicaDAO() {
		super(Caracteristica.class);

	}

}
