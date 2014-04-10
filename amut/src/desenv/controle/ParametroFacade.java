package desenv.controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.entidade.Parametro;
import desenv.modelo.persistencia.ParametroDAO;

public class ParametroFacade extends GenericFacade<Parametro> implements
		Serializable, IGenericFacade<Parametro> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParametroDAO dao = new ParametroDAO();

	public ParametroFacade() {
		setClasseDAO(dao);
	}

	public List<Parametro> pesquisaPorFiltro(String nome) {
		dao.beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();

		

		if (nome.length() >= 1 ) {
			parameters.put("nomeParametro", nome);
		}

		return dao.filtrados(parameters);
	}
}
