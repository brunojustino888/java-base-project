package gidestock.model;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class OutroFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutroFrame frame = new OutroFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OutroFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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

		
		table = new JTable(dados,colunas);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		contentPane.add(table, BorderLayout.CENTER);
		
	
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.EAST);

		
		
	}

}
