package desenv.modelo.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "dado")
@Where(clause = "deletado = 'NAO'")
@NamedQueries({
		@NamedQuery(name = "Dado.PESQUISA_POR_MUNICIPIO", query = "select d from Dado d where d.municipio.id=:param1"),
		@NamedQuery(name = "Dado.PESQUISA_POR_CARACTERISTICA", query = "select d from Dado d where d.caracteristica.id=:param1")

})
public class Dado extends Modelo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PESQUISA_POR_MUNICIPIO = "Dado.PESQUISA_POR_MUNICIPIO";
	public static final String PESQUISA_POR_CARACTERISTICA = "Dado.PESQUISA_POR_CARACTERISTICA";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String valor;
	private Integer prioridade;
	@ManyToOne
	private Caracteristica caracteristica;
	@ManyToOne
	private Municipio municipio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((caracteristica == null) ? 0 : caracteristica.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dado other = (Dado) obj;
		if (caracteristica == null) {
			if (other.caracteristica != null)
				return false;
		} else if (!caracteristica.equals(other.caracteristica))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return getValor();
	}
}
