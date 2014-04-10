package desenv.modelo.persistencia;

import java.util.HashMap;
import java.util.Map;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Parametro;

public class ParametroDAO extends GenericDAO<Parametro> implements
		IGenericDAO<Parametro> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> parameters = new HashMap<String, Object>();

	public ParametroDAO() {
		super(Parametro.class);
	}

	public String getBuscaPorParametro(String parametro) {
		beginTransaction();
		parameters.clear();
		parameters.put("param1", parametro.trim());
		return super.findOneResult(Parametro.SELECT_POR_PARAMETRO, parameters).getValorParametro();
	}

}
