package umc.passosBlueJ;

//Exerc�cio 4
//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** MatematicaTela
* Projeto..: Pacote
* [ coloque aqui a descri��o da classe ]
* @author Fernando Anselmo � Out - 2012
* @version 1.0
*/
public class MatematicaTela extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 private JLabel LabelInicio;
 private JTextField JTextFieldInicio;
 private JLabel LabelFim;
 private JTextField JTextFieldFim;
 private JButton JButtonCalcular;
 private JButton JButtonSair;
 private JButton JButtonLimpar;
 private JLabel LabelSomaPar;
 private JLabel LabelSomaIntervalos;
 private JTextField JTextFieldPares;
 private JTextField JTexFieldIntervalos;
 private JLabel objeto11;	
 public MatematicaTela() {

     // Bloco 2 - Dados da Cria��o da Janela
	this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(204, 153, 0));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(336, 230));
     this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
     this.setTitle("M1 - Jos� e Bruno - Matem�tica");
     this.setResizable(false);
     

	// Bloco 3 - Dados da Cria��o dos Controles na Janela
	LabelInicio = new JLabel("In�cio");
     LabelInicio.setBounds(new Rectangle(8, 8, 40, 15));
     this.getContentPane().add(LabelInicio, null);
     JTextFieldInicio = new JTextField();
     JTextFieldInicio.setBounds(new Rectangle(50, 7, 20, 20));
     this.getContentPane().add(JTextFieldInicio, null);
     LabelFim = new JLabel("Fim");
     LabelFim.setBounds(new Rectangle(8, 40, 40, 15));
     this.getContentPane().add(LabelFim, null);
     JTextFieldFim = new JTextField();
     JTextFieldFim.setBounds(new Rectangle(50, 40, 20, 20));
     this.getContentPane().add(JTextFieldFim, null);
     JButtonCalcular = new JButton("Calcular");
     JButtonCalcular.setBounds(new Rectangle(20, 88, 100, 50));
     this.getContentPane().add(JButtonCalcular, null);
     JButtonCalcular.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	 int primeiro  = Integer.parseInt(JTextFieldInicio.getText());
        	 int ultimo   =  Integer.parseInt(JTextFieldFim.getText());
        	 Matematica sw = new Matematica();
        	 sw.mostrarSoma(primeiro, ultimo);
        	 JTexFieldIntervalos.setText(sw.resultado+""); // !!!!!!!!!!!!!!!!!Aqui tem que concaternar para poder colocar um tipo int no parametro do setText!!!!!!!!!!!!!!!!!!!!!!!!!!
        	 sw.mostrarSomaPares(primeiro, ultimo);
        	 JTextFieldPares.setText(sw.resultado+"");
         }
     });
     JButtonSair = new JButton("Sair");
     JButtonSair.setBounds(new Rectangle(1, 155, 318, 30));
     this.getContentPane().add(JButtonSair, null);
     JButtonSair.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 dispose(); // Zacarias � cheio de carta na manga! - S� tinha um exemplo desse m�todo... na tela que calcula delta
         }
     });
     JButtonLimpar = new JButton("Limpar");
     JButtonLimpar.setBounds(new Rectangle(200, 88, 100, 50));
     this.getContentPane().add(JButtonLimpar, null);
     JButtonLimpar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 JTextFieldInicio.setText("");
             JTextFieldFim.setText("");
             JTextFieldPares.setText("");
             JTexFieldIntervalos.setText("");
             
         }
     });
     LabelSomaPar = new JLabel("Soma dos Pares = ");
     LabelSomaPar.setBounds(new Rectangle(130, 11, 110, 15));
     this.getContentPane().add(LabelSomaPar, null);
     LabelSomaIntervalos = new JLabel("Soma dos Intervalos = ");
     LabelSomaIntervalos.setBounds(new Rectangle(131, 51, 130, 15));
     this.getContentPane().add(LabelSomaIntervalos, null);
     JTextFieldPares = new JTextField();
     JTextFieldPares.setBounds(new Rectangle(242, 10, 40, 20));
     this.getContentPane().add(JTextFieldPares, null);
     JTexFieldIntervalos = new JTextField();
     JTexFieldIntervalos.setBounds(new Rectangle(264, 50, 35, 20));
     this.getContentPane().add(JTexFieldIntervalos, null);
     objeto11 = new JLabel("CAFETERIA'S");
     objeto11.setBounds(new Rectangle(123, 107, 100, 19));
     this.getContentPane().add(objeto11, null);

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
     new MatematicaTela();
 }
}