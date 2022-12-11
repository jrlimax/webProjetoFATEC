package servlet.produto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ProdutoDAO;
import VO.Produto;
/**
 * Servlet implementation class ProdutoSave
 */
public class ProdutoSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoSave() {
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
		Produto p=new Produto();
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		float preco = Float.parseFloat(request.getParameter("preco"));
		String codigo = request.getParameter("codigo");		 
		p.setDescricao(descricao);
		p.setNome(nome);
		p.setPreco(preco);
		ProdutoDAO dao= new ProdutoDAO();
		String ret;
		try {
		    if(codigo=="" || codigo==null) {
			    ret="Produto Incluído com Sucesso";
	            dao.newProduto(p);
	        }else {
	        	ret="Produto Alterado com Sucesso";
	            p.setCodigo(Integer.parseInt(codigo));
	            dao.edit(p);
	        }
			ret+="<a href='ProdutoList'>Voltar</a>";
		} catch (Exception e){
			ret="Erro na Inclusão<br>";
			ret += e.getMessage() + "<br>";
			ret+="<a href='ProdutoList'>Voltar</a>";
		}		
		response.getWriter().append(ret);
	}

}
