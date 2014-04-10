package desenv.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import desenv.controle.UsuarioFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.modelo.entidade.Usuario;


@RequestScoped
@ManagedBean
public class LoginManager extends AbstractBean {
	
	
	@ManagedProperty(value = UsuarioManagerAux.INJECTION_NAME)
	private UsuarioManagerAux usuarioManager;

	private String email;
	private String password;
	
	public LoginManager() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String login() {
		UsuarioFacade userFacade = new UsuarioFacade();

		Usuario user = userFacade.isValidLogin(email, password);
		
		if(user != null){
			usuarioManager.setUsuario(user);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			request.getSession().setAttribute("user", user);
			return "/admin/index.xhtml";
		}

		displayErrorMessageToUser("Favor verificar email/senha");
		
		return null;
	}
	
	
	public void setUsuarioManager(UsuarioManagerAux usuarioManager) {
		this.usuarioManager = usuarioManager;
	}
}
