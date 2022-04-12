package umc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {

	public static void main(String[] args) {
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			
			Connection c = DriverManager.getConnection(url,"john","617098");
			
			String comando = "select * from pessoa";
			
			PreparedStatement managerDeRequisicoes = c.prepareStatement(comando);
			
			ResultSet rs = managerDeRequisicoes.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			
			c.close();
			managerDeRequisicoes.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}