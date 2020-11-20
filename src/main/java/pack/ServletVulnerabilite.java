package pack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVulnerabilite
 */
@WebServlet("/ServletVulnerabilite")
public class ServletVulnerabilite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVulnerabilite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Vulnerabilite v = new Vulnerabilite();
		v.setIdV(Integer.parseInt(request.getParameter("IdV")));
		v.delete();
		response.sendRedirect("admVul.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		if (Integer.parseInt(request.getParameter("IdV")) > 0) {
			Vulnerabilite v = new Vulnerabilite();
			v.setIdV(Integer.parseInt(request.getParameter("IdV")));
			v.setDescription(request.getParameter("description"));
			v.setGravite(Integer.parseInt(request.getParameter("gravite")));
			v.setLogiciels(request.getParameter("logiciels"));
			v.setSynthese(request.getParameter("synthese"));
			v.setTitre(request.getParameter("titre"));
			try {
				v.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admVul.jsp");
		} else {
			Vulnerabilite v = new Vulnerabilite();
			v.setDescription(request.getParameter("description"));
			v.setGravite(Integer.parseInt(request.getParameter("gravite")));
			v.setLogiciels(request.getParameter("logiciels"));
			v.setSynthese(request.getParameter("synthese"));
			v.setTitre(request.getParameter("titre"));
			v.create();
			response.sendRedirect("admVul.jsp");
			/*
			 * try { Push.sendMail(); } catch (SQLException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 * 
			 * response.sendRedirect("admVul.jsp");
			 */
		}

	}
}
