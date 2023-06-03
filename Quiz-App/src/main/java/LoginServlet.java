import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.dao.UserDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        boolean check=UserDao.loginUser(email, password);

        if (check) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("email", email);
            response.sendRedirect("userDashboard.jsp");
        } 
        else {
            pw.write("Wrong Credentials! Please try again.");
            request.getRequestDispatcher("userLogin.jsp").include(request, response);
        }
    }
}