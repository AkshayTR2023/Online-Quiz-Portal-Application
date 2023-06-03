import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.QuestionDao;
import com.app.pojo.Question;

@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("id"));
        Question question = QuestionDao.getQuestionById(questionId);
        request.setAttribute("question", question);
        request.getRequestDispatcher("editQuestion.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("id"));
        String updatedQuestion = request.getParameter("question");
        String updatedOption1 = request.getParameter("option1");
        String updatedOption2 = request.getParameter("option2");
        String updatedOption3 = request.getParameter("option3");
        String updatedOption4 = request.getParameter("option4");
        int updatedCorrectOption = Integer.parseInt(request.getParameter("correctOption"));

        Question question = QuestionDao.getQuestionById(questionId);
        question.setQuestion(updatedQuestion);
        question.setOption1(updatedOption1);
        question.setOption2(updatedOption2);
        question.setOption3(updatedOption3);
        question.setOption4(updatedOption4);
        question.setCorrectOption(updatedCorrectOption);

        QuestionDao.updateQuestion(question);

        response.sendRedirect("QuestionListServlet");
    }
}
