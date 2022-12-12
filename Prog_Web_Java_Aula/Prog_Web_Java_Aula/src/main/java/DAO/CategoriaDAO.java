package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.Categoria;

public class CategoriaDAO extends BaseDAO {

	public CategoriaDAO() {

	}

	public CategoriaDAO(Categoria vo) {
		this.vo = vo;
	}

	Categoria vo;

	public Categoria getVo() {
		return vo;
	}

	public void setVo(Categoria vo) {
		this.vo = vo;
	}

	public void newCategoria(Categoria c) throws Exception {

		abrir();
		String query = " insert into categoria (nome,descricao) values (?,?)";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString(1, c.getNome());
		preparedStmt.setString(2, c.getDescricao());
		preparedStmt.execute();
		fechar();

	}

	public List<Categoria> getCategoria() throws Exception {
		List<Categoria> lst = new ArrayList<Categoria>();
		abrir();
		Statement s = getConn().createStatement();
		String sql = "SELECT id, nome, descricao FROM categoria";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			Categoria c = new Categoria();
			c.setCodigo(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setDescricao(rs.getString(3));
			lst.add(c);
		}
		s.close();
		rs.close();
		fechar();
		return lst;
	}

	public void deleteCategoria() throws Exception {
		abrir();
		String query = " delete from categoria where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setInt(1, vo.getCodigo());
		preparedStmt.execute();
		fechar();
	}

	public void editCategoria(Categoria c) throws Exception {

		abrir();
		String query = " update categoria set nome=?,descricao=? where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString(1, c.getNome());
		preparedStmt.setString(2, c.getDescricao());
		preparedStmt.setInt(5, c.getCodigo());
		preparedStmt.execute();
		fechar();
	}

	public ArrayList<Categoria> findCategoria(String nome) throws Exception {

		super.abrir();
		ArrayList<Categoria> lst = new ArrayList();
		String sql = "SELECT id,nome, descricao FROM categoria where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString(1, nome + '%');
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) {
			Categoria c = new Categoria();
			c.setCodigo(Integer.parseInt(rs.getString(1)));
			c.setNome(rs.getString(2));
			lst.add(c);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}

	public Categoria findByIdCategoria(int id) throws Exception {

		super.abrir();

		String sql = "SELECT id, nome, descricao FROM categoria where id=?";

		PreparedStatement preparedStmt = getConn().prepareStatement(sql);

		preparedStmt.setInt(1, id);

		ResultSet rs = preparedStmt.executeQuery();
		Categoria c = new Categoria();
		while (rs.next()) {
			c.setCodigo(Integer.parseInt(rs.getString(1)));
			c.setNome(rs.getString(2));
			c.setDescricao(rs.getString(3));
		}
		rs.close();
		return c;
	}

}
