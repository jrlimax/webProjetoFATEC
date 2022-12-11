package DAO;
import java.util.ArrayList;
import java.util.List;
import VO.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProdutoDAO extends BaseDAO {
	
	public ProdutoDAO() {
		
	}
	public ProdutoDAO(Produto vo) {
		this.vo=vo;
	}
	Produto vo;
	
	public Produto getVo() {
		return vo;
	}

	public void setVo(Produto vo) {
		this.vo = vo;
	}

	public void LoadProduct() {
		this.vo.setDescricao("Descricao Teste");
		this.vo.setNome("Nome Teste");	
		this.vo.setPreco(100);	
	}
	
	public List<Produto> getProducts() throws Exception {	
		List<Produto> lst = new ArrayList<Produto>();
		abrir();
		Statement s = getConn().createStatement(); 
		String sql = "SELECT id,nome,descricao,preco FROM Produto";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Produto p = new Produto();
			p.setCodigo(rs.getInt(1));
			p.setNome(rs.getString(2));	
			p.setDescricao(rs.getString(3));
			p.setPreco(rs.getFloat(4));
			lst.add(p);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
		
	}
	public void newProduto(Produto p) throws Exception {
		
		  abrir();		
	      String query = " insert into Produto (nome,descricao,preco)"
	        + " values (?,?,?)";
 PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, p.getNome());  
	      preparedStmt.setString (2, p.getDescricao());  
	      preparedStmt.setFloat(3, p.getPreco()); 
	      preparedStmt.execute();
	      fechar();
		
	}
	public void delete() throws Exception {
		  abrir();
	      String query = " delete from Produto where id=?";
	   PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setInt(1,vo.getCodigo());    
	      preparedStmt.execute();
	      fechar();	
	}
	
	public ArrayList<Produto> findProdutos(String nome)  throws Exception{
		
		super.abrir();
		ArrayList <Produto> lst = new ArrayList();
		String sql = "SELECT id,nome FROM Produto where nome like ?";
	PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, nome +'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		while (rs.next()) { 
			Produto p= new Produto();
			p.setCodigo(Integer.parseInt(rs.getString(1)) );
			p.setNome(rs.getString(2));		
			lst.add(p);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}
	public Produto findByIdProduto(int id) throws Exception{
		super.abrir();
		
		String sql = "SELECT id,nome,descricao,preco FROM Produto where id=?";
		  
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setInt(1, id);  
		  
		ResultSet rs =   preparedStmt.executeQuery();
		Produto p= new Produto();
		while (rs.next()) { 
			p.setCodigo(Integer.parseInt(rs.getString(1)) );
			p.setNome(rs.getString(2));		
			p.setDescricao(rs.getString(3));	
			p.setPreco(rs.getFloat(4)); 
		}
		
		rs.close();
		return p;
	}
	public void edit(Produto p)  throws Exception{
		abrir();
			
	String query = " update Produto set nome=?,descricao=?,preco=? where id=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, p.getNome());  
	      preparedStmt.setString (2, p.getDescricao());  
	      preparedStmt.setFloat(3, p.getPreco()); 
	      preparedStmt.setInt(4, p.getCodigo()); 
	      preparedStmt.execute();
	      fechar();
		
	}
	
}
