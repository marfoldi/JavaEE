package hu.marfoldi.example.javaee;

import org.junit.Before;

/**
 * @author marfoldi
 */
public class DudeBeanTest {
	
	private DudeBean testDude;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testDude = new DudeBean();
	}
}
