package paradox4SQL;

import java.sql.*;
import java.util.ArrayList;

public class ConexaoTest{
 
	private String pastaparadox;
	ArrayList<String> tabela;
	
	public ConexaoTest(String spastaparadox, ArrayList<String> stabela){

		pastaparadox = spastaparadox;
		tabela = stabela;
		int contadorColunas =0;
		@SuppressWarnings("unused")
		int contadorRegistros=0;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		
		
	    ConexaoPX oConn = new ConexaoPX(pastaparadox);
    
	    
        try{
        	
        	for (int i = 0; i < tabela.size(); i++) { 
            rs = oConn.executarConsulta("select * from "+tabela.get(i));    
            rsMetaData = (ResultSetMetaData) rs.getMetaData();
            
         
        	
		/*		while(rsMetaData.getColumnName(i)!=null){
				
					System.out.println("Coluna: "+rsMetaData.getColumnName(i)+"\t");
					contadorColunas = i;
					i++;
				
				}*/
            
            
            
            	while(rs.next()){contadorRegistros++;}
            	
				rs = oConn.executarConsulta("select * from "+ tabela);     
    			
				while(rs.next()){
					
					contadorRegistros++;
	    			
					for(int j=1;i<=contadorColunas;j++){
	    				System.err.println(("registro: "+rs.getString(j)+"\t"));
	    			}		
    				
    			}
            
            
        	}

        }catch(Exception erro) {erro.printStackTrace();}
        
        
        oConn.fecharConexao();
    }
}