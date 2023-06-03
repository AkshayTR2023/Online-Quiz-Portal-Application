import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.QuizDao;
import com.app.pojo.Quiz;

@WebServlet("/DeleteQuizServlet")
public class DeleteQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("id"));
        Quiz quiz = QuizDao.getQuizById(quizId);
        QuizDao.deleteQuiz(quiz);
        response.sendRedirect("QuizListServlet");
    }
}
