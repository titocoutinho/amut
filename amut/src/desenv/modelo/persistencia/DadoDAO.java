package desenv.modelo.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Dado;

public class DadoDAO extends GenericDAO<Dado> implements IGenericDAO<Dado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> parameters = new HashMap<String, Object>();

	public DadoDAO() {
		super(Dado.class);
	}

	public List<Dado> listaPorMunicipio(Long id){
		parameters.clear();
		parameters.put("param1", id);
		return findManyResults(Dado.PESQUISA_POR_MUNICIPIO, parameters, null, null);
	}
	/**
	 *  verificar
	 * @param id
	 * @return
	 */
	public List<Dado> listaPorCaracteristica(Long id){
		parameters.clear();
		parameters.put("param1", id);
		return findManyResults(Dado.PESQUISA_POR_CARACTERISTICA, parameters, null, null);
	}
}
