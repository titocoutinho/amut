package desenv.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "parametro")
@Where(clause = " deletado = 'NAO' ")
@NamedQuery(query="select p from Parametro p where p.nomeParametro =:param1", name = "Parametro.pesquisaPorParametro")
public class Parametro extends Modelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SELECT_POR_PARAMETRO =  "Parametro.pesquisaPorParametro";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_parametro")
	private String nomeParametro;
	@Column(name = "valor_parametro")
	private String valorParametro;
	@Column(name = "grupo_parametro")
	private String grupoParametro;

	public Parametro() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getValorParametro() {
		return valorParametro;
	}

	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}

	public String getGrupoParametro() {
		return grupoParametro;
	}

	public void setGrupoParametro(String grupoParametro) {
		this.grupoParametro = grupoParametro;
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
		if (!(obj instanceof Parametro))
			return false;
		Parametro other = (Parametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNomeParametro();
	}
}
