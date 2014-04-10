package desenv.modelo.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import desenv.modelo.auxiliar.Boleano;
import desenv.modelo.auxiliar.Modelo;


@Entity
@Table(name="galeria")
@Where(clause="deletado = 'NAO'")
public class Galeria extends Modelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@Lob @Type(type = "org.hibernate.type.TextType")
	private String descricao;
	private String diretorio;
	private Boleano ativa = Boleano.SIM;
	@OneToMany(mappedBy="galeria", cascade=CascadeType.ALL)
	@Where(clause="deletado = 'NAO'")
	private List<Imagem> imagens = new ArrayList<Imagem>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public String getThumb(){
		return titulo.replace(".png", "").replace(".jpg", "").replace(".gif", "").concat(".thumb.png");
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Boleano getAtiva() {
		return ativa;
	}
	public void setAtiva(Boleano ativa) {
		this.ativa = ativa;
	}
	
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Galeria)) {
			return false;
		}
		Galeria other = (Galeria) obj;
		
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (diretorio == null) {
			if (other.diretorio != null) {
				return false;
			}
		} else if (!diretorio.equals(other.diretorio)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (imagens == null) {
			if (other.imagens != null) {
				return false;
			}
		} else if (!imagens.equals(other.imagens)) {
			return false;
		}
		if (titulo == null) {
			if (other.titulo != null) {
				return false;
			}
		} else if (!titulo.equals(other.titulo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Galeria [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", diretorio=" + diretorio + ", imagens=" + imagens + ", versao=" + getVersao() + ", criado="
				+ super.getCriado()+ ", modificado=" + getModificado() + "]";
	}
	
}
