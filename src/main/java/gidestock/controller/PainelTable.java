package gidestock.controller;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class PainelTable extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Object [][] datadados;

	public PainelTable(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(new BorderLayout());
		this.add(contentPane);
		
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
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"},
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"},
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"}
	    		};
	    datadados = dados;

		
		table = new JTable(dados,colunas);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new java.awt.Dimension(700,160));
		
		contentPane.add(table, BorderLayout.CENTER);
		
	
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.EAST);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		scrollPane.setViewportBorder(BorderFactory.createLoweredBevelBorder());  
		scrollPane.setAutoscrolls(true);  
		//scrollPane.setViewportView(this); 

	}
	
	public JTable getTable(){
		return table;
	}
	
	public Object[][] getData(){
		return datadados;
	}
	
}
