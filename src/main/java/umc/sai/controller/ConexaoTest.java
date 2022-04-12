package umc.sai.controller;
import java.sql.*;

public class ConexaoTest{
    public static void main(String args[])
    {
        ControllerConexaoDB oConn = new ControllerConexaoDB();
        	//int fez =  oConn.executarComando("insert into Agenda (NOMEAMIGO,HOBBYAMIGO,IDADEAMIGO,FONEAMIGO) values ('John','Gamer',25,'4')");
            //fez =  oConn.executarComando("delete from agenda where id = 2");
            //fez =  oConn.executarComando("update agenda set idadeAmigo = 40 where id = 3");
        
        
        try{
            ResultSet rs = oConn.executarConsulta("select * from usuarios");    
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11));
            }
        }
        catch(Exception erro){
        	erro.printStackTrace();
            //System.out.println("ERRO");
        }
        
        oConn.fecharConexao();
    }
}
