package desenv.modelo.auxiliar;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Modelo implements Serializable, IModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Column(name = "versao")
	Integer versao =0;

	
	@Column(name = "data_criacao", updatable = false, nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	Date criado = new Date();

	@Column(name = "data_atuaizacao", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date modificado ;//= new Date();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "deletado")
	private Boleano excluido = Boleano.NAO; // sim = 1, não = 2

	

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public Boleano getExcluido() {
		return excluido;
	}

	public void setExcluido(Boleano excluido) {
		this.excluido = excluido;
	}

	@Override
	public Long getId() {
		
		return null;
	}

	@Override
	public void setId(Long id) {
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T clone(T object) {
	    T clone = null;
	    try {
	        /*
	         * instanciando o objeto clone de  acordo com o objeto passado por
	         * parâmetro
	         */
	        clone = (T) object.getClass().newInstance();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    }
	 
	    // Obter o tipo de classe atual, quando acabar, passar para a super
	    // classe, até chegar em Object.
	    for (Class obj = object.getClass(); !obj.equals(Object.class); obj = obj
	            .getSuperclass()) {
	        // Percorrer campo por campo da classe...
	        for (Field field : obj.getDeclaredFields()) {
	            field.setAccessible(true);
	            try {
	                // Copiar campo atual
	                field.set(clone, field.get(object));
	            } catch (Throwable t) {
	            }
	        }
	 
	    }
	    return clone;
	}

	
}
