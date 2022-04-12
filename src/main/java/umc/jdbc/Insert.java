package umc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection c = DriverManager.getConnection(url,"john","617098");
		
		String sql = "insert into pessoa values (2,'Miguel Giacomini da Silva Justino','M','migue888@ig.com.br','15/03/2014')";
		
		PreparedStatement pt = c.prepareStatement(sql);
		
		int resultado = pt.executeUpdate();
		
		System.out.println(resultado+" linha(s) afetada(s).");
		
		c.close();
		
		pt.close();
		
	}

}