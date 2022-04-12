package umc.passosBlueJ;

//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

/** AgendaTelefonica
* Projeto..: d
* [ coloque aqui a descri��o da classe ]
* @author Fernando Anselmo � Nov - 2012
* @version 1.0
*/
public class AgendaTelefonica extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
 static int codigogerado;
 private JLabel LabelCod;
 private JLabel LabelNome;
 private JLabel LabelTel;
 private JLabel LabelCPF;
 private JTextField JTextFieldCod;
 private JTextField JTextFieldNome;
 private JTextField JTextFieldCPF;
 private JTextField JTextFieldTelefone;
 private JButton ButtonIncluir;
 private JButton ButtonExcluir;
 private JButton ButtonAlterar;
 private JButton ButtonConsultar;
 private JButton ButtonFechar;	
 public AgendaTelefonica() {


     // Bloco 2 - Dados da Cria��o da Janela
     this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(0, 153, 51));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(336, 230));
     this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
     this.setTitle("Agenda Telef�nica");
     this.setResizable(false);



     // Bloco 3 - Dados da Cria��o dos Controles na Janela
	LabelCod = new JLabel("Cod:");
     LabelCod.setBounds(new Rectangle(8, 8, 30, 13));
     this.getContentPane().add(LabelCod, null);
     LabelNome = new JLabel("Nome:");
     LabelNome.setBounds(new Rectangle(8, 38, 57, 13));
     this.getContentPane().add(LabelNome, null);
     LabelTel = new JLabel("Telefone:");
     LabelTel.setBounds(new Rectangle(8, 98, 57, 13));
     this.getContentPane().add(LabelTel, null);
     LabelCPF = new JLabel("CPF:");
     LabelCPF.setBounds(new Rectangle(8, 68, 57, 13));
     this.getContentPane().add(LabelCPF, null);
     JTextFieldCod = new JTextField();
     JTextFieldCod.setBounds(new Rectangle(51, 5, 30, 21));
     this.getContentPane().add(JTextFieldCod, null);
     JTextFieldNome = new JTextField();
     JTextFieldNome.setBounds(new Rectangle(51, 33, 275, 21));
     this.getContentPane().add(JTextFieldNome, null);
     JTextFieldCPF = new JTextField();
     JTextFieldCPF.setBounds(new Rectangle(51, 63, 150, 21));
     this.getContentPane().add(JTextFieldCPF, null);
     JTextFieldTelefone = new JTextField();
     JTextFieldTelefone.setBounds(new Rectangle(66, 93, 100, 21));
     this.getContentPane().add(JTextFieldTelefone, null);
     ButtonIncluir = new JButton("Incluir");
     ButtonIncluir.setBounds(new Rectangle(5, 130, 100, 30));
     this.getContentPane().add(ButtonIncluir, null);
     ButtonIncluir.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	 int m = codigogerado++;
        	 String ss = Integer.toString(m);
        	 JTextFieldCod.setText(ss);
        	 String nomeaincluir = JTextFieldNome.getText();
        	 String cpfaincluir = JTextFieldCPF.getText();
        	 String telaincluir = JTextFieldTelefone.getText();
        	 
        	 Conexao a = new Conexao();
		        
		        try {		        	
		             a.executarComando("insert into Agenda (ID,NOME,CPF,TELEFONE) values ('"+codigogerado+"','"+nomeaincluir+"','"+cpfaincluir+"','"+telaincluir+"')");
		            		            
		        	} catch(Exception erro)   {
		           	JOptionPane.showMessageDialog(null,"N�o foi poss�vel incluir os dados na agenda.\nVoc� n�o est� capacitado porque n�o houve conex�o com o banco de dados.\n Os dados foram:\n Cod: "+codigogerado+".\n Nome: "+nomeaincluir+".","ERRO!",0);
		            System.out.println(erro.getMessage());
		        } 
		        
		        
		        a.fecharConexao();
	
        	 
         }
     });
     ButtonExcluir = new JButton("Excluir");
     ButtonExcluir.setBounds(new Rectangle(5, 163, 100, 30));
     this.getContentPane().add(ButtonExcluir, null);
     ButtonExcluir.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	 String nomeaexcluir = JTextFieldNome.getText();
        	 Conexao a = new Conexao();
		        
		        try {		        	
		             a.executarComando("delete from Agenda where Nome = '"+nomeaexcluir+"'");
		            		            
		        	} catch(Exception erro)   {
		           	JOptionPane.showMessageDialog(null,"N�o foi poss�vel!.\nVoc� n�o est� capacitado porque n�o houve conex�o com o banco de dados.");
		            System.out.println(erro.getMessage());
		        } 
		        
		        
		        a.fecharConexao();
        	 
         }
     });
     ButtonAlterar = new JButton("Alterar");
     ButtonAlterar.setBounds(new Rectangle(112, 130, 100, 30));
     this.getContentPane().add(ButtonAlterar, null);
     ButtonAlterar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	
         }
     });
     ButtonConsultar = new JButton("Consultar");
     ButtonConsultar.setBounds(new Rectangle(112, 163, 100, 30));
     this.getContentPane().add(ButtonConsultar, null);
     ButtonConsultar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 
        	 

        	 
        	 
         }
     });
     ButtonFechar = new JButton("Fechar");
     ButtonFechar.setBounds(new Rectangle(224, 150, 100, 30));
     this.getContentPane().add(ButtonFechar, null);
     ButtonFechar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
        	 dispose();
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
     new AgendaTelefonica();
 }
}