import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AdminDao;


	public class AdminLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        response.setContentType("text/html");
	        PrintWriter pw=response.getWriter();
	        boolean check=AdminDao.loginAdmin(email, password);

	        if (check) {
	            HttpSession httpSession = request.getSession();
	            httpSession.setAttribute("email", email);
	            response.sendRedirect("adminDashboard.jsp");
	        } 
	        else {
	            pw.write("Wrong Credentials! Please try again.");
	            request.getRequestDispatcher("adminLogin.jsp").include(request, response);
	        }
	    }
}