package desenv.modelo.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "caracteristica")
@Where(clause = "deletado = 'NAO'")
public class Caracteristica extends Modelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCaracteristica;

	private boolean ativo;
	@OneToMany(mappedBy = "caracteristica")
	@Where(clause = "deletado = 'NAO'")
	private List<Dado> dados;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCaracteristica() {
		return nomeCaracteristica;
	}
	public void setNomeCaracteristica(String nomeCaracteristica) {
		this.nomeCaracteristica = nomeCaracteristica;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Dado> getDados() {
		return dados;
	}
	public void setDados(List<Dado> dados) {
		this.dados = dados;
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
		if (!(obj instanceof Caracteristica))
			return false;
		Caracteristica other = (Caracteristica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getNomeCaracteristica();
	}
}
