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

public class AddQuizServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Category> categoryList = CategoryDao.getAllCategories();

	        request.setAttribute("categoryList", categoryList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("addQuiz.jsp");
	        dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");   
        int categoryId = Integer.parseInt(request.getParameter("category")); 
        Category category = CategoryDao.getCategoryById(categoryId);
        
        
        // Save the quiz to the database using DAO class
        // with category
        int quizId=QuizDao.addQuiz(name, category);
        

        // Redirect to the addQuestions.jsp passing the quiz ID
        response.sendRedirect("addQuestion.jsp?quizId=" + quizId);
    }
}