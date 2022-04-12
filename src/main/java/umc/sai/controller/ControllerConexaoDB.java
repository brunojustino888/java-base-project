package umc.sai.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import umc.sai.model.Usuario;
import umc.sai.view.TelaLogin;

/** <h1>ControllerConexaoDB</h1>
 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * <p>Essa classe � respons�vel por gerenciar a conex�o com a base de dados configurado no arquivo xml pertencente � aplica��o.</p>  
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 * @version 8.0
 * @see TelaLogin
 */

public class ControllerConexaoDB {
	
	private Connection con;
	private ResultSet rs;
	private String url;
	private String user;
	private String pass;
	private ArrayList<String> idepalavras;
	
	
	/**<p>O construtor inicaializa os objetos da classe com os valores parametrizados no arquivo xml.</p> */
	public ControllerConexaoDB(){
		ControllerXML xml = new ControllerXML();
		url = xml.getUrl();
		user = xml.getUserdb();
		pass = xml.getPassword();
	}
	
	
	/**<p>M�todo respons�vel por abrir uma conex�o com o banco de dados, deixando-a aberta.</p> */
	public boolean abrirConexao() 	{
		try	{
          con = DriverManager.getConnection(url,user,pass);   
          return true;													       													           
        }catch(Exception er1){return false;} 
	}
	
	/**<p>M�todo resp�ns�vel por fechar a conex�o com a base de dados.</p> */
	public void fecharConexao(){
		try {
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	/**<p>M�todo resp�ns�vel por abrir e fechar uma conex�o com a base de dados(apenas para testar a configura��o do banco).</p> */
	public boolean testarConexao() 	{
		try	{         
			con = DriverManager.getConnection(url,user,pass); 
        	con.close();
        	return true;													 										           
        }catch(Exception er1){return false;} 
	}
	
	/**<p>M�todo resp�ns�vel por abrir e fechar uma conex�o com a base de dados(apenas para testar a configura��o do banco).</p> */
	public boolean testarConexao(String purl, String puser, String ppass) 	{
		try	{         
			con = DriverManager.getConnection(purl,puser,ppass); 
        	con.close();
        	return true;													 										           
        }catch(Exception er1){return false;} 
		
	}
	
	/**<p>M�todo resp�ns�vel por retornar um objeto ResultSet com o resultadodo comando SQL.</p> */
	public ResultSet executarConsulta(String cmd)	{
		try{
   			boolean abriuConexao = abrirConexao();
   		    rs = null;
   		 	if (abriuConexao) 	{   		 	      
   		 	      Statement MeuState = con.createStatement();  
                  rs = MeuState.executeQuery(cmd);              
   		 	}
   		 	return rs;
        	} catch(Exception er1){
	            return null;
        	}    
   	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

	/**<p>M�todo resp�ns�vel por retornar um objeto int que representa o n�mero de linhas afetadas no banco de dados ap�s executar o comando que � passado � ele como par�metro.</p> */
	public int executarComando(String cmd)	{
		try  {
			int retorno = 0;
   			boolean abriuConexao = abrirConexao();
	   		 	if (abriuConexao)	{   		 	
	   		 	  Statement MeuState = con.createStatement();  
	              retorno = MeuState.executeUpdate(cmd);              
	   		 	}
   		 	return retorno;
        	}    
	        catch(Exception er1){
	        	er1.printStackTrace();
	        	return 0;}    
   	}
	
	public ArrayList<String> returnPalavras(int i){
		ArrayList<String> palavras = new ArrayList<String>();
		idepalavras = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from palavras");    
	            while(rs.next()){
	                 idepalavras.add(rs.getString(1));
	                 palavras.add(rs.getString(2));
	                 }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		
		if(i==0){
		return idepalavras;	
		}else{
		return palavras;
		}
		
	}
	
	public ArrayList<String> returnAtividades(){
		ArrayList<String> atividades = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from atividades");    
	            while(rs.next()){
	                 atividades.add(rs.getString(1)+" -> "+rs.getString(2)+" # "+rs.getString(3));
	                 }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return atividades;	
		}
	
	public String returnAtividadeById(int i){
		String atividades = "";
		try{
            ResultSet rs = executarConsulta("select * from atividades where id_atividade ="+i+";");    
	            
            while(rs.next()){ 		
	                 atividades = "Data & Hora da Atividade: "+rs.getString(1)+"\nID da Atividade: "+rs.getString(3)+"\nID do Usu�rio: "+rs.getString(4)+"\nTipo N�merico da Atividade: "+rs.getString(5)+"\nDescri��o da Atividade: "+rs.getString(2);
	                 break;
            }	
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return atividades;	
		}
	
	public String returnAtividadeByIdUserS(int i){
		String atividades = "";
		try{
            ResultSet rs = executarConsulta("select * from atividades where id_user ="+i+";");    
	            
            while(rs.next()){ 		
	                 atividades = "Data & Hora da Atividade: "+rs.getString(1)+"\nID da Atividade: "+rs.getString(3)+"\nID do Usu�rio: "+rs.getString(4)+"\nTipo N�merico da Atividade: "+rs.getString(5)+"\nDescri��o da Atividade: "+rs.getString(2);
	                 break;
            }	
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return atividades;	
		}
	
	public ArrayList<String> returnAtividadeByIdUser(int i){
		ArrayList<String> atividades = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from atividades where id_user ="+i+";");    
	            
            while(rs.next()){ 		
	                 atividades.add(rs.getString(1)+" # "+rs.getString(2)+" # "+rs.getString(3)+" # "+rs.getString(4)+" # "+rs.getString(5));
            }	
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return atividades;	
		}
	
	public ArrayList<String> returnAlunos(){
		ArrayList<String> users = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from usuarios where id_tipo = 1;");    
	            while(rs.next()){
	                 users.add(rs.getString(1)+" # "+rs.getString(2)+" # "+rs.getString(3)+" # "+rs.getString(4)+" # "+rs.getString(5)+" # "+rs.getString(6)+" # "+rs.getString(7)+" # "+rs.getString(8)+" # "+rs.getString(9)+" # "+rs.getString(10)+" # "+rs.getString(11));
	            }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return users;	
		}
	
	public ArrayList<String> returnProfessores(){
		ArrayList<String> users = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from usuarios where id_tipo = 2;");    
	            while(rs.next()){
	                 users.add(rs.getString(1)+" # "+rs.getString(2)+" # "+rs.getString(3)+" # "+rs.getString(4)+" # "+rs.getString(5)+" # "+rs.getString(6)+" # "+rs.getString(7)+" # "+rs.getString(8)+" # "+rs.getString(9)+" # "+rs.getString(10)+" # "+rs.getString(11));
	            }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return users;	
		}
	
	public ArrayList<String> returnUsers(){
		ArrayList<String> users = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from usuarios;");    
	            while(rs.next()){
	                 users.add(rs.getString(1)+" # "+rs.getString(2)+" # "+rs.getString(3)+" # "+rs.getString(4)+" # "+rs.getString(5)+" # "+rs.getString(6)+" # "+rs.getString(7)+" # "+rs.getString(8)+" # "+rs.getString(9)+" # "+rs.getString(10)+" # "+rs.getString(11));
	            }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return users;	
		}
	
	public ArrayList<String> returnLogins(){
		ArrayList<String> users = new ArrayList<String>();
		try{
            ResultSet rs = executarConsulta("select * from usuarios;");    
	            while(rs.next()){
	                 users.add(rs.getString(9));
	            }
	            	
	        }catch(Exception erro){erro.printStackTrace();}
		fecharConexao();	 
		return users;	
		}
	
	public boolean returnPalavraExiste(String novapalavra){
		ArrayList<String> palavras = new ArrayList<String>();
		palavras = returnPalavras(1);
		System.out.println(palavras.size());
		for(int i=0;i<palavras.size();i++){
			if(palavras.get(i).equalsIgnoreCase(novapalavra)){
				return true;
			}
		}
		return false;
	}
	
	
	public void InsertPalavra(String palavra){
		String comando = "insert into palavras (palavra) values('"+palavra+"');";
		executarComando(comando);
		fecharConexao();
	}
	
	public void InsertUser(Usuario user){
		String comando = "insert into usuarios (id_tipo,nome,nascimento,cpf,rg,telefone,endereco,login,senha,obs_user) values ("+user.getId_tipo()+",'"+user.getNome()+"','"+user.getNascimento()+"','"+user.getCpf()+"','"+user.getRg()+"','"+user.getTelefone()+"','"+user.getEndereco()+"','"+user.getLogin()+"','"+user.getSenha()+"','"+user.getObs_user()+"');";
		executarComando(comando);
		fecharConexao();
	}
	
	public void alterUser(Usuario user){
		String comando = "update usuarios (id_tipo,nome,nascimento,cpf,rg,telefone,endereco,login,senha,obs_user) values ("+user.getId_tipo()+",'"+user.getNome()+"','"+user.getNascimento()+"','"+user.getCpf()+"','"+user.getRg()+"','"+user.getTelefone()+"','"+user.getEndereco()+"','"+user.getLogin()+"','"+user.getSenha()+"','"+user.getObs_user()+"') where id_user = "+user.getId_user()+";";
		executarComando(comando);
		fecharConexao();
	}
	
	
	public void deletePalavra(String palavra){
		String idapagar = "0";
		ArrayList<String> palavras = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		palavras = returnPalavras(1);
		id = returnPalavras(0);
		for(int i=0;i<palavras.size();i++){
			if(palavras.get(i).equalsIgnoreCase(palavra)){
				idapagar = id.get(i);
			}
		}
		String comando = "delete from palavras where id_palavra = "+Integer.parseInt(idapagar)+";";
		executarComando(comando);
		fecharConexao();
	}
	
	public void deleteUser(int id){
		String comando = "delete from usuarios where id_user = "+id+";";
		executarComando(comando);
		fecharConexao();
	}
	
	
}