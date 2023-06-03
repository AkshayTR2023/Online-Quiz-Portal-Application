import com.app.pojo.QuizScore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.app.dao.ScoreDao;
public class LeaderboardServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int quizId = Integer.parseInt(request.getParameter("quizId"));
    	 List<QuizScore> leaderboard=ScoreDao.getLeaderBoard(quizId);
    	 
    	 request.setAttribute("leaderboard", leaderboard);
    	 request.getRequestDispatcher("leaderboard.jsp").forward(request, response);
    }
}
