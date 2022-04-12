package bancodados;

import java.sql.*;

public class ConexaoTest{
    public static void main(String args[])
    {
        Conexao oConn = new Conexao();
        //int fez =  oConn.executarComando("insert into Agenda (NOMEAMIGO,HOBBYAMIGO,IDADEAMIGO,FONEAMIGO) values ('John','Gamer',25,'4')");
            //fez =  oConn.executarComando("delete from agenda where id = 2");
            //fez =  oConn.executarComando("update agenda set idadeAmigo = 40 where id = 3");
        
        
        try        {
            ResultSet rs = oConn.executarConsulta("select * from DB_DSV_URAPESQUISABRADESCO.dbo.SURVEY");    
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+rs.getString(9)+rs.getString(10));
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
