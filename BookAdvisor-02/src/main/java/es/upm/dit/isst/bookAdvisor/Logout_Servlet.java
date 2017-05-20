package es.upm.dit.isst.bookAdvisor;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

public class Logout_Servlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
			if(request.getUserPrincipal()!=null){
				response.sendRedirect(UserServiceFactory.getUserService().createLogoutURL(request.getRequestURI()));
				System.out.println("XXXXXXX");
			}
			else {
				request.getSession().invalidate();
				response.sendRedirect("/index.jsp");
			}
			
		
	}
}
