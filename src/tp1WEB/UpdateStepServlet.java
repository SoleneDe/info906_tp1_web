package tp1WEB;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.Colis;
import ejb.State;
import ejb.ColisOperation;

@WebServlet("/updateStep")
public class UpdateStepServlet extends HttpServlet {
	private static final long serialVersionUID = -8366312455962170412L;
	
	@EJB
	private ColisOperation ejb;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStepServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idColis_temp = request.getParameter("idColis");
		String lat_temp = request.getParameter("latitude");
		String long_temp = request.getParameter("longitude");
		String place = request.getParameter("place");
		String state_temp = request.getParameter("state");

		long idColis = Long.parseLong(idColis_temp);
		double lat = Double.parseDouble(lat_temp);
		double lon = Double.parseDouble(long_temp);
		State state = State.valueOf(state_temp);
		
		Colis colis = ejb.updateProgress(idColis, state, lat, lon, place);
		
		request.setAttribute("colis", colis);
		request.getRequestDispatcher("/AfficherColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
