package umc.passosBlueJM2;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario{

	//M�todo Sobrescrito
	public void exibeDados(){
	JOptionPane.showInputDialog(null,"Nome do Gerente: "+this.getNome()+".\nMatricula: "+this.getMatricula()+".","GERENTES",1);
}

}
