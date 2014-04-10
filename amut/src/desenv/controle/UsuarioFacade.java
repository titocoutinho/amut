package desenv.controle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.controle.auxiliar.GenericFacade;
import desenv.controle.auxiliar.IGenericFacade;
import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.entidade.Usuario;
import desenv.modelo.persistencia.UsuarioDAO;

public class UsuarioFacade extends GenericFacade<Usuario> implements
		Serializable, IGenericFacade<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDAO = new UsuarioDAO();

	public UsuarioFacade() {
		setClasseDAO(userDAO);
	}

	public Usuario isValidLogin(String email, String password) {
		userDAO.beginTransaction();
		Usuario user = userDAO.pesquisaEmail(email);
		if (user == null || !user.getSenha().equals(password)) {
			return null;
		}

		return user;
	}

	public List<Usuario> pesquisaPorFiltro(String nome, String email,
			Boleano admin, Boleano ativo) {
		userDAO.beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (email.length() >= 1 ) {
			parameters.put("email", email);
		}

		if (nome.length() >= 1 ) {
			parameters.put("nome", nome);
		}

		return userDAO.filtrados(parameters);
	}

}
