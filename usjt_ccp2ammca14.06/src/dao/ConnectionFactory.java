package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//Metodo para realizar a conex�o com o banco de dados
public class ConnectionFactory {
	private static String usuario = "root", senha = "1337",stringConexao = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obt�m conex�o com o banco de dados
	public static Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection(stringConexao,usuario,senha);
	}
 
}