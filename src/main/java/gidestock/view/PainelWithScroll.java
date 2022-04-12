package gidestock.view;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;


public class PainelWithScroll extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PainelWithScroll() {
		setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.EAST);

	}

}
