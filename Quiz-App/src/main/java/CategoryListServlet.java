import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CategoryDao;
import com.app.pojo.Category;

public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of categories from the database using DAO class
        List<Category> categoryList = CategoryDao.getAllCategories();

        request.setAttribute("categoryList", categoryList);

        // Forward the request to the JSP page to display the Categories
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryList.jsp");
        dispatcher.forward(request, response);
    }
}
