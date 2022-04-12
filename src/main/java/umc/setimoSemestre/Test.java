package umc.setimoSemestre;

public class Test {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		Usuario user = pessoa.getUser();
		Perfil p = pessoa.getUsertype();
		
		System.out.println("Nome: "+user.getNome());
		System.out.println("Login: "+user.getLogin());
		System.out.println("Senha: "+user.getSenha());
		System.out.println("Tipo: "+p.getNome());
		System.out.println("Id: "+p.getId());
		
		System.out.println();
		
		Pessoa pessoa1 = new Pessoa();
		Usuario user1 = pessoa1.getUser();
		Perfil p1 = pessoa1.getUsertype();
		
		System.out.println("Nome: "+user1.getNome());
		System.out.println("Login: "+user1.getLogin());
		System.out.println("Senha: "+user1.getSenha());
		System.out.println("Tipo: "+p1.getNome());
		System.out.println("Id: "+p1.getId());
		
		System.out.println();
		
		Pessoa pessoa2 = new Pessoa();
		Usuario user2 = pessoa2.getUser();
		Perfil p2 = pessoa2.getUsertype();
		
		System.out.println("Nome: "+user2.getNome());
		System.out.println("Login: "+user2.getLogin());
		System.out.println("Senha: "+user2.getSenha());
		System.out.println("Tipo: "+p2.getNome());
		System.out.println("Id: "+p2.getId());
		
		new TelaLogin();
		
	}

}