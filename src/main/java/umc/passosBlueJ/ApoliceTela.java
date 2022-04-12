package umc.passosBlueJ;


//Exerc�cios 1 e 2
//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** ApoliceTela
* Projeto..: Pacote
* [ coloque aqui a descri��o da classe ]
* @author Fernando Anselmo � Out - 2012
* @version 1.0
*/
public class ApoliceTela extends JFrame {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 private JLabel LabelSegurado;
 private JTextField JTextFieldSegurado;
 private JLabel LabelIdade;
 private JTextField JTextFieldIdade;
     private JLabel LabelPremio;
 private JTextField objeto5;
     private JButton ButtonPremio;
 private JButton ButtonLimpar;
 private JButton ButtonImprimir;

 public ApoliceTela() {
     // Bloco 2 - Dados da Cria��o da Janela
 this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(255, 102, 102));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(336, 230));
     this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
     this.setTitle("Prova M1 - Jos� e Bruno ");
     this.setResizable(false);

     // Bloco 3 - Dados da Cria��o dos Controles na Janela
 LabelSegurado = new JLabel("Segurado:");
     LabelSegurado.setBounds(new Rectangle(8, 8, 60, 15));
     this.getContentPane().add(LabelSegurado, null);
     JTextFieldSegurado = new JTextField();
     JTextFieldSegurado.setBounds(new Rectangle(73, 7, 250, 21));
     this.getContentPane().add(JTextFieldSegurado, null);
     LabelIdade = new JLabel("Idade:");
     LabelIdade.setBounds(new Rectangle(10, 74, 57, 13));
     this.getContentPane().add(LabelIdade, null);
     JTextFieldIdade = new JTextField();
     JTextFieldIdade.setBounds(new Rectangle(51, 68, 100, 21));
     this.getContentPane().add(JTextFieldIdade, null);
     LabelPremio = new JLabel("Pr�mio:");
     LabelPremio.setBounds(new Rectangle(168, 75, 57, 13));
     this.getContentPane().add(LabelPremio, null);
     objeto5 = new JTextField();
     objeto5.setBounds(new Rectangle(218, 70, 100, 21));
     this.getContentPane().add(objeto5, null);
     ButtonPremio = new JButton("Pr�mio");
     ButtonPremio.setBounds(new Rectangle(112, 145, 100, 30));
     this.getContentPane().add(ButtonPremio, null);
     ButtonPremio.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
             String n = JTextFieldSegurado.getText();
             int i = Integer.parseInt(JTextFieldIdade.getText());
             double d = Double.parseDouble(objeto5.getText());
             Apolice um = new Apolice(n,i,d);
             um.calcularPremio();
             um.imprimir();
 }
     });
     ButtonLimpar = new JButton("Limpar");
     ButtonLimpar.setBounds(new Rectangle(221, 145, 100, 30));
     this.getContentPane().add(ButtonLimpar, null);
     ButtonLimpar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
          JTextFieldSegurado.setText("");
          JTextFieldIdade.setText("");
          objeto5.setText("");
         }
     });
     ButtonImprimir = new JButton("Imprimir");
     ButtonImprimir.setBounds(new Rectangle(2, 145, 100, 30));
     this.getContentPane().add(ButtonImprimir, null);
     ButtonImprimir.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
                String n = JTextFieldSegurado.getText();
             int i = Integer.parseInt(JTextFieldIdade.getText());
             double d = Double.parseDouble(objeto5.getText());
             Apolice um = new Apolice(n,i,d);
             um.calcularPremio();
             um.imprimir();
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
     new ApoliceTela();
 }
}