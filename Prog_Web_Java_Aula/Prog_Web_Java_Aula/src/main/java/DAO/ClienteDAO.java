package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.Cliente;

public class ClienteDAO extends BaseDAO{
	
public ClienteDAO() {
		
	}
	public ClienteDAO(Cliente vo) {
		this.vo=vo;
	}
	Cliente vo;
	
	public Cliente getVo() {
		return vo;
	}

	public void setVo(Cliente vo) {
		this.vo = vo;
	}
	
	public void newCliente(Cliente c) throws Exception {
		
		  abrir();		
	      String query = " insert into cliente (nome,email,telefone,endereco)"
	        + " values (?,?,?,?)";
PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, c.getNome());  
	      preparedStmt.setString (2, c.getEmail());  
	      preparedStmt.setInt(3, c.getTelefone()); 
	      preparedStmt.setString(4, c.getEndereco()); 
	      preparedStmt.execute();
	      fechar();
		
	}
	
	public List<Cliente> getCliente() throws Exception {	
		List<Cliente> lst = new ArrayList<Cliente>();
		abrir();
		Statement s = getConn().createStatement(); 
		String sql = "SELECT id, nome, email, telefone, endereco FROM cliente";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Cliente c = new Cliente();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));	
			c.setEmail(rs.getString(3));
			c.setTelefone(rs.getInt(4));
			c.setEndereco(rs.getString(5));
			lst.add(c);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;	
	}
	
	public void deleteCliente() throws Exception {
		abrir();
	      String query = " delete from cliente where id=?";
	   PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setInt(1,vo.getId());    
	      preparedStmt.execute();
	      fechar();	
	}
	
	public void editCliente(Cliente c)  throws Exception{
		
		abrir();		
		String query = " update cliente set nome=?,email=?,telefone=?, endereco=? where id=?";
PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, c.getNome());  
	      preparedStmt.setString (2, c.getEmail());  
	      preparedStmt.setInt(3, c.getTelefone()); 
	      preparedStmt.setString(4, c.getEndereco()); 
	      preparedStmt.execute();
	      fechar();
	}
	
public ArrayList<Cliente> findCliente(String nome)  throws Exception{
		
		super.abrir();
		ArrayList <Cliente> lst = new ArrayList();
		String sql = "SELECT id,nome, email, telefone, endereco FROM cliente where nome like ?";
	PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, nome +'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		while (rs.next()) { 
			Cliente c = new Cliente();
			c.setId(Integer.parseInt(rs.getString(1)) );
			c.setNome(rs.getString(2));		
			lst.add(c);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}

public Cliente findByIdCliente(int id) throws Exception{
	
	super.abrir();
	
	String sql = "SELECT id, nome, email, telefone, endereco FROM cliente where id=?";
	  
	PreparedStatement preparedStmt = getConn().prepareStatement(sql);
	
	preparedStmt.setInt(1, id);  
	  
	ResultSet rs =   preparedStmt.executeQuery();
	Cliente c = new Cliente();
	while (rs.next()) { 
		c.setId(Integer.parseInt(rs.getString(1)) );
		c.setNome(rs.getString(2));		
		c.setEmail(rs.getString(3));	
		c.setTelefone(rs.getInt(4));
		c.setEndereco(rs.getString(5));
	}
	
	rs.close();
	return c;
}

}
