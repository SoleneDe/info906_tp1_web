package tp1WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.Colis;
import ejb.ColisOperation;

/**
 * Servlet implementation class DisplayColisServlet
 */
@WebServlet("/display")
public class DisplayColisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ColisOperation ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayColisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		long id_long = Long.parseLong(id); 
		
		Colis colis = ejb.getColis(id_long);
		
		if (colis == null)
		{
			request.setAttribute("error", "Le colis n'existe pas");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("colis", colis);
			request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

