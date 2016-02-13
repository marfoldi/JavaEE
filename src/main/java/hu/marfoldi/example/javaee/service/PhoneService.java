package hu.marfoldi.example.javaee.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.marfoldi.example.javaee.dao.BaseDao;
import hu.marfoldi.example.javaee.dao.PhoneDao;
import hu.marfoldi.example.javaee.model.Dude;
import hu.marfoldi.example.javaee.model.Phone;
import hu.marfoldi.example.javaee.model.PhoneType;

/**
 * @author marfoldi
 */

@Named
@RequestScoped
public class PhoneService {

	@Inject
	private BaseDao baseDao;

	@Inject
	private PhoneDao phoneDao;

	private Dude dude;

	/**
	 * @return the dude
	 */
	public Dude getDude() {
		return dude;
	}

	/**
	 * @param dude
	 *            the dude to set
	 */
	public void setDude(Dude dude) {
		this.dude = dude;
	}

	/**
	 * adds a new phone number to the dude
	 * 
	 * @param phoneType
	 * @param phoneNumber
	 */
	public void addPhone(String phoneType, String phoneNumber) {
		Phone phone = new Phone();
		phone.setDude(dude);
		phone.setType(PhoneType.valueOf(phoneType));
		phone.setNumber(phoneNumber);
		baseDao.save(phone);
	}

	/**
	 * @return the phone numbers of the dude
	 */
	public List<Phone> getPhones() {
		return phoneDao.getPhonesByDude(dude);
	}

}