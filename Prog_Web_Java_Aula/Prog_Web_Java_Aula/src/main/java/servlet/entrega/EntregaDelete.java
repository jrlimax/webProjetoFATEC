package servlet.entrega;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EntregaDAO;
import VO.Entrega;

/**
 * Servlet implementation class EntregaDelete
 */
public class EntregaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntregaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Entrega vo = new Entrega();
		vo.setId(id);
		EntregaDAO dao = new EntregaDAO(vo);
		String ret;
		try {
			dao.deleteEntrega();
			ret="Entrega Excluido Com Sucesso<br>";
			ret+="<a href='EntregaList'>Voltar</a>";
		} catch (Exception e){
			ret="Erro na Exclusao<br>";
			ret += e.getMessage() + "<br>";
			ret+="<a href='EntregaList'>Voltar</a>";
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
