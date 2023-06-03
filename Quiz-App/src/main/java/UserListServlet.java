

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojo.User;
import com.app.dao.UserDao;

public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = UserDao.getAllUsers();
		request.setAttribute("userList", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userOperation.jsp");
        dispatcher.forward(request, response);
	}

	
}
