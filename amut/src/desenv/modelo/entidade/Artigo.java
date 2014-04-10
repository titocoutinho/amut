package desenv.modelo.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.auxiliar.Modelo;

@Entity
@Table(name = "artigo")
@Where(clause = " deletado = 'NAO' ")
@NamedQueries({
		@NamedQuery(name = "Artigo.select_Primeiro_Artigo", query = "Select a From Artigo a order by a.id desc"),
		@NamedQuery(name = "Artigo.select_Por_Categoria", query = "SELECT a FROM Artigo a WHERE a.categoria.id =:param1 order by a.id desc "),
		@NamedQuery(name = "Artigo.select_Por_Categoria_Carrosel", query = "SELECT a FROM Artigo a WHERE a.destaque = desenv.modelo.auxiliar.Boleano.SIM and a.categoria.id =:param1"),
		@NamedQuery(name = "Artigo.select_Por_Artigo_E_Categoria", query = "SELECT a FROM Artigo a WHERE a.categoria.id =:param1 and a.id =:param2"),
		@NamedQuery(name = "Artigo.select_Ultimos_Registros", query = "SELECT a FROM Artigo a order by a.id desc"),
		@NamedQuery(name = "Artigo.select_Ultimo_Registro_Por_Categoria", query = "SELECT a FROM Artigo a WHERE a.id = (select max(a.id) from Artigo a) and a.categoria.id =:param1 order by a.id desc "),
		@NamedQuery(name = "Artigo.select_Destaques", query = "SELECT a FROM Artigo a WHERE a.destaque = desenv.modelo.auxiliar.Boleano.SIM"),
		@NamedQuery(name = "Artigo.select_Destaques_Categoria", query = "SELECT a FROM Artigo a WHERE a.destaque = desenv.modelo.auxiliar.Boleano.SIM and a.categoria.id =:param1 ORDER BY a.id desc"),
		@NamedQuery(name = "Artigo.select_Materia_Muminicipio", query = "select a from Artigo a where a.destaque =desenv.modelo.auxiliar.Boleano.NAO and a.municipio.id =:param1 ORDER BY a.id desc ") })
public class Artigo extends Modelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SELECT_PRIMEIRO_ARTIGO = "Artigo.select_Primeiro_Artigo";
	public static final String SELECT_POR_CATEGORIA = "Artigo.select_Por_Categoria";
	public static final String SELECT_POR_CATEGORIA_CARROSEL = "Artigo.select_Por_Categoria_Carrosel";
	public static final String SELECT_POR_ARTIGO_E_CATEGORIA = "Artigo.select_Por_Artigo_E_Categoria";
	public static final String SELECT_ULTIMOS_REGISTROS = "Artigo.select_Ultimos_Registros";
	public static final String SELECT_ULTIMO_REGISTRO_POR_CATEGORIA = "Artigo.select_Ultimo_Registro_Por_Categoria";
	public static final String SELECT_DESTAQUES = "Artigo.select_Destaques";
	public static final String SELECT_DESTAQUES_CATEGORIA = "Artigo.select_Destaques_Categoria";
	public static final String SELECT_MATERIA_MUNICIPIO = "Artigo.select_Materia_Muminicipio";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String corpo;
	@Enumerated(EnumType.STRING)
	@Column(name = "destaque")
	private Boleano destaque = Boleano.NAO;

	@ManyToOne
	private Municipio municipio;

	@ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	private Galeria galeria = new Galeria();

	@ManyToOne
	private Categoria categoria ;

	public Artigo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public Boleano getDestaque() {
		return destaque;
	}

	public void setDestaque(Boleano destaque) {
		this.destaque = destaque;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Galeria getGaleria() {
		return galeria;
	}

	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		if (!(obj instanceof Artigo))
			return false;
		Artigo other = (Artigo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return titulo;
	}

}
