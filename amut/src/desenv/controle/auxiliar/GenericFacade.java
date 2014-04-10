package desenv.controle.auxiliar;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.auxiliar.Modelo;

public class GenericFacade<T extends Modelo> implements Serializable,
		IGenericFacade<T> {

	private static final long serialVersionUID = 1L;
	protected Map<String, Object> parameters = new HashMap<String, Object>();
	private IGenericDAO<T> classeDAO;
	private Class<T> entidade;
	private T objeto;

	

	public GenericFacade() {
		
	}

	@Override
	public void salvar(T entidade) {
		
		classeDAO.save(entidade);
		
	}

	@Override
	public void atualizar(T entidade) {
		
		objeto = classeDAO.find(entidade.getId());
		
	}

	public static Object clone(Object o) {
		Object clone = null;
		try {
			clone = o.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		for (@SuppressWarnings("rawtypes")
		Class obj = o.getClass(); !obj.equals(Object.class); obj = obj
				.getSuperclass()) {
			Field[] fields = obj.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				try {
					fields[i].set(clone, fields[i].get(o));
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
			}
		}
		return clone;
	}

	@Override
	public T procurar(Long entidadeID) {
		classeDAO.beginTransaction();
		T objeto = classeDAO.find(entidadeID);
		classeDAO.closeTransaction();
		return objeto;
	}

	@Override
	public List<T> listarTudo() {

		classeDAO.beginTransaction();
		List<T> result = classeDAO.findAll();
		classeDAO.commit();
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void deletePerson(T entidade) {
		classeDAO.beginTransaction();
		objeto = classeDAO.findReferenceOnly(entidade.getId());
		try {
			classeDAO.delete(objeto,
					(Class<T>) Class.forName(objeto.getClass().getName()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		classeDAO.commit();

	}

	public IGenericDAO<T> getClasseDAO() {
		return classeDAO;
	}

	public void setClasseDAO(IGenericDAO<T> classeDAO) {
		this.classeDAO = classeDAO;
	}

	public Class<T> getEntidade() {
		return entidade;
	}

	public void setEntidade(Class<T> entidade) {
		this.entidade = entidade;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
}
