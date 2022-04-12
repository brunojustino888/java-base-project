package umc.sClasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Anhinhamento extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton botao;

	
	public Anhinhamento(){
		super("Aninhamento");
		botao = new JButton("Ok");
		botao.addActionListener(new AninhamentoListener());
		botao.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// classe anonima com o metodo j� implementado action
				System.out.println("A Classe anonima est� aqui...");
			}
		});
		getContentPane().add(botao);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}
	
	public class AninhamentoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			System.out.println("A classe anhinhada est� aqui.."+ botao.getText());
		}
		
	}
	public static void main (String args[]){
		new Anhinhamento();
	}
	
}
