package umc.sCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD {

	String sql;
	
	public void transaction(Connection con,Conta conta)throws SQLException{
		try{
			con.setAutoCommit(false);
			con.commit();
		}catch(Exception e){
			con.rollback();
		}
	}
	
	public void create(Connection con,Conta conta)throws SQLException{
		sql = "insert into contas values (?,?,?)";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, conta.numero);
		pt.setString(2, conta.cliente);
		pt.setDouble(3, conta.saldo);
		pt.executeUpdate();
	}
	
	public ArrayList<Conta> read(Connection con)throws SQLException{
		ArrayList<Conta> contas = new ArrayList<Conta>();
		sql = "select * from Contas";
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		while(rs.next()){
			contas.add(new Conta(Integer.parseInt(rs.getString(1)),rs.getString(2),Double.parseDouble(rs.getString(3))));
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		return contas;
	}
	
	public void update(Connection con,Conta conta)throws SQLException{
		sql = "update contas set numero = ?, cliente =?, saldo = ? where numero = ?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, conta.numero);
		pt.setString(2, conta.cliente);
		pt.setDouble(3, conta.saldo);
		pt.setInt(4,  conta.numero);
		pt.executeUpdate();
	}
	
	public void delete(Connection con,Conta conta)throws SQLException{
		sql = "delete contas where numero = ?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, conta.numero);
		pt.executeUpdate();
	}
	
	public static void main(String[] args) {
		CRUD crud = new CRUD();
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url,"john","617098");
			crud.create(c, new Conta());
			
			crud.update(c, new Conta(13,"Alterado",13.33));
			
			crud.delete(c, new Conta(13,"Alterado",13.33));
			
			crud.read(c);
		} catch (SQLException e) {e.printStackTrace();}
	}

}