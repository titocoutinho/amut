package desenv.modelo.auxiliar;

import java.util.List;

public interface IGenericDAO<T> {

	public abstract void beginTransaction();

	public abstract void commit();

	public abstract void rollback();

	public abstract void closeTransaction();

	public abstract void commitAndCloseTransaction();

	public abstract void flush();

	public abstract void joinTransaction();

	public abstract void save(T entity);

	public abstract T update(T entity);

	public abstract T find(Long entityID);

	public abstract T findReferenceOnly(Long entityID);

	public abstract List<T> findAll();
	
	public abstract void delete(Object id, Class<T> classe);

}