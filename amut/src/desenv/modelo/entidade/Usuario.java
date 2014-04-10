package desenv.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "usuario")
@Where(clause = "deletado = 'NAO'")
@NamedQueries({
		@NamedQuery(name = "Usuario.autenticacao", query = "SELECT p FROM Usuario p WHERE p.email = :usuario AND p.senha = :senha and p.excluido =:excluido  and p.ativo = desenv.modelo.auxiliar.Boleano.SIM"),
		@NamedQuery(name = "Usuario.pesquisa_CPF", query = "SELECT u FROM Usuario u WHERE u.email = :cpf"),
		@NamedQuery(name = "Usuario.esqueci_Senha", query = "SELECT u FROM Usuario u WHERE u.email = :email and u.nascimento = :nascimento"),
		@NamedQuery(name = "Usuario.pesquisa_Email", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario extends Modelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String AUTENTICACAO = "Usuario.autenticacao";
	public static final String PESQUISA_CPF = "Usuario.pesquisa_CPF";
	public static final String ESQUECI_SENHA = "Usuario.esqueci_Senha";
	public static final String PESQUISA_EMAIL = "Usuario.pesquisa_Email";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "nascimento")
	private Date nascimento;
	@Enumerated(EnumType.ORDINAL)
	private Boleano ativo =  Boleano.SIM;
	@Enumerated(EnumType.ORDINAL)
	private Boleano administrador = Boleano.NAO;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNome();
	}

}
