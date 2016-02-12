package hu.marfoldi.example.javaee;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**    
* @author marfoldi
*/

@WebServlet(urlPatterns = "/dudeServlet")
public class DudeServlet extends HttpServlet {

	private static final long serialVersionUID = 8781511330610190027L;
	@Inject
	private DudeBean dudeBean;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		dudeBean.setName(httpServletRequest.getParameter("name"));
		httpServletResponse.sendRedirect("index.jsp");
	}
}
