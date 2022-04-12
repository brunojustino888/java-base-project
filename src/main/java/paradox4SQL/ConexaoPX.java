package paradox4SQL;

import java.sql.*;

public class ConexaoPX {

	Connection con;
	ResultSet rs;
	String sdiretorio;
	
	public ConexaoPX(String s){
		sdiretorio = s;
	}
	

	public boolean AbrirConexao() 	{
		try	{
	            String drv = "com.hxtt.sql.paradox.ParadoxDriver";    //driver "monstrinho" para Mr. Joszef
        	    String url = "jdbc:paradox:/"+sdiretorio;               //url + fonte de dados 
	            Class.forName(drv);                                   //carrega o driver que ser� utilizado pela aplica��o                       
        	    con = DriverManager.getConnection(url);          	  //estabelece a conex�o
	            return true;										  //aew!            
        	}    
	        catch(Exception er1){       	 	
	        	System.err.println("deu pau no monstrinho");
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

	public int executarComando(String CMD)	{
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
