package packa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Completed
 */
public class Completed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sessionState = null;
	String state = null;
	Cookie responseCookie;
	boolean complete=false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Completed() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sessionState = (String)session.getAttribute("state");
		if((sessionState == null) || (sessionState==null)){
			response.getWriter().write("Wrong Session");
		}
		else 
		{
			state = (String)session.getAttribute("state");
			Cookie[] Cookies = request.getCookies();
			if(Cookies != null){
				for(Cookie cookie : Cookies){
					if(cookie.getName().equals("state"))
					{
						responseCookie=cookie;
						state = cookie.getValue();
					}
				}
			}
			if ((state.equals(sessionState) == true))
			{
				session.setAttribute(state, "COMPLETED");
				responseCookie.setValue("COMPLETED");
				responseCookie.setMaxAge(0);
				response.addCookie(responseCookie);
				response.getWriter().write("Payment completed");	
				if (complete == true)
					session.invalidate();
				complete=true;
			}
			else

			{
				response.getWriter().write("Error, start again from New");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
