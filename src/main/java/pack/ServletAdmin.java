package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant=request.getParameter("identifiant");
		String mdp=request.getParameter("mdp");
		HttpSession session=request.getSession();
		Admin adm1=new Admin(identifiant, mdp);
		if(adm1.authentifier()==null)
		{
			session.setAttribute("erreur","compte non reconnu");
			response.sendRedirect("index.jsp");
		}
		else
		{
			Admin result=adm1.authentifier();
			session.setAttribute("identifiant",result.getIdentifiant());
			session.setAttribute("mdp",result.getMdp());
			response.sendRedirect("admIndex.jsp");
		}
	}

}
