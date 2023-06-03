import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LeaderboardSelectQuizServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        
        // Store the selected category ID in a session attribute
        request.getSession().setAttribute("categoryId", categoryId);
        
        // Redirect to the page for selecting the quiz
        response.sendRedirect("leaderboardSelectQuiz.jsp");
    }
}
