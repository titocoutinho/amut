package desenv.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import desenv.modelo.entidade.Categoria;
import desenv.modelo.persistencia.CategoriaDAO;

@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter extends PadraoConverter implements Converter {

	public CategoriaConverter() {
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return new CategoriaDAO().find(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		
		
		try {
			return ((Categoria) objeto).getId().toString();
		} catch (NullPointerException e) {
			return "0";
		}
	}

}
