package desenv.modelo.auxiliar;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class GenericDAO<T extends Modelo> implements Serializable,
		IGenericDAO<T> {
	private static final long serialVersionUID = 1L;

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("site_amutUP");
	private EntityManager em;
	private Class<T> entityClass;

	@Override
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	@Override
	public void commit() {
		em.getTransaction().commit();
	}

	@Override
	public void rollback() {
		em.getTransaction().rollback();
	}

	@Override
	public void closeTransaction() {
		em.close();
	}

	@Override
	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public void joinTransaction() {
		em = emf.createEntityManager();
		em.joinTransaction();
	}

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		beginTransaction();
		em.persist(entity);
		commit();
	}

	public void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);
beginTransaction();
		em.remove(entityToBeRemoved);
		commit();
	}

	@Override
	public T update(T entity) {
		beginTransaction();
		return em.merge(entity);
		
	}

	@Override
	public T find(Long entityID) {
		beginTransaction();
		return em.find(entityClass, entityID);
	}

	@Override
	public T findReferenceOnly(Long entityID) {
		beginTransaction();
		return em.getReference(entityClass, entityID);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		beginTransaction();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> filtrados(Map<String, Object> parameters) {
		beginTransaction();
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(entityClass);
		for (Entry<String, Object> entry : parameters.entrySet()) {
System.out.println("CHAVE = "+ entry.getKey()+ " VALOR = "+entry.getValue());
			criteria.add(Restrictions.like(entry.getKey(), entry.getValue()));

		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		beginTransaction();
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para a pesquisa: "
					+ namedQuery);
		} catch (Exception e) {
			System.out.println("erro duranta execução da consulta: "
					+ e.getMessage());
			e.printStackTrace();
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findManyResults(String namedQuery, Map<String, Object> parameters, Integer start, Integer size) {
		beginTransaction();
		List<T> results = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			if(start != null){
				query.setFirstResult(start);
			}
			if(size != null){
				query.setMaxResults(size);
			}
			
			results = (List<T>) query.getResultList();

		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para a pesquisa: "
					+ namedQuery);
		} catch (Exception e) {
			System.out.println("erro duranta execução da consulta: "
					+ e.getMessage());
			e.printStackTrace();
		}
		return results;
	}

	private void populateQueryParameters(Query query,
			Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	public EntityManager getEm() {
		return em;
	}
}
