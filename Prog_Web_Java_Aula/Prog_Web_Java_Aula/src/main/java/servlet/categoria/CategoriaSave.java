package servlet.categoria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;

/**
 * Servlet implementation class CategoriaSave
 */
public class CategoriaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaSave() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		c.setNome(nome);
		c.setDescricao(descricao);

		CategoriaDAO dao = new CategoriaDAO();

		String ret;

		try {
			if (id == "" || id == null) {
				ret = "Categoria Incluído com Sucesso";
				dao.newCategoria(c);
			} else {
				ret = "Categoria Alterado com Sucesso";
				c.setCodigo(Integer.parseInt(id));
				dao.editCategoria(c);
			}
			ret += "<a href='Home.jsp'>Voltar</a>";
		} catch (Exception e) {
			ret = "Erro na Inclusão<br>";
			ret += e.getMessage() + "<br>";
			ret += "<a href='Home.jsp'>Voltar</a>";
		}
		response.getWriter().append(ret);
	}
}
