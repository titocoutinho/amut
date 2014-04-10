package desenv.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import desenv.controle.UsuarioFacade;
import desenv.manager.auxiliar.AbstractBean;
import desenv.manager.auxiliar.IManagerBean;
import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.entidade.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioManager extends AbstractBean implements Serializable, IManagerBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final String USUARIO_SELECIONADO = "usuarioSelecionado";
	
	private Usuario usuario;
	
	private List<Usuario> usuarios;
	private List<Usuario> filtrados = new ArrayList<Usuario>();
	
	private UsuarioFacade facade;
	
	private String nome;
	private String email;
	private Boleano ativo;
	private Boleano administrador;
	

	@Override
	@PostConstruct
	public void load() {
		facade = new UsuarioFacade();
		reset();
		carregarLista();
	}

	@Override
	public void novo() {
		try{
			getFacade().salvar(getUsuario());
			closeDialog();
			displayInfoMessageToUser("Usuário criado com sucesso");
			carregarLista();reset();
		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("ops, nós não conseguimos criar o Usuário, tente novamente!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void pesquisar() {
		try{
			setFiltrados(facade.pesquisaPorFiltro(nome, email, administrador, ativo));
		}catch(Exception e){
			displayErrorMessageToUser("Ops, nós não conseguimos realizar a pesquisa");
			e.printStackTrace();
		}
		
	}

	@Override
	public void reset() {
		usuario = new Usuario();
		
		
	}

	@Override
	public void carregarLista() {
		usuarios = getFacade().listarTudo();
		filtrados = usuarios;
	}
	
	public UsuarioFacade getFacade() {

		return facade;
	}
	public void setFacade(UsuarioFacade facade) {
		this.facade = facade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<Usuario> filtrados) {
		this.filtrados = filtrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boleano getAtivo() {
		return ativo;
	}

	public void setAtivo(Boleano ativo) {
		this.ativo = ativo;
	}

	public Boleano getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boleano administrador) {
		this.administrador = administrador;
	}

	
}
