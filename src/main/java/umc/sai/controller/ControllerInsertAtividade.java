package umc.sai.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import umc.sai.model.Usuario;

public class ControllerInsertAtividade {

	private ControllerConexaoDB c;
	
	public void InsertLogin(Usuario user){
		c = new ControllerConexaoDB();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String comando =" insert into atividades (hora_data, observacao, id_user, atividade_tipo) values ('"+sdf.format(dd)+"','Login do usuario "+user.getNome()+"', "+user.getId_user()+",0)";
		if(c.executarComando(comando)==0){
			comando= sdf.format(dd)+" -> Erro de BD!";
			new ControllerLog().criarArquivoDeLog(comando);
		}
		c.fecharConexao();
	}
	
	public void InsertVogais(Usuario user, String acertou, String letras, String perguntada,String letrarespondida){ 
		c = new ControllerConexaoDB();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String comando =" insert into atividades (hora_data, observacao, id_user, atividade_tipo) values ('"+sdf.format(dd)+"','Atividade de Vogais do Usu�rio: "+user.getNome()+" -> Letras Apresentadas: "+letras+" -> Usu�rio "+acertou+" -> Letra Perguntada: "+perguntada+" ->Letra Escolhida: "+letrarespondida+"', "+user.getId_user()+",1)";
		if(c.executarComando(comando)==0){
			comando= sdf.format(dd)+" -> Atividade de Vogais do Usu�rio: "+user.getNome()+" -> Letras Apresentadas: "+letras+" -> Usu�rio "+acertou+" -> Letra Perguntada: "+perguntada+" ->Letra Respondida: "+letrarespondida+" ";
			new ControllerLog().criarArquivoDeLog(comando);
		}
		c.fecharConexao();
	}
		
	public void InsertAlfabeto(Usuario user, String acertou, String letras, String perguntada,String letrarespondida){
		c = new ControllerConexaoDB();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String comando =" insert into atividades (hora_data, observacao, id_user, atividade_tipo) values ('"+sdf.format(dd)+"','Atividade do Alfabeto do Usu�rio: "+user.getNome()+" -> Letras Apresentadas: "+letras+" -> Usu�rio "+acertou+" -> Letra Perguntada: "+perguntada+" ->Letra Escolhida: "+letrarespondida+"', "+user.getId_user()+",2)";
		if(c.executarComando(comando)==0){
			comando= sdf.format(dd)+" -> Atividade do Alfabeto do Usu�rio: "+user.getNome()+" -> Letras Apresentadas: "+letras+" -> Usu�rio "+acertou+" -> Letra Perguntada: "+perguntada+" ->Letra Respondida: "+letrarespondida+" ";
			new ControllerLog().criarArquivoDeLog(comando);
		}
		c.fecharConexao();
	}

	public void InsertIni(){
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String s = sdf.format(dd)+" -> Aplica��o Iniciada sem Acesso � Banco de Dados! ";
		new ControllerLog().criarArquivoDeLog(s);
	}
	
	public void insertEsvreveu(Usuario user, String acertou, String perguntada,String respondida){
		c = new ControllerConexaoDB();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String comando =" insert into atividades (hora_data, observacao, id_user, atividade_tipo) values ('"+sdf.format(dd)+"','Atividade de Aprender � Escrever do Usu�rio: "+user.getNome()+" -> Palavra Apresentada: "+perguntada+" -> Usu�rio "+acertou+" -> Palavra Escrita pelo Usu�rio: "+respondida+" "+"', "+user.getId_user()+",3)";
		if(c.executarComando(comando)==0){
			comando= sdf.format(dd)+" -> Atividade de Aprender � Escrever do Usu�rio: "+user.getNome()+" -> Palavra Apresentada: "+perguntada+" -> Usu�rio "+acertou+" -> Palavra Escrita pelo Usu�rio: "+respondida+" ";
			new ControllerLog().criarArquivoDeLog(comando);
		}
		c.fecharConexao();
	}
		
}