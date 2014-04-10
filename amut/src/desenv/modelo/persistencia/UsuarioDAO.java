package desenv.modelo.persistencia;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> implements
IGenericDAO<Usuario> {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> parameters = new HashMap<String, Object>();
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

	
	public Usuario pesquisaEmail(String email) {
		parameters.clear();
		parameters.put("email", email);
		return super.findOneResult(Usuario.PESQUISA_EMAIL, parameters);
	}
	

	public Usuario esqueciMinhaSenha(String email, Date nascimento){
		parameters.clear();
		parameters.put("email", email);
		parameters.put("nascimento", nascimento);
		return super.findOneResult(Usuario.ESQUECI_SENHA, parameters);
	}
	public Usuario pesquisaCPF(String cpf) {
		parameters.clear();
		parameters.put("cpf", cpf);
		return super.findOneResult(Usuario.PESQUISA_CPF, parameters);
	}
	public Usuario autenticar(String usuario, String senha) {
		parameters.clear();
		parameters.put("usuario", usuario);
		parameters.put("senha",   senha);
		parameters.put("excluido", Boleano.NAO);
		return super.findOneResult(Usuario.AUTENTICACAO, parameters);
	}
}
