package desenv.modelo.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.auxiliar.Modelo;
import desenv.util.String.TrataTexto;

@Entity
@Table(name = "municipio")
@Where(clause = "deletado = 'NAO'")
@NamedQueries({
	@NamedQuery(name="Municipio.SELECT_POR_NOME", query="SELECT o FROM Municipio o where TRANSLATE(UPPER(o.nome), '¡…Õ”⁄¿»Ã“Ÿ¬ Œ‘€√’ƒÀœ÷‹«—Y›' , 'AEIOUAEIOUAEIOUAOAEIOUCNYY' ) like ':nomeMunicipio' ")
	
})
public class Municipio extends Modelo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MUNICIPIO_POR_NOME = "Municipio.SELECT_POR_NOME";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sigla;
	@OneToMany(mappedBy = "municipio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(value = "prioridade")
	private List<Dado> dados = new ArrayList<Dado>();
	@OneToMany(mappedBy = "municipio")
	@Where(clause = "deletado = 'NAO'")
	private List<Artigo> artigos;
	
	private Boleano ativo;

	public Municipio() {
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

	public String getNomeSemAcento() {
		return TrataTexto.removeAccents(getNome());
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Dado> getDados() {
		return dados;
	}

	public void setDados(List<Dado> dados) {
		this.dados = dados;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	public Boleano getAtivo() {
		return ativo;
	}
	public void setAtivo(Boleano ativo) {
		this.ativo = ativo;
	}


	@Override
	public int hashCode() {
		int hash = 5;
		hash = (int) (41 * hash + getId().intValue());
		return hash;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Municipio)) {
			return false;
		}
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return getNome();
	}
}
