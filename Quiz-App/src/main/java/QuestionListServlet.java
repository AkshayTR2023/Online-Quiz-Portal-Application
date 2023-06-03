import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CategoryDao;
import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.pojo.Category;
import com.app.pojo.Question;
import com.app.pojo.Quiz;

public class QuestionListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = CategoryDao.getAllCategories();

        request.setAttribute("categories", categories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("questionList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String categoryId = request.getParameter("category");
        String quizId = request.getParameter("quiz");

        if (categoryId != null && !categoryId.isEmpty()) {
            int categoryID = Integer.parseInt(categoryId);

            // Retrieve the selected category using the categoryID
            Category selectedCategory = CategoryDao.getCategoryById(categoryID);

            // Retrieve the quizzes for the selected category
            List<Quiz> quizzes = QuizDao.getQuizzesByCategory(selectedCategory);

            // Set the selected category and quizzes as attributes in the session
            session.setAttribute("selectedCategory", selectedCategory);
            session.setAttribute("quizzes", quizzes);
            session.removeAttribute("selectedQuiz"); // Clear the selected quiz from the session
        }

        if (quizId != null && !quizId.isEmpty()) {
            int quizID = Integer.parseInt(quizId);

            // Retrieve the selected quiz using the quizID
            Quiz selectedQuiz = QuizDao.getQuizById(quizID);

            // Retrieve the questions for the selected quiz
            List<Question> questions = QuestionDao.getQuestionsByQuizId(quizID);

            // Set the selected quiz and questions as attributes in the session
            session.setAttribute("selectedQuiz", selectedQuiz);
            session.setAttribute("questions", questions);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("questionList.jsp");
        dispatcher.forward(request, response);
    }


}
