package application4paradox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;

public class ConexaoTest{
 
	private String pastatxt, pastaparadox, tabela;
	
	public ConexaoTest(String spastatxt, String spastaparadox, String stabela){
		pastatxt = spastatxt;
		pastaparadox = spastaparadox;
		tabela = stabela;
		
	    Conexao oConn = new Conexao(pastaparadox);
        
        try{
            ResultSet rs = oConn.executarConsulta("select * from "+tabela);    
            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
            
    		try{
    			FileWriter fw = new FileWriter(pastatxt,false);
    			BufferedWriter bw = new BufferedWriter(fw);  
    			PrintWriter pw = new PrintWriter(bw); 
    			
    			int contadorColunas =0;
    			int contadorRegistros=0;
    		
    			try{ 
    				for(int i=1;i>=1;i++){
    					while(rsMetaData.getColumnName(i)!=null){
    						contadorColunas = i;
    						i++;
        				}
    				}
    			}catch(SQLException e){
    				
        			while(rs.next()){contadorRegistros++;}
    				pw.println("N�mero de Linhas da Tabela: "+contadorRegistros);
    				pw.println("N�mero de Colunas da Tabela: "+contadorColunas);
    				pw.println("---------------------------");
    				System.out.println("---------------------------");
    				System.err.println("N�mero de Linhas da Tabela: "+contadorRegistros);
    				System.out.println("N�mero de Colunas da Tabela: "+contadorColunas);
    				System.out.println("---------------------------");
    				
	    				for(int i=1; i<=contadorColunas;i++){
	    					pw.print(rsMetaData.getColumnName(i)+"\t");
	    				}
	    				pw.println();

    					rs = oConn.executarConsulta("select * from "+ tabela);     
		    			
    					while(rs.next()){
    						contadorRegistros++;
			    				for(int i=1;i<=contadorColunas;i++){
			    					pw.print(rs.getString(i)+"\t");
			    				}
		    				pw.println("");
		    			}
    			}
    			fw.flush();
    			bw.flush();
    			pw.flush();
    			pw.close(); 
    			fw.close(); 
    			bw.close();
    		}catch(Exception e){System.exit(0);}    	
        }catch(Exception erro) {
        	erro.printStackTrace();
        	System.exit(0);
        }
        oConn.fecharConexao();
    }
}