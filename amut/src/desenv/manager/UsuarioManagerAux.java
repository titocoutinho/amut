package desenv.manager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.entidade.Usuario;


@SessionScoped
@ManagedBean(name="usuarioManagerAux")
public class UsuarioManagerAux implements Serializable{

	/**
	 * 
	 */
	public static final String INJECTION_NAME = "#{usuarioManagerAux}";
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public boolean isAdmin(){
		if(usuario.getAdministrador() == Boleano.SIM){
			return true;
		}
	
		return false;
	}

	public String logOut() {
		getRequest().getSession().invalidate();
		return "/login.xhtml";
	}
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
