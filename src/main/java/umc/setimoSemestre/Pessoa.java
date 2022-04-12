package umc.setimoSemestre;

public class Pessoa {

	private Usuario user;
	private Perfil usertype;
	
	public Pessoa() {
		user = new Usuario();
		user.setNome("Nome de Usu�rio Default");
		user.setLogin("Login de Usu�rio Default");
		user.setSenha("123456");
		usertype = new Perfil();
		usertype.setNome("Tipo de Usu�rio Default");
	}
	
	public Pessoa(String nome, String login, String senha, String tipo) {
		user = new Usuario();
		user.setNome(nome);
		user.setLogin(login);
		user.setSenha(senha);
		usertype = new Perfil();
		usertype.setNome(tipo);
	}
	
	
	public Perfil getUsertype() {
		return usertype;
	}

	public void setUsertype(Perfil usertype) {
		this.usertype = usertype;
	}

	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
}