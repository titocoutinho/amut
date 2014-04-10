package desenv.modelo.persistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Artigo;

public class ArtigoDAO extends GenericDAO<Artigo> implements
		IGenericDAO<Artigo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> parameters = new HashMap<String, Object>();

	public ArtigoDAO() {
		super(Artigo.class);
	}

	public List<Artigo> getBuscaPorCategoria(Long categoria) {
		parameters.clear();
		parameters.put("param1", categoria);
		return super.findManyResults(Artigo.SELECT_POR_CATEGORIA, parameters, null, null);
	}

	public Artigo getPrimeiroArtigo() {
		parameters.clear();
		return super.findOneResult(Artigo.SELECT_PRIMEIRO_ARTIGO, parameters);
	}

	public Artigo getBuscaPorPrimeiroArtigo(Long categoria) {
		parameters.clear();
		return super.findOneResult(Artigo.SELECT_POR_CATEGORIA,parameters);
		
	}

	public Artigo buscaPorCategoriaEArtigo(Long categoria, Long artigo) {
		parameters.clear();
		parameters.put("param1", categoria);
		parameters.put("param2", artigo);
		return super.findOneResult(Artigo.SELECT_POR_ARTIGO_E_CATEGORIA,parameters);
	}


	public List<Artigo> getUltimosRegistros(Integer qtd) {		
		return super.findManyResults(Artigo.SELECT_ULTIMOS_REGISTROS, parameters, 1, qtd);
	}

	public Artigo getUltimoArtigoPorCategoria(Long categoria) {
		parameters.clear();
		parameters.put("param1", categoria);
		return super.findOneResult(Artigo.SELECT_ULTIMO_REGISTRO_POR_CATEGORIA,parameters);
	}

	public List<Artigo> pesquisaComLazy(int inicio, int maxPorPagina) {
		return super.findManyResults(Artigo.SELECT_ULTIMOS_REGISTROS, parameters, inicio, maxPorPagina);
	}

	public List<Artigo> perquisaDestaque() {
		return super.findManyResults(Artigo.SELECT_DESTAQUES, parameters, null, 5);
	}

	public List<Artigo> perquisaDestaqueCategoria(Long categoria) {
		parameters.clear();
		parameters.put("param1", categoria);
		return super.findManyResults(Artigo.SELECT_DESTAQUES_CATEGORIA, parameters, null, 5);
	}

	public List<Artigo> pesquisaMateriaPorMunicipio(Long municipio) {
		parameters.clear();
		parameters.put("param1", municipio);
		return super.findManyResults(Artigo.SELECT_DESTAQUES_CATEGORIA, parameters, null, null);
	}

	public List<Artigo> pesquisaCarrosel(Long categoria) {
		parameters.clear();
		parameters.put("param1", categoria);
		return super.findManyResults(Artigo.SELECT_POR_CATEGORIA_CARROSEL, parameters, null, 5);
	}
}
