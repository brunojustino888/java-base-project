package umc.passosBlueJ;
import java.sql.*;

public class Conexao {
	Connection con;
	ResultSet rs;
		
	public boolean AbrirConexao() 
	{
		try
        	{
	            String drv = "sun.jdbc.odbc.JdbcOdbcDriver";    // driver a ser utilizado
        	    String url = "jdbc:odbc:UMC";                  // nome da fonte de dados - ODBC 
	            Class.forName(drv);                                             //carrega o driver que ser� utilizado pela aplica��o                       
        	    con = DriverManager.getConnection(url,"sa","sa");          //estabelece a conex�o
	            return true;															//permite a utiliza��o de um comando SQL
            																//Fechando a conex�o            
        	}    
	        catch(Exception er1)
        	{       	 	
	            return false;
        	} 
		
	}
	
	
	
	public ResultSet executarConsulta(String CMD)	{
   		 
		try{
   			boolean abriuConexao = AbrirConexao();
   		    rs = null;
   		 	if (abriuConexao) 	{   		 	      
   		 	      Statement MeuState = con.createStatement();  
                  rs = MeuState.executeQuery(CMD);              
   		 	}
   		 	return rs;
        	} catch(Exception er1){
	            return null;
        	}    
   	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

	public int executarComando(String CMD)
	{
   	 	 try
	         {
			int retorno = 0;
   			boolean abriuConexao = AbrirConexao();
   		 	if (abriuConexao)
   		 	{   		 	
   		 		System.out.println("Deu Certo");
   		 	      Statement MeuState = con.createStatement();  
                  	      retorno = MeuState.executeUpdate(CMD);              
                 
   		 	}
   		 	return retorno;
        	}    
	        catch(Exception er1)
        	{
	              return 0;
        	}    
   	}


	public void fecharConexao(){
		try {
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
		
	
}
