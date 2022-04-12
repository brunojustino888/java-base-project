package umc.bd.jozsef;

import java.sql.*;

public class ConexaoTest{
    public static void main(String args[])
    {
        Conexao oConn = new Conexao();
        //int fez =  oConn.executarComando("insert into Agenda (NOMEAMIGO,HOBBYAMIGO,IDADEAMIGO,FONEAMIGO) values ('John','Gamer',25,'4')");
            //fez =  oConn.executarComando("delete from agenda where id = 2");
            //fez =  oConn.executarComando("update agenda set idadeAmigo = 40 where id = 3");
        
        
        try
        {
            ResultSet rs = oConn.executarConsulta("select * from CLIENTES");    
            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
            System.out.println(rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t"+rsMetaData.getColumnName(1)+"\t\t\t\t\t\t\t\t");
            Thread.sleep(3000);
            while(rs.next())
            {
            	
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t\t\t\t\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8)+rs.getString(9)+rs.getString(10)+"\t\t\t"+rs.getString(11)+"\t\t\t"+rs.getString(12)+rs.getString(13)+rs.getString(14));
            }
        }
        catch(Exception erro)
        {
        	erro.printStackTrace();
            //System.out.println("ERRO");
        }
        
        oConn.fecharConexao();
    }
}
