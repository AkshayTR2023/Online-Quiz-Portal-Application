import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDao;


public class UserPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String oldPwd=request.getParameter("oldPwd");
	String newPwd=request.getParameter("newPwd");
	 response.setContentType("text/html");
     PrintWriter pw=response.getWriter();
	boolean check=UserDao.changeUserPwd(email,oldPwd,newPwd);
	 if (check) {
		 pw.write("Password changed successfully!");
		 request.getRequestDispatcher("userLogin.jsp").include(request, response);
     } 
     else {
         pw.write("Wrong Credentials! Please try again.");
         request.getRequestDispatcher("pwdChange.jsp").include(request, response);
     }
	
	}

}
