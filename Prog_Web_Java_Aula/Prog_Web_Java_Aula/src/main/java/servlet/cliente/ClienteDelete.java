package servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import VO.Cliente;

/**
 * Servlet implementation class ClienteDelete
 */
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente vo = new Cliente();
		vo.setId(id);
		ClienteDAO dao = new ClienteDAO(vo);
		String ret;
		try {
			dao.deleteCliente();
			ret="Cliente Excluido<br>";
			ret+="<a href='ClienteList'>Voltar</a>";
		} catch (Exception e){
			ret="Erro na Exclusao<br>";
			ret += e.getMessage() + "<br>";
			ret+="<a href='ClienteList'>Voltar</a>";
		}		
		response.getWriter().append(ret);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
