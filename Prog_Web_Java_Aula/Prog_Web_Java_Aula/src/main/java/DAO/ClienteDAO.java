package DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import VO.Cliente;
import VO.Produto;

public class ClienteDAO extends BaseDAO{

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
	
	public List<Cliente> getCategoria() {
		List<Cliente> lst = new ArrayList<Cliente>();
		return lst;
	}
	
	public void deleteCliente(){
		
	}
	
	public void edit(Cliente c)  throws Exception{
	}
	
}
