package umc.games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** JFrameFemale
 * Projeto..: Games
 * [ Classe criada para receber o nome da jogadora. ]
 * @author Bruno Alves Justino � Set - 2012
 * @version 1.0
 */
public class JFrameFemale extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel JLabelFemaleName;
    private JTextField JTextFieldFemaleName;
    private JButton JButtonFemale;

    public JFrameFemale() {
       
	this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 51, 153));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(336, 230));
        this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
        this.setTitle("Player Female");
        this.setResizable(false);

        JLabelFemaleName = new JLabel("Your Name:");
        JLabelFemaleName.setBounds(new Rectangle(135, 28, 70, 13));
        this.getContentPane().add(JLabelFemaleName, null);
        JTextFieldFemaleName = new JTextField();
        JTextFieldFemaleName.setBounds(new Rectangle(115, 68, 100, 21));
        this.getContentPane().add(JTextFieldFemaleName, null);
        JButtonFemale = new JButton("OK");
        JButtonFemale.setBounds(new Rectangle(115, 120, 100, 30));
        this.getContentPane().add(JButtonFemale, null);
        JButtonFemale.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
               String s;
               
               s = JTextFieldFemaleName.getText();
                                            
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
        new JFrameFemale();
    }
}