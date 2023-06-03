import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDao;

public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        boolean check=UserDao.addUser(email, name, password);
        if (check) {   //if true is returned new user is added successfully..     
        pw.write("Account created successfully.");
        request.getRequestDispatcher("userLogin.jsp").include(request, response); 
        }
        else {// if false, user already exists...
        	           	
                pw.write("Email already exists. Please register with a different email.");
                request.getRequestDispatcher("register.jsp").include(request, response);
        }    
    }
}