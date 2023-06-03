import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CategoryDao;
import com.app.pojo.Category;

@WebServlet("/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryDao.getCategoryById(categoryId);
        request.setAttribute("category", category);
        request.getRequestDispatcher("editCategory.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        String updatedName = request.getParameter("name");

        Category category = CategoryDao.getCategoryById(categoryId);
        category.setName(updatedName);        
        CategoryDao.updateCategory(category);

        response.sendRedirect("CategoryListServlet");
    }
}
