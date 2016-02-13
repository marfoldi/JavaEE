package hu.marfoldi.example.javaee.service;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import hu.marfoldi.example.javaee.dao.BaseDao;
import hu.marfoldi.example.javaee.model.Dude;

/**
 * @author marfoldi
 */

@Named
public class DudeService {

	@Inject
	private BaseDao baseDao;

	/**
	 * add a dude to the DB
	 * 
	 * @param name
	 * @param birthday
	 */
	public void addDude(String name, Date birthday) {
		Dude dude = new Dude();
		dude.setName(name);
		dude.setBirthday(birthday);
		baseDao.save(dude);
	}

	/**
	 * gets all dudes from DB
	 * 
	 * @return a list of dudes
	 */
	public List<Dude> getDudes() {
		return baseDao.query(Dude.class, Dude.NQ_FIND_ALL_DUDES);
	}

}