package packa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Payment
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String state = null;
	String sessionState = null;
	Cookie responseCookie;
	boolean complete=false;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sessionState = (String)session.getAttribute("state");
		if(sessionState == null){
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
			if ((state.equals(sessionState) == true) || (complete==true))
			{
				session.setAttribute("state", "PAYMENT");
				responseCookie.setValue("PAYMENT");
				response.addCookie(responseCookie);
				response.getWriter().write("To finalize your payment ://localhost:7001/HomeWork3/Completed");
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


	}
}


