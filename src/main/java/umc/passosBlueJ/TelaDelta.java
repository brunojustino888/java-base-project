package umc.passosBlueJ;


//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDelta extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 private JTextArea objeto0; //saida
 private JButton objeto3;
 private JButton objeto2;
 private JButton objeto1;
 private JTextField objeto4; //a
 private JTextField objeto5; //b
 private JTextField objeto6; //c
 private JLabel objeto7;
 private JLabel objeto8;
 private JLabel objeto9;
 private JLabel objeto10;

 public TelaDelta() {
     // Bloco 2 - Dados da Cria��o da Janela
 this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(153, 153, 255));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(336, 230));
     this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
     this.setTitle("Cafeteira - Vers�o 1.11 - Java");
     this.setResizable(false);

     // Bloco 3 - Dados da Cria��o dos Controles na Janela
 objeto0 = new JTextArea();
     objeto0.setBounds(new Rectangle(114, 51, 130, 80));
     this.getContentPane().add(objeto0, null);
     objeto3 = new JButton("Sair");
     objeto3.setBounds(new Rectangle(223, 161, 100, 30));
     this.getContentPane().add(objeto3, null);
     objeto3.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dispose();
         }
     });
     objeto2 = new JButton("Limpar");
     objeto2.setBounds(new Rectangle(114, 161, 100, 30));
     this.getContentPane().add(objeto2, null);
     objeto2.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             
             objeto4.setText("");
             objeto5.setText("");
             objeto6.setText("");
             objeto4.requestFocus();
         
         }
     });
     objeto1 = new JButton("Calcular");
     objeto1.setBounds(new Rectangle(3, 161, 100, 30));
     this.getContentPane().add(objeto1, null);
     objeto1.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {

             double lA, lB, lC;
               lA = Double.parseDouble(objeto4.getText());
               lB = Double.parseDouble(objeto5.getText());
               lC = Double.parseDouble(objeto6.getText());
             
               Equacao2grau objEquacao = new Equacao2grau(lA,lB,lC);
               objEquacao.raizes();
         }
     });
     objeto4 = new JTextField();
     objeto4.setBounds(new Rectangle(24, 42, 50, 21));
     this.getContentPane().add(objeto4, null);
     objeto5 = new JTextField();
     objeto5.setBounds(new Rectangle(25, 81, 50, 21));
     this.getContentPane().add(objeto5, null);
     objeto6 = new JTextField();
     objeto6.setBounds(new Rectangle(26, 120, 50, 21));
     this.getContentPane().add(objeto6, null);
     objeto7 = new JLabel("A");
     objeto7.setBounds(new Rectangle(8, 47, 57, 13));
     this.getContentPane().add(objeto7, null);
     objeto8 = new JLabel("B");
     objeto8.setBounds(new Rectangle(8, 87, 57, 9));
     this.getContentPane().add(objeto8, null);
     objeto9 = new JLabel("C");
     objeto9.setBounds(new Rectangle(8, 122, 57, 12));
     this.getContentPane().add(objeto9, null);
     objeto10 = new JLabel("Equa��o de 2� Grau");
     objeto10.setBounds(new Rectangle(110, 19, 115, 13));
     this.getContentPane().add(objeto10, null);

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
     new TelaDelta();
 }
}