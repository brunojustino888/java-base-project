package umc.sGUI;

import java.awt.*;

import javax.swing.*;

public class LayoutDaJanela extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LayoutDaJanela(){
		super("Second JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		Container c = getContentPane();
				c.add(BorderLayout.NORTH, new JButton("1"));
				c.add(BorderLayout.SOUTH, new JButton("2"));
				c.add(BorderLayout.CENTER, new JButton("3"));
				c.add(BorderLayout.EAST, new JButton("4"));
				c.add(BorderLayout.WEST, new JButton("5"));
	
				
				c.setLayout(new FlowLayout()); //layout de acordo com a ordem de chegada..
				c.add(new JButton("1"));
				c.add(new JButton("2"));
				c.add(new JButton("3"));
				c.add(new JButton("4"));
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				setSize(300, 300);
			
				
				
	}
	
	
	public static void main(String[] args) {
		
		new LayoutDaJanela();

	}

}
