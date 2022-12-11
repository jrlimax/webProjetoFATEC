package servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import VO.Cliente;


/**
 * Servlet implementation class ClienteSave
 */
public class ClienteSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteSave() {
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
		Cliente c = new Cliente();
		String id = request.getParameter("id");		 
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		Integer telefone = Integer.parseInt(request.getParameter("telefone"));
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setTelefone(telefone);
		ClienteDAO dao = new ClienteDAO();
		String ret;
		try {
		    if(id=="" || id==null) {
			    ret="Cliente Incluído com Sucesso";
	            dao.newCliente(c);
	        }else {
	        	ret="Cliente Alterado com Sucesso";
	            c.setId(Integer.parseInt(id));
	            dao.editCliente(c);
	        }
			ret+="<a href='Home.jsp'>Voltar</a>";
		} catch (Exception e){
			ret="Erro na Inclusão<br>";
			ret += e.getMessage() + "<br>";
			ret+="<a href='Home.jsp'>Voltar</a>";
		}	
		response.getWriter().append(ret);
	}

}
