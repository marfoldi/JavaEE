package hu.marfoldi.example.javaee.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.marfoldi.example.javaee.model.BaseEntity;

/**
 * @author marfoldi
 */

@Stateless
public class BaseDao {

	@PersistenceContext(unitName="JAVAEE_PU")
	private EntityManager entityManager;

	public <E extends BaseEntity> List<E> query(Class<E> entityClass, String queryName) {
		return entityManager.createNamedQuery(queryName, entityClass).getResultList();
	}

	public <E extends BaseEntity> E save(E entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
			return entity;
		} else {
			return entityManager.merge(entity);
		}
	}

}
