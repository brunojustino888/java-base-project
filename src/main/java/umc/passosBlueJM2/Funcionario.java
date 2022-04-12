package umc.passosBlueJM2;

import javax.swing.JOptionPane;

public class Funcionario {


	private String nome;
	private String numeroMatricula;
	

	//M�todo Get Da Matr�cula (Encapsulamento)
	public String getMatricula(){
		return numeroMatricula;
	}
	
	//M�todo para mostrar os dados
	public void exibeDados(){
		JOptionPane.showInputDialog(null,"Nome: "+nome+".\n"+numeroMatricula+".","Dados...",1);
	}

	//M�todo para retornar o nome (Encapsulamento)
	public String getNome(){
		return nome;
	}
	
	
}


