
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDao;


public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        response.setContentType("text/html");
	        PrintWriter pw=response.getWriter();
	        boolean check=UserDao.addUser(email, name, password);
	        if (check) {   //if true is returned new user is added successfully..     
	       
	        response.sendRedirect("UserListServlet");
	        }
	        else {// if false, user already exists...
	        	           	
	                pw.write("Email already exists.Please use a different email.");
	                request.getRequestDispatcher("addUser.jsp").include(request, response);
	        }    

}}
