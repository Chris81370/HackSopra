package pack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAbonne
 */
@WebServlet("/ServletAbonne")
public class ServletAbonne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAbonne() {
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
		Abonne a1 = new Abonne();
		a1.setIdA(Integer.parseInt(request.getParameter("IdA")));
		a1.delete();
		response.sendRedirect("admGestion.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (Integer.parseInt(request.getParameter("IdA")) > 0) {
			Abonne a = new Abonne();
			a.setIdA(Integer.parseInt(request.getParameter("IdA")));
			a.setEmail(request.getParameter("email"));

			try {
				a.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admGestion.jsp");
		} else {
			Abonne a = new Abonne();
			a.setNom(request.getParameter("nom"));
			a.setPrenom(request.getParameter("prenom"));
			a.setEmail(request.getParameter("email"));
			a.create();
			response.sendRedirect("index.jsp");
			/*
			 * try { Push.sendMail(); } catch (SQLException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */

		}

	}

}
