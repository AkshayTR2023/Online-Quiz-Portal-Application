import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.dao.ScoreDao;
import com.app.dao.UserDao;
import com.app.pojo.Question;
import com.app.pojo.Quiz;
import com.app.pojo.User;

public class QuizSubmitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        List<Integer> userAnswers = new ArrayList<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        List<Question> questionList = QuestionDao.getQuestionsByQuizId(quizId);

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("answer")) {
                int answer = Integer.parseInt(request.getParameter(paramName));
                userAnswers.add(answer);
            }
        }
       HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
             
//        User user = UserDao.getUserById(email) ;
//        Quiz quiz=QuizDao.getQuizById(quizId);
        int netScore=0;
        for(int i=0;i<questionList.size();i++) {
        Question question = questionList.get(i);
        if (question.getCorrectOption() == userAnswers.get(i)) {
             netScore++;
        }
        
        }
         
        ScoreDao.addScore(netScore, quizId, email);
        request.setAttribute("userAnswers", userAnswers);
        request.setAttribute("questionList", questionList);
        request.setAttribute("quizId", quizId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayResult.jsp");
        dispatcher.forward(request, response);
    }
    }
