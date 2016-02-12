package hu.marfoldi.example.javaee;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**    
* @author marfoldi
*/

@Named
@SessionScoped
public class DudeBean implements Serializable {

	private static final long serialVersionUID = -7119391660576122911L;
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
