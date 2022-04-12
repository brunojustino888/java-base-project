package umc.finallyTable;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;


public class MyFraMe extends JFrame {

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
					MyFraMe frame = new MyFraMe();
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
	public MyFraMe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		String[] colunas = {"1","2","3","4","5"};
	    Object [][] dados = { 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "48 8890-3345", "joaosilva@hotmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com", "48 8890-3345", "joaosilva@hotmail.com"},
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "48 8890-3345", "joaosilva@hotmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "48 8890-3345", "joaosilva@hotmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com", "48 8890-3345", "joaosilva@hotmail.com"}, 
		    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "48 8890-3345", "joaosilva@hotmail.com"},
		    		{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com", "48 8890-3345", "joaosilva@hotmail.com"}
	    		};

		
		table = new JTable(dados,colunas);
		table.setBackground(SystemColor.activeCaption);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);
		
	
	}

}