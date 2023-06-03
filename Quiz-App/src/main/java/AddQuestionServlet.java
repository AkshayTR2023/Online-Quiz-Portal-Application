import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.pojo.Quiz;

public class AddQuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	int quizId=Integer.parseInt(request.getParameter("quizId"));		
	response.sendRedirect("addQuestion.jsp?quizId=" + quizId);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        int correctOption = Integer.parseInt(request.getParameter("correctOption"));
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        Quiz quiz=QuizDao.getQuizById(quizId);
        
        // Retrieve the quiz ID
        // Save the question to the database using DAO class
        QuestionDao.addQuestion(question, option1, option2, option3, option4, correctOption, quiz);

        // Redirect to the question list page
        //response.sendRedirect("QuestionListServlet");
        response.sendRedirect("addQuestion.jsp?quizId=" + quizId);
    }
}