package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.Entrega;

public class EntregaDAO extends BaseDAO {

	public EntregaDAO() {

	}

	public EntregaDAO(Entrega vo) {
		this.vo = vo;
	}

	Entrega vo;

	public Entrega getVo() {
		return vo;
	}

	public void setVo(Entrega vo) {
		this.vo = vo;
	}

	public void newEntrega(Entrega e) throws Exception {

		abrir();
		String query = " insert into entrega (venda) values (?)";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString(1, e.getVenda());
		preparedStmt.execute();
		fechar();

	}

	public List<Entrega> getEntrega() throws Exception {
		List<Entrega> lst = new ArrayList<Entrega>();
		abrir();
		Statement s = getConn().createStatement();
		String sql = "SELECT id, venda, data FROM entrega";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			Entrega c = new Entrega();
			c.setId(rs.getInt(1));
			c.setVenda(rs.getString(2));
			c.setData(rs.getInt(3));

			lst.add(c);
		}
		s.close();
		rs.close();
		fechar();
		return lst;
	}

	public void deleteEntrega() throws Exception {
		abrir();
		String query = " delete from entrega where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setInt(1, vo.getId());
		preparedStmt.execute();
		fechar();
	}

	public void editEntrega(Entrega e) throws Exception {

		abrir();
		String query = " update entrega set venda=?, data=? where id=?";
		PreparedStatement preparedStmt = getConn().prepareStatement(query);
		preparedStmt.setString(1, e.getVenda());
		preparedStmt.setInt(3, e.getData());
		preparedStmt.setInt(5, e.getId());
		preparedStmt.execute();
		fechar();
	}

	public ArrayList<Entrega> findEntrega(String venda) throws Exception {

		super.abrir();
		ArrayList<Entrega> lst = new ArrayList();
		String sql = "SELECT id,venda, data, FROM entrega where venda like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString(1, venda + '%');
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) {
			Entrega e = new Entrega();
			e.setId(Integer.parseInt(rs.getString(1)));
			e.setVenda(rs.getString(2));
			e.setData(rs.getInt(3));
			lst.add(e);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}

	public Entrega findByIdEntrega(int id) throws Exception {

		super.abrir();

		String sql = "SELECT id, venda, data FROM entrega where id=?";

		PreparedStatement preparedStmt = getConn().prepareStatement(sql);

		preparedStmt.setInt(1, id);

		ResultSet rs = preparedStmt.executeQuery();
		Entrega e = new Entrega();
		while (rs.next()) {
			e.setId(Integer.parseInt(rs.getString(1)));
			e.setVenda(rs.getString(2));
			e.setData(rs.getInt(3));
		}

		rs.close();
		return e;
	}

}
