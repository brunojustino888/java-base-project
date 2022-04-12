package gidestock.view;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Tabela extends JFrame{
	
	
	public Tabela(){
		
        setLayout(new FlowLayout());
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(206,148));
        setBackground(new Color(0,0,0));
        this.setLocation((screenSize.width-206)/2,(screenSize.height-148)/2);  
        setSize(206,148);  
        setVisible(true);  
 
        
		String[] colunas = {"COD", "NOME", "ESTOQUE", "PRE�O", "QTD MIN","DESCRI��O"};
		
		Object[][] data = { {"Kathy","Smith","Snowboarding", new Integer(5), new Boolean(false)},
							{"John", "Doe","Rowing", new Integer(3), new Boolean(true)},
							{"Sue", "Black","Knitting", new Integer(2), new Boolean(false)},
			     			{"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
			     			{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
		};

		JTable table = new JTable(data, colunas);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		
		
	}


}

