import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDao;
import com.app.pojo.User;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter("id");
        User user= UserDao.getUserById(email);
        request.setAttribute("user", user);
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String email= request.getParameter("id");
        String updatedName = request.getParameter("name");
        String updatedPassword = request.getParameter("password");
        User user= UserDao.getUserById(email);
        user.setName(updatedName);
        user.setPassword(updatedPassword);
        UserDao.updateUser(user);

        response.sendRedirect("UserListServlet");
    }
}
