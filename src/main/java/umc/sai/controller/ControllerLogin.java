package umc.sai.controller;

import java.sql.ResultSet;

import umc.sai.model.Usuario;

/** <h1>ControllerLogin</h1>
 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * <p>Essa classe � respons�vel por realizar uma conex�o com a base de dados configurada na classe ControllerConexaoDB e, atrav�s do retorno dos registros da coluna login e senha validar o usu�rio.</p> 
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 * @version 8.0
 * @see ControllerConexaoDB
 */

public class ControllerLogin {
	
	private Usuario user;
	
	/** <p>M�todo Respons�vel pela valida��o do usu�rio no sistema, ou seja, por retornar true caso encontre o usuario e a senha no banco de dados</p> */
	public boolean isUsuarioValido(String usuario, String senha) {
		ControllerConexaoDB ccdb = new ControllerConexaoDB();
		boolean isValidUser = false;
			  		try{
			            ResultSet rs = ccdb.executarConsulta("select * from usuarios");    
				            while(rs.next()){
				                if (usuario.equals(rs.getString(9))&&(senha.equals(rs.getString(10)))){
				                	isValidUser = true;
				                	user = new Usuario(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
				                	new ControllerInsertAtividade().InsertLogin(user);
				                	break;
				                }
				            	//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11));
				            }
			  			}catch(Exception erro){erro.printStackTrace();}
		  	  ccdb.fecharConexao();	 
		 return isValidUser; 	  
	}
	
	/** <p>M�todo Respons�vel por retornar um tipo de Usuario v�lido para a aplica��o.</p> */
	public Usuario getValidUser() {
		return user;
	}
	
	/** <p>M�todo Respons�vel por retornar um tipo de Usuario para a execu��o sem banco de dados, ou seja, para execu��o do projeto na casa do indiv�duo.</p> */
	public Usuario getHomeUser() {
		return new Usuario(0,0,"Usuario Home","28/12/1988","000.000.000-00","00.000.000-0","+55 11 0-0000-0000","Home","UserHome","HomeExec","Usuario v�lido para a execu��o da aplica��o em casa");
	}
	
}