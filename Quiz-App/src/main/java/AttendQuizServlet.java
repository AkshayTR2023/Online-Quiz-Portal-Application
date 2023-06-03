import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.QuizDao;
import com.app.pojo.Quiz;

public class AttendQuizServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        Quiz quiz = QuizDao.getQuizById(quizId); 

        
        request.setAttribute("quiz", quiz);
        request.setAttribute("quizId", quizId);
        request.getRequestDispatcher("attendQuiz.jsp").forward(request, response);
    }
}
