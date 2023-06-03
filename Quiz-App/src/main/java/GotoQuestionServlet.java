

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.QuestionDao;
import com.app.pojo.Question;

public class GotoQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> questionList = QuestionDao.getAllQuestions();
		request.setAttribute("questionList", questionList);
		request.getRequestDispatcher("attendQuiz.jsp").forward(request, response);
	}

	

}
