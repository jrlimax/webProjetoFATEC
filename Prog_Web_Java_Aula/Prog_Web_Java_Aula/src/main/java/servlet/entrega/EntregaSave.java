package servlet.entrega;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EntregaDAO;
import VO.Entrega;

/**
 * Servlet implementation class EntregaSave
 */
public class EntregaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntregaSave() {
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
		Entrega e = new Entrega();

		String id = request.getParameter("id");
		String venda = request.getParameter("venda");
		Integer data = Integer.parseInt(request.getParameter("data"));
		
		e.setVenda(venda);
		e.setData(data);

		EntregaDAO dao = new EntregaDAO();

		String ret;

		try {
			if (id == "" || id == null) {
				ret = "Entrega Incluído com Sucesso";
				dao.newEntrega(e);
			} else {
				ret = "Cliente Alterado com Sucesso";
				e.setId(Integer.parseInt(id));
				dao.editEntrega(e);
			}
			ret += "<a href='Home.jsp'>Voltar</a>";
		} catch (Exception ex) {
			ret = "Erro na Inclusão<br>";
			ret += ex.getMessage() + "<br>";
			ret += "<a href='Home.jsp'>Voltar</a>";
		}
		response.getWriter().append(ret);
	}
	
}
