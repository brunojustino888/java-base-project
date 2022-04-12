package umc.sGUI;
import javax.swing.*;

public class JanelaI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public JanelaI (){
		
		super("First Window");  // chamando o construtor da Jframe e apassando o nome da janela como paramentro
		JButton botaoI = new JButton("Clique");
		getContentPane().add(botaoI); // adicionamdo o componente na JFrame
		setSize(800, 600); //setando altura e tamanho
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
 
		new JanelaI();
		
	}

}
