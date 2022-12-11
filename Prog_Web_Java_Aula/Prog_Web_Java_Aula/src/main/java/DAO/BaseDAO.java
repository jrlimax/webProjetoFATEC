package DAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/primeiroapp";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection conn;
     
   	public Connection getConn() {
		return conn;
	}
   	
    public  void abrir() throws Exception {       
        Class.forName(DRIVER);     
        conn = DriverManager.getConnection(URL, USUARIO, SENHA);            
    }

    public  void fechar() throws Exception {
        this.getConn().close();        
    }
       
}