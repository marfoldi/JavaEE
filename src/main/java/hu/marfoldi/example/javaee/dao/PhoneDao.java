package hu.marfoldi.example.javaee.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;

import hu.marfoldi.example.javaee.model.Dude;
import hu.marfoldi.example.javaee.model.Phone;

/**
 * @author marfoldi
 */

@Stateless
public class PhoneDao {

	@PersistenceContext(unitName = "JAVAEE_PU")
	private EntityManager entityManager;

	/**
	 * looks up the phone numbers of the given dude
	 * 
	 * @param dude
	 * @return a list of phone numbers
	 */
	public List<Phone> getPhonesByDude(Dude dude) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Phone> query = criteriaBuilder.createQuery(Phone.class);
		Root<Phone> from = query.from(Phone.class);
		Path<Dude> personField = from.get("dude");
		Predicate personPredicate = criteriaBuilder.equal(personField, dude);
		query.where(personPredicate);
		return entityManager.createQuery(query).getResultList();
	}

}