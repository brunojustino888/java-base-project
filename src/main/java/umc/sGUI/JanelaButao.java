package umc.sGUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaButao {
 
	public JanelaButao(){
		
		JFrame janela = new JFrame(); //instanciando uma nova janela no construtor
		janela.setSize(300, 300);  //parametro de tamanho e largura
		janela.setVisible(true); //deixando vis�vel
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ao fechar...
		JButton botao = new JButton("Vinicius");
		janela.getContentPane().add(botao);
		
	}
	
	
	public static void main(String[] args) {
 
		new JanelaButao();
		
	}

}
