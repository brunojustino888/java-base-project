package umc.jtable;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyFrame extends JDialog{

	private static final long serialVersionUID = 1L;

	public MyFrame(){
		  this.getContentPane().setLayout(null);
		    this.getContentPane().setBackground(new Color(255, 255, 255));
		    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		    this.setSize(new java.awt.Dimension(306, 228));
	        this.setLocation((screenSize.width-306)/2,(screenSize.height-228)/2);
		    this.setTitle("Menu Principal - GideStock");
		    ImageIcon icone = new ImageIcon("C:\\GideStock\\img\\xbtn.png");
		    this.setIconImage(icone.getImage());
		    
		    String[] colunas = {"1","2","3"};
		    Object [][] dados = { 
			    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
			    		{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"},
			    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
			    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
			    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}
		    		};

		    
		  
		    
		    
		    
		    JPanel painelFundo = new JPanel();
		    painelFundo.setVisible(true);
		    painelFundo.setBounds(new Rectangle(0,0, 300,200));
		    painelFundo.setLayout(new GridLayout(2, 1)); 
		    JTable tabela = new JTable(dados, colunas); 
		   
		    
		    
		    
		    JScrollPane barraRolagem = new JScrollPane(tabela); 
		    
		    painelFundo.add(barraRolagem); 
		    this.getContentPane().add(painelFundo);

		    
		    this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
	    			if(resp==0){
	    				System.exit(0);
	    			}
	            }
	        });
		    
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);
		    
	}
	
}
