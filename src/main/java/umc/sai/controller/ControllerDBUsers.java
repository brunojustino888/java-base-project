package umc.sai.controller;
import umc.sai.model.Usuario;

public class ControllerDBUsers {

	private ControllerConexaoDB c;
	
	public void insertUser(Usuario user){
		c = new ControllerConexaoDB();
		String comando =" insert into usuarios (id_tipo,nome,nascimento,cpf,rg,telefone,endereco,login,senha,obs_user) values ("+user.getId_tipo()+"','"+user.getNome()+"','"+user.getNascimento()+"','"+user.getCpf()+"','"+user.getRg()+"','"+user.getTelefone()+"','"+user.getEndereco()+"','"+user.getLogin()+"','"+user.getSenha()+"','"+user.getObs_user()+"');";
		if(c.executarComando(comando)==0){
			System.out.println("DEU ERRO AO CADASTRAR usuario");
		}
		c.fecharConexao();
	}

	public void deleteUser(Usuario user){
		c = new ControllerConexaoDB();
		String comando =" delete from usuarios where id_user ="+user.getId_user()+";";
		if(c.executarComando(comando)==0){
			System.out.println("DEU ERRO AO Deletar Usuario");
		}
		c.fecharConexao();
	}
		
}