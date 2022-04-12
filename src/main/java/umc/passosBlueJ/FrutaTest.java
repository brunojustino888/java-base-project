package umc.passosBlueJ;

//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** FrmFrutas
* [ coloque aqui a descri��o da classe ]
* @author Fernando Anselmo � Out - 2012
* @version 1.0
*/
public class FrutaTest extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 private JTextField txtFruta;
 private JComboBox<String> cmbFruta;
 private JButton btnINS;
 private JButton btnDEL;
 private JButton btnVER;
 private Fruta oFruta;

 public FrutaTest() {
     // Bloco 2 - Dados da Cria��o da Janela
     this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(238, 238, 238));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(286, 146));
     this.setLocation((screenSize.width-286)/2,(screenSize.height-146)/2);
     this.setTitle("Cafeteira - Vers�o 1.11 - Java");
     this.setResizable(false);

     // Bloco 3 - Dados da Cria��o dos Controles na Janela
      txtFruta = new JTextField();
     txtFruta.setBounds(new Rectangle(33, 18, 100, 21));
     this.getContentPane().add(txtFruta, null);
     cmbFruta = new JComboBox<String>();
     cmbFruta.setBounds(new Rectangle(136, 18, 100, 20));
     this.getContentPane().add(cmbFruta, null);
     btnINS = new JButton("INS");
     btnINS.setBounds(new Rectangle(28, 60, 70, 30));
     this.getContentPane().add(btnINS, null);
     btnINS.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
             oFruta = new Fruta(txtFruta.getText());
              cmbFruta.addItem(oFruta.getFruta());
         }
     });
     btnDEL = new JButton("DEL");
     btnDEL.setBounds(new Rectangle(111, 60, 70, 30));
     this.getContentPane().add(btnDEL, null);
     btnDEL.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
             if(cmbFruta.getSelectedIndex()>-1)
                 cmbFruta.removeItemAt(cmbFruta.getSelectedIndex());
             else
                 JOptionPane.showMessageDialog(null,"N�o existem elementos para serem apagados","mensagem",0);
         }
     });
     btnVER = new JButton("VER");
     btnVER.setBounds(new Rectangle(191, 60, 70, 30));
     this.getContentPane().add(btnVER, null);
     btnVER.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
             oFruta.imprimirFruta(cmbFruta.getSelectedItem());
             
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
     new FrutaTest();
 }
}