package edu.poly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtlis;
import edu.poly.model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtlis.get("username", request);
		if (username!= null && !username.equals("")) {
			request.setAttribute("message", "Login sucessfully!!");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginUser user = new LoginUser();
			BeanUtils.populate(user, request.getParameterMap());
			
			if (user.getUsername().equals("admin")&& user.getPassword().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getPassword());
				request.setAttribute("message", "Login successfully!!");
				
				if (user.isRemember()) {
					CookieUtlis.add("username", user.getUsername(), 2, response);
				}else {
					CookieUtlis.add("username", user.getUsername(), 0, response);
				}
			}else {
				request.setAttribute("message", "Invalid username of password");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);;
	}

}
