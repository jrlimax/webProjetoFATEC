package servlet.categoria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;

/**
 * Servlet implementation class CategoriaDelete
 */
public class CategoriaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo = Integer.parseInt(request.getParameter("id"));
		Categoria vo = new Categoria();
		vo.setCodigo(codigo);
		CategoriaDAO dao = new CategoriaDAO(vo);
		String ret;
		try {
			dao.deleteCategoria();
			ret="Categoria Excluido<br>";
			ret+="<a href='CategoriaList'>Voltar</a>";
		} catch (Exception e){
			ret="Erro na Exclusao<br>";
			ret += e.getMessage() + "<br>";
			ret+="<a href='CategoriaList'>Voltar</a>";
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
