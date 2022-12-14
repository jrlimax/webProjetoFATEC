package servlet.produto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProdutoDAO;
import VO.Produto;

/**
 * Servlet implementation class ProdutoEdit
 */
public class ProdutoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		try {
			int codigo = Integer.parseInt(request.getParameter("id"));
			Produto vo = new Produto();
			
			ProdutoDAO dao = new ProdutoDAO(vo);
			vo= dao.findByIdProduto(codigo);
			
			request.setAttribute("produto", vo);
request.getRequestDispatcher("/produto/Produto.jsp").forward(request, response);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
