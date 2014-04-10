package desenv.modelo.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "categoria")
@Where(clause = " deletado = 'NAO' ")
@NamedQueries({
	@NamedQuery(name="Categoria.CONSULTA_MENU", query="select o from Categoria o where o.ativo = true order by o.prioridade asc"),
	@NamedQuery(name="Categoria.CONSULTA_MENU_TOTAL", query="select o from Categoria o where o.pai = null order by o.prioridade asc")
})
public class Categoria extends Modelo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CONSULTA_MENU = "Categoria.CONSULTA_MENU";
	public static final String CONSULTA_MENU_TOTAL = "Categoria.CONSULTA_MENU_TOTAL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private boolean ativo;
	private Integer prioridade;
	private String urlDefinida;
	@ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "id_categiria_pai", referencedColumnName = "id", updatable = true, insertable = true)
	private Categoria pai;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "pai", fetch=FetchType.LAZY)
	@Where(clause = " deletado = 'NAO' ")
	private List<Categoria> subcategorias;

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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getUrlDefinida() {
		return urlDefinida;
	}

	public void setUrlDefinida(String urlDefinida) {
		this.urlDefinida = urlDefinida;
	}

	

	public Categoria getPai() {
		return pai;
	}

	public void setPai(Categoria pai) {
		this.pai = pai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
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
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return nome;
	}
}
