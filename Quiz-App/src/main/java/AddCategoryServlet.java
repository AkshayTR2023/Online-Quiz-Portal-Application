import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CategoryDao;

public class AddCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");        // Save the Category to the database using DAO class
        CategoryDao.addCategory(name);

        // Redirect to the Category list page
        response.sendRedirect("CategoryListServlet");
    }
}