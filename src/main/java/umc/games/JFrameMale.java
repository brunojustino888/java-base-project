package umc.games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** JFrameMale
 * Projeto..: Pacote
 * [ Classe criada para receber o nome da jogador ]
 * @author Bruno Alves Justino � Set - 2012
 * @version 1.0
 */

public class JFrameMale extends JFrame {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JLabel JLabelMaleName;
    	private JTextField JTextFieldMaleName;
   	private JButton JButtonMale;

    public JFrameMale() {

        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(51, 153, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(336, 230));
        this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
        this.setTitle("Player Male");
        this.setResizable(false);

        JLabelMaleName = new JLabel("Your Name:");
        JLabelMaleName.setBounds(new Rectangle(135, 28, 70, 13));
        this.getContentPane().add(JLabelMaleName, null);
        JTextFieldMaleName = new JTextField();
        JTextFieldMaleName.setBounds(new Rectangle(115, 68, 100, 21));
        this.getContentPane().add(JTextFieldMaleName, null);
        JButtonMale = new JButton("OK");
        JButtonMale.setBounds(new Rectangle(115, 120, 100, 30));
        this.getContentPane().add(JButtonMale, null);
        JButtonMale.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	 String s;
                 
                 s = JTextFieldMaleName.getText(); 
                 
                 dispose();
                 
                 JOptionPane.showMessageDialog(null,s,"Nome Escolhido",2);          
            	
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                aoFechar();
            }
        });
        this.setVisible(true);
    }

    private void aoFechar() {
        System.exit(0);
    }

    // Insira aqui os m�todos para os eventos

    public static void main(String args[]) {
        new JFrameMale();
    }
}