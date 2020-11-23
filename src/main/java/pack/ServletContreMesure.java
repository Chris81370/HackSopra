package pack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContreMesure
 */
@WebServlet("/ServletContreMesure")
public class ServletContreMesure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContreMesure() {
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
		ContreMesure c = new ContreMesure();
		c.setIdC(Integer.parseInt(request.getParameter("IdC")));
		c.delete();
		response.sendRedirect("admVul.jsp");// admVul.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Integer.parseInt(request.getParameter("IdV")) > 0) {
			ContreMesure c = new ContreMesure();
			c.setIdC(Integer.parseInt(request.getParameter("IdC")));
			c.setDescription(request.getParameter("description"));
			c.setSources(request.getParameter("sources"));
			c.setTitre(request.getParameter("titre"));
			try {
				c.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admVul.jsp");
		} else {
			ContreMesure c = new ContreMesure();
			c.setDescription(request.getParameter("description"));
			c.setIdV(Integer.parseInt(request.getParameter("IdV")));
			c.setSources(request.getParameter("sources"));
			c.setTitre(request.getParameter("titre"));

			c.create();
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
