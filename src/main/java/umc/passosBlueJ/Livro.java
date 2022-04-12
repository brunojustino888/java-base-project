package umc.passosBlueJ;

/*defina a classe livro , esta classe deve ter no maximo 5 atributos e
todos eles devem ser privates. A classe deve conter um metodo para mostrar os dados do livro,
n�o esquecer set e get se necessario*/


public class Livro {

	private String colecao,nome,autor,editora;
	private int cod;
	
	
	public void setA(String ocolecao, String onome, String oautor, String oeditora) {
		colecao = ocolecao;
		nome = onome;
		autor = oautor;
		editora = oeditora;
	}
		
	
		void apresentar() {
		
		System.out.println("Cole��o "+colecao);
		System.out.println("Livro " + nome);
		System.out.println("Autor " + autor);
		System.out.println("Editora "+editora);
		System.out.println("C�digo "+cod);
	}
	
}
