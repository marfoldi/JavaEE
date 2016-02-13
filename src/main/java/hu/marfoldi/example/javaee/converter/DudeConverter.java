package hu.marfoldi.example.javaee.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import hu.marfoldi.example.javaee.dao.BaseDao;
import hu.marfoldi.example.javaee.model.Dude;

/**
 * @author marfoldi
 */

@Named
public class DudeConverter implements Converter {

	@Inject
	private BaseDao baseDao;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		return baseDao.find(Dude.class, Long.parseLong(s));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		return ((Dude) o).getId().toString();
	}
}