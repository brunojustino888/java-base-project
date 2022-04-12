package umc.passosBlueJ;

//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** TelaComparar
* Projeto..: Pacote
* [ coloque aqui a descri��o da classe ]
* @author Fernando Anselmo � Set - 2012
* @version 1.0
*/
public class TelaComparar extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 private JLabel objeto0;
 private JLabel label1;
 private JLabel label2;
 private JLabel objeto3;
 private JTextField txa;
 private JTextField txb;
 private JTextField txc;
 private JTextField txtresult;
 private JButton botaoMaior;
 private JButton botaoMenor;
 private JButton objeto11;

 public TelaComparar() {
     // Bloco 2 - Dados da Cria��o da Janela
	this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(0, 204, 204));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(336, 230));
     this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
     this.setTitle("Caixa de Compara��es");
     this.setResizable(false);


     // Bloco 3 - Dados da Cria��o dos Controles na Janela
	objeto0 = new JLabel("A");
     objeto0.setBounds(new Rectangle(9, 10, 10, 10));
     this.getContentPane().add(objeto0, null);
     label1 = new JLabel("B");
     label1.setBounds(new Rectangle(59, 10, 10, 10));
     this.getContentPane().add(label1, null);
     label2 = new JLabel("C");
     label2.setBounds(new Rectangle(110, 10, 10, 10));
     this.getContentPane().add(label2, null);
     objeto3 = new JLabel("Resultado");
     objeto3.setBounds(new Rectangle(268, 10, 59, 13));
     this.getContentPane().add(objeto3, null);
     txa = new JTextField();
     txa.setBounds(new Rectangle(2, 27, 25, 21));
     this.getContentPane().add(txa, null);
     txb = new JTextField();
     txb.setBounds(new Rectangle(50, 27, 25, 21));
     this.getContentPane().add(txb, null);
     txc = new JTextField();
     txc.setBounds(new Rectangle(102, 27, 25, 21));
     this.getContentPane().add(txc, null);
     txtresult = new JTextField();
     txtresult.setBounds(new Rectangle(280, 27, 30, 21));
     this.getContentPane().add(txtresult, null);
     botaoMaior = new JButton("Maior");
     botaoMaior.setBounds(new Rectangle(16, 90, 100, 30));
     this.getContentPane().add(botaoMaior, null);
     botaoMaior.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	 double lA, lB, lC;
             lA = Double.parseDouble(txa.getText());
             lB = Double.parseDouble(txb.getText());
             lC = Double.parseDouble(txc.getText());
           
             Comparar sau = new Comparar();
             txtresult.setText(sau.maior(lA,lB,lC)+""); 
        	 
        	 
         }
     });
     botaoMenor = new JButton("Menor");
     botaoMenor.setBounds(new Rectangle(197, 90, 100, 30));
     this.getContentPane().add(botaoMenor, null);
     botaoMenor.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 double lA, lB, lC;
             lA = Double.parseDouble(txa.getText());
             lB = Double.parseDouble(txb.getText());
             lC = Double.parseDouble(txc.getText());
           
             Comparar sau = new Comparar();
             txtresult.setText(sau.menor(lA,lB,lC)+""); 
         }
     });
     objeto11 = new JButton("M�dia");
     objeto11.setBounds(new Rectangle(106, 150, 100, 30));
     this.getContentPane().add(objeto11, null);
     objeto11.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 double lA, lB, lC;
             lA = Double.parseDouble(txa.getText());
             lB = Double.parseDouble(txb.getText());
             lC = Double.parseDouble(txc.getText());
           
             Comparar sau = new Comparar();
             txtresult.setText(sau.media(lA,lB,lC)+""); 
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
     new TelaComparar();
 }
}