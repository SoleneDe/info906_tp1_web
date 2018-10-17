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

@WebServlet("/register")
public class RegisterColisServlet extends HttpServlet {
	private static final long serialVersionUID = -2597763224422778045L;
	
	@EJB
	private ColisOperation ejb;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterColisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weight_temp = request.getParameter("weight");
		String price_temp = request.getParameter("price");
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");

		if ("".equals(weight_temp) || "".equals(price_temp) || "".equals(origin) || "".equals(destination))
		{
			request.setAttribute("error", "Un attribut n'est pas renseigné");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		else
		{
			double weight = Double.parseDouble(weight_temp);
			double price = Double.parseDouble(price_temp);
			
			Colis colis = ejb.createColis(weight, price, origin, destination);

			if (colis == null)
			{
				request.setAttribute("error", "Le colis n'a pas pu être créé");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("colis", colis);	
				request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
