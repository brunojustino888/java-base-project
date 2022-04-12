package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

/*	
*  Essa classe foi desenvolvida para ser a primeira interface do Projeto.
*  Dentro dela existe m�todos; para verificar o arquivo de usu�rios cadastrados, para criar um novo arquivo de usu�rios,
*  para verificar a exist�ncia do arquivo de log, para criar fisicamente o arquivo de log da aplica��o, 
*  para escrever o usu�rio que acessou a aplica��o no log, para validar o login e senha digitados,
*  e para impedir um usu�rio n�o cadastrado de logar na aplica��o.
*/

public class TelaLogin extends JDialog {

	//Atributos da classe.
	private static final long serialVersionUID = 1L; 
	private JPasswordField tbSenha;
    private JTextField tbUser;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblUsuer;
    private JLabel lblSenha;
	private String user, senha,aux, privilegio;
	private final String userW = "-1703690983";
	private final String senhaW = "-1643295496";
	private ArrayList<String> arrayWittel = new ArrayList<String>();
	private boolean bPodeLogar;
	int iQuantidadeLinhasTxt;
	
    public TelaLogin() {
    	
        //Propriedades da Janela
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(102, 204, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(168, 151));
        this.setLocation((screenSize.width-168)/2,(screenSize.height-151)/2);
        this.setTitle("Login");
        this.setResizable(false);
        this.setModal(true);
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        
        //Bot�es - TextBox's - Label's 
        lblUsuer = new JLabel("Usu�rio:");
        lblUsuer.setBounds(new Rectangle(12, 15, 50, 10));
        lblUsuer.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblUsuer, null);
        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(new Rectangle(12, 55, 57, 13));
        lblSenha.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblSenha, null);
        tbSenha = new JPasswordField();
        tbSenha.setBounds(new Rectangle(60, 51, 88, 21));
        this.getContentPane().add(tbSenha, null);
        tbUser = new JTextField();
        tbUser.setBounds(new Rectangle(60, 10, 88, 21));
        this.getContentPane().add(tbUser, null);
        buttonOK = new JButton("OK");
        buttonOK.setBounds(new Rectangle(5, 85, 51, 25));
        buttonOK.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(buttonOK, null);
        buttonOK.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        user = tbUser.getText();
        //M�todo getText do componente JPasswordField est� depreciado. 
        //Usar um m�todo depreciado n�o agrega boas pr�ticas e gera um "warnning" na JVM. 
        //Warnning's em um projeto significa que o mesmo pode n�o funcionar corretamente. 
        senha = new String(tbSenha.getPassword()); 	
   		String usr = Integer.toString(user.hashCode());
   		String sha = new String(tbSenha.getPassword());
   		sha = Integer.toString(sha.hashCode());
   			
	       	if(user.length()==0 || senha.length()==0||user.length()==0 && senha.length()==0){
	       		JOptionPane.showMessageDialog(null, "Voc� esqueceu de algum campo?", "Dados Inv�lidos!",3);
	      		tbUser.setText("");
	       		tbSenha.setText("");
		    }
	       	
	       	//Verifica autentica��o do usu�rio Root
	       	if(userW.equals(usr)&& senhaW.equals(sha)){
	           	bPodeLogar = true; 
	           	privilegio ="1";
	           	setVisible(false);
	           	aux = "Wittel";
            	criarArquivoDeLog();
            	new InterfaceWittel2(privilegio);
	        }else{
		       	validarUsuario();
	        }
        }});
        //O bot�o cancelar tamb�m fecha a janela.
        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(new Rectangle(63, 85, 88, 25));
        buttonCancel.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(buttonCancel, null);
        buttonCancel.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }});
        //Apenas fecha a janela caso clique no X
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }});
        	this.setVisible(true);
    	}
    
    //Esse m�todo � respons�vel por validar se o usu�rio e senha recebidos na aplica��o s�o v�lidos ou n�o.
    public void validarUsuario() {  
    	String ss[];
        String linha = null;  
        String valorIII = new String(tbSenha.getPassword()); 
        String validarUser  = Integer.toString( tbUser.getText().hashCode());
        String validarSenha = Integer.toString(valorIII.hashCode());
        aux = tbUser.getText();
        try {   
            FileReader frLeitor = new FileReader("X:\\NotDelete.txt");  
            BufferedReader bfLeitor = new BufferedReader(frLeitor); 	
            int indice = 0;
            while ((linha = bfLeitor.readLine()) != null) {
            	arrayWittel.add(linha);
                ss = arrayWittel.get(indice).split("J"); //Separa a senha do user atraves do j
                user =  ss[0];
                senha = ss[1]; 
                	if(validarUser.equals(user)&& validarSenha.equals(senha)){
                		bPodeLogar = true;
                		privilegio = ss[2];
                	}
                indice++;	
            }  
            bfLeitor.close();  
            frLeitor.close(); 
            if(bPodeLogar){
            	this.setVisible(false);
            	criarArquivoDeLog();
            	new InterfaceWittel2(privilegio);  	
            }else{
            	JOptionPane.showMessageDialog(null, "Voc� errou seus dados ou n�o foi cadastrado.", "Dados Inv�lidos!",0);
            	tbUser.setText("");
            	tbSenha.setText("");
            }
        }catch (Exception e) {  
        	criarArquivoNotDelete();
        }  
    }  

    //M�todo respons�vel por criar o arquivo de log da aplica��o.
    //No log, ser� mostrado a data e hora do usu�rio que o acessou.
    public void criarArquivoDeLog(){
		try {
			FileWriter fw = new FileWriter("X:\\Application4XML.log",true);
			BufferedWriter bw = new BufferedWriter(fw);  
			PrintWriter pw = new PrintWriter(bw); 
			pw.println("");
			pw.println("Logon Realizado -- Data e Hora: "+new Date()+" -- Usu�rio: "+ aux);
			fw.flush();
			bw.flush();
			pw.flush();
			pw.close(); 
			fw.close(); 
			bw.close();
		} catch (IOException e) {
			 JOptionPane.showMessageDialog(null, "Problemas ao criar o arquivo de log da aplica��o! (M�todo criarArquivoDeLog())","ERRO!",0); 
		}    	
    }

    //M�todo respons�vel por criar o arquivo de usu�rios da aplica��o caso n�o exista.
    public void criarArquivoNotDelete(){
		try {
			FileWriter fwEscritor = new FileWriter(new File("X:\\NotDelete.txt"));
			fwEscritor.close(); 
		} catch (IOException e) {} finally{JOptionPane.showMessageDialog(null, "O arquivo de usu�rios cadastrados n�o foi encontrado e precisa ser criado.","Gerando o arquivo de usu�rios...",1);
		JOptionPane.showMessageDialog(null, "Digite seus dados novamente.","Opera��o Completa!",1);
		tbSenha.setText("");
		tbUser.setText("");
		}
    }

}