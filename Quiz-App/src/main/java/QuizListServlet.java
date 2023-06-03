import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CategoryDao;
import com.app.dao.QuizDao;
import com.app.pojo.Category;
import com.app.pojo.Quiz;

public class QuizListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of quizzes from the database using DAO class
        List<Quiz> quizList = QuizDao.getAllQuizzes();
      
        request.setAttribute("quizList", quizList);
  
        // Forward the request to the JSP page to display the quizzes
        RequestDispatcher dispatcher = request.getRequestDispatcher("quizList.jsp");
        dispatcher.forward(request, response);
    }
}
