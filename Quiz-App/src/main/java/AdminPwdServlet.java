import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.AdminDao;


public class AdminPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String oldPwd=request.getParameter("oldPwd");
	String newPwd=request.getParameter("newPwd");
	 response.setContentType("text/html");
     PrintWriter pw=response.getWriter();
	boolean check=AdminDao.changeUserPwd(email,oldPwd,newPwd);
	 if (check) {
		 pw.write("Password changed successfully!");
		 request.getRequestDispatcher("adminLogin.jsp").include(request, response);
     } 
     else {
         pw.write("Wrong Credentials! Please try again.");
         request.getRequestDispatcher("adminPwdChange.jsp").include(request, response);
     }
	
	}

}
