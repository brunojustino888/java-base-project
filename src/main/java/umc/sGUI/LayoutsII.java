package umc.sGUI;


import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class LayoutsII extends JFrame {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LayoutsII(){
	
		super("LayoutsII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		Container c = getContentPane();/*
		c.setLayout(new BorderLayout(5,5));
		c.add(BorderLayout.NORTH, new JButton("N"));
		c.add(BorderLayout.CENTER, new JButton("c"));
		c.add(BorderLayout.SOUTH, new JButton("s"));
		c.add(BorderLayout.EAST, new JButton("e"));
		c.add(BorderLayout.WEST, new JButton("w"));
		*/
		c.setLayout(new GridLayout(2,3));
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		c.add(new JButton("4"));
		c.add(new JButton("5"));
		c.add(new JButton("6"));
		
	}
	
	
	public static void main(String[] args) {
 
		new LayoutsII();
		
	}

	
	
	
}
