package umc.passosBlueJ;

//Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

/** Esta aplica��o faz analogia a uma agenda digital.
* @author Bruno Alves Justino � Nov - 2012
* @version 8.8
*/
public class AgendaTelaTest extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Bloco 1 - Dados dos Objetos da Janela
private JLabel LabelNome;
 private JTextField JTextFieldCod;
 private JLabel objeto2;
 private JTextField JTextFieldNome;
 private JTextField objeto4;
 private JLabel JTextFieldCPF;
 private JButton JButtonIncluir;
 private JButton JButtonExcluir;
 private JButton JButtonAtualizar;
 private JButton JButtonConsultar;


 static int codigogerado;

 public AgendaTelaTest() {
     // Bloco 2 - Dados da Cria��o da Janela
	 this.getContentPane().setLayout(null);
     this.getContentPane().setBackground(new Color(255, 102, 0));
     java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     this.setSize(new java.awt.Dimension(389, 183));
     this.setLocation((screenSize.width-389)/2,(screenSize.height-183)/2);
     this.setTitle("Cadastro de Clientes");
     this.setResizable(false);




     // Bloco 3 - Dados da Cria��o dos Controles na Janela
	LabelNome = new JLabel("C�digo:");
     LabelNome.setBounds(new Rectangle(10, 10, 57, 13));
     this.getContentPane().add(LabelNome, null);
     JTextFieldCod = new JTextField();
     JTextFieldCod.setBounds(new Rectangle(58, 7, 40, 21));
     this.getContentPane().add(JTextFieldCod, null);
     objeto2 = new JLabel("Nome:");
     objeto2.setBounds(new Rectangle(11, 41, 57, 13));
     this.getContentPane().add(objeto2, null);
     JTextFieldNome = new JTextField();
     JTextFieldNome.setBounds(new Rectangle(57, 37, 250, 21));
     this.getContentPane().add(JTextFieldNome, null);
     objeto4 = new JTextField();
     objeto4.setBounds(new Rectangle(57, 67, 100, 21));
     this.getContentPane().add(objeto4, null);
     JTextFieldCPF = new JLabel("CPF:");
     JTextFieldCPF.setBounds(new Rectangle(12, 73, 57, 13));
     this.getContentPane().add(JTextFieldCPF, null);
     JButtonIncluir = new JButton("Incluir");
     JButtonIncluir.setBounds(new Rectangle(6, 111, 89, 30));
     this.getContentPane().add(JButtonIncluir, null);
     JButtonIncluir.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
    
        	 codigogerado++;
        	 String nomeaincluir = JTextFieldNome.getText();
        	 String cpfaincluir = JTextFieldCPF.getText();
        	 String telaincluir = objeto4.getText();
        	 
        	 
        		        Conexao oConn = new Conexao();
        		       
        		           		        
        		        try   {
        		        	
        		        	oConn.executarComando("insert into Agenda (ID,NOME,CPF,TELEFONE) values ('"+codigogerado+"','"+nomeaincluir+"','"+cpfaincluir+"','"+telaincluir+"')");
        		        	
        		        	
        		        	
        		            ResultSet rs = oConn.executarConsulta("select ID, NOME from Agenda");    
        		            while(rs.next())    {
        		                System.out.println(rs.getString(1)+"\t"+rs.getString(2));
        		            }
        		            
        		            
        		            
        		            
        		        } catch(Exception erro)   {
        		        	JOptionPane.showMessageDialog(null,"N�o foi poss�vel incluir os dados na agenda.\nVoc� n�o est� capacitado porque n�o houve conex�o com o banco de dados.\n Os dados foram:\n Cod: "+codigogerado+".\n Nome: "+nomeaincluir+".","ERRO!",0);
        		            System.out.println(erro.getMessage());
        		        } finally{
        		        	System.out.println("ERRO"+nomeaincluir);
        		        }
        		        
        		        
        		        oConn.fecharConexao();
        	

         
         }
     });
     JButtonExcluir = new JButton("Excluir");
     JButtonExcluir.setBounds(new Rectangle(100, 111, 89, 30));
     this.getContentPane().add(JButtonExcluir, null);
     JButtonExcluir.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
         }
     });
     JButtonAtualizar = new JButton("Atualizar");
     JButtonAtualizar.setBounds(new Rectangle(194, 111, 89, 30));
     this.getContentPane().add(JButtonAtualizar, null);
     JButtonAtualizar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
         }
     });
     JButtonConsultar = new JButton("Consultar");
     JButtonConsultar.setBounds(new Rectangle(288, 111, 89, 30));
     this.getContentPane().add(JButtonConsultar, null);
     JButtonConsultar.addActionListener (new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Chamada a um m�todo
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
     new AgendaTelaTest();
 }
}