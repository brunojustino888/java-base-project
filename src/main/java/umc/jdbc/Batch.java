package umc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection c = DriverManager.getConnection(url,"john","617098");
		
		String sql = "insert into pessoa values (?,?,?,?,?)";
		
		String pessoas[] = {"Bruno","Daniela","Vinicius","Miguel"};
		
		PreparedStatement pt = c.prepareStatement(sql);
		
		for(int i=0;i<pessoas.length;i++){
			// posi��o, valor 
			pt.setInt(1, i+888);
			pt.setString(2, pessoas[i]);
			pt.setString(3, "M");
			pt.setString(4, pessoas[i]+"@gmail.com");
			pt.setString(5, "08/12/2014");
			pt.addBatch();
		}
		
		pt.executeBatch();
		
		c.close();
		
		pt.close();
		
	}

}