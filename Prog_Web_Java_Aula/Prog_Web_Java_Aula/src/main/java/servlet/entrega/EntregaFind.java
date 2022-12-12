package servlet.entrega;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EntregaDAO;

/**
 * Servlet implementation class EntregaFind
 */
public class EntregaFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntregaFind() {
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
		try {
			String entrega = request.getParameter("venda");
			EntregaDAO dao = new EntregaDAO();
			request.setAttribute("lista", dao.findEntrega(entrega));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("/entrega/EntregaList.jsp").forward(request, response);
	}

}
