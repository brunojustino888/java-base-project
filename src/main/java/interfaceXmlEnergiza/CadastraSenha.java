package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

/*	
* Essa classe � usada para cadastrar um determinado usu�rio na aplica��o.
* Ela tamb�m ser� respons�vel por cadastrar uma senha e tamb�m verificar se � poss�vel o cadastro desse novo usu�rio.
*/

public class CadastraSenha extends JFrame {

	//Objetos da Janela
	private static final long serialVersionUID = 1L;
    private JLabel lblSenha,lblDeNovo, lblImage2, lblAdmin;
    private JPasswordField jpfSenha, jpfConfirmacao;
    private JButton btnOK;
    private JCheckBox checkVIP;
    private String usuario, vip, privilegio;
    
    public CadastraSenha(String user, String p) {
    	
    //Dados da Cria��o da Janela
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(255, 255, 255));
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(new java.awt.Dimension(210, 167));
    this.setLocation((screenSize.width-210)/2,(screenSize.height-167)/2);
    this.setTitle("Cadastrar Senha");
    this.setResizable(false);
    usuario = user;
    privilegio = p;
    
        //Controles na Janela
    	 ImageIcon energisa = new ImageIcon(getClass().getResource("img/eLogo.jpg"));
    	 lblImage2 = new JLabel(energisa);
         lblImage2.setBounds(new Rectangle(-105, -80, 415, 205));
         this.getContentPane().add(lblImage2);
         lblSenha = new JLabel("Senha:");
         lblSenha.setBounds(new Rectangle(10, 45, 57, 15));
         this.getContentPane().add(lblSenha, null);
         lblDeNovo = new JLabel("Confima��o:");
         lblDeNovo.setBounds(new Rectangle(10, 73, 75, 15));
         this.getContentPane().add(lblDeNovo, null);
         jpfSenha = new JPasswordField();
         jpfSenha.setBounds(new Rectangle(90, 42, 100, 21));
         this.getContentPane().add(jpfSenha, null);
         jpfConfirmacao = new JPasswordField();
         jpfConfirmacao.setBounds(new Rectangle(90, 70, 100, 21));
         this.getContentPane().add(jpfConfirmacao, null);
         
         //Bot�o Ok, seu Listener e seu Action:
         btnOK = new JButton("OK");
         btnOK.setBounds(new Rectangle(90, 100, 100, 25));
         this.getContentPane().add(btnOK, null);
         btnOK.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {

            	 String valorI  = new String(jpfSenha.getPassword()); 
            	 String valorII = new String(jpfConfirmacao.getPassword()); 
            	 if(checkVIP.isSelected()){
						vip = "1";
				 }else{
						vip= "0";
				 }
            	 
            	 
            	 if(valorI.equals(valorII)&& (!usuarioJaExiste())&&(valorI.length()>=6)){
            		setVisible(false);
            		
            		try {
            					FileWriter fw = new FileWriter("X:\\NotDelete.txt",true);
            					BufferedWriter bw = new BufferedWriter(fw);  
            					PrintWriter pw = new PrintWriter(bw); 
            					
            					
            					String valor = new String(jpfSenha.getPassword()); 
            					pw.println(usuario+"J"+valor.hashCode()+"J"+vip);
            					
            					fw.flush();
            					bw.flush();
            					pw.flush();
            					pw.close(); 
            					fw.close(); 
            					bw.close();
            					
            				} catch (IOException ex) {JOptionPane.showMessageDialog(null, "gfdsgf","dfsafda",1);} 
            		new UsuarioAdicionado(privilegio);
            	 	}else{
            		 	
            		 	if(usuarioJaExiste()){
            		 		try{
                				JOptionPane.showMessageDialog(null, "O usu�rio que voc� est� tentando cadastrar j� existe.","Opera��o n�o Realizada!",2);
                			}catch(NullPointerException es2){JOptionPane.showMessageDialog(null, "O usu�rio que voc� est� tentando cadastrar j� existe.","Opera��o n�o Realizada!",2);}
            		 	}else{
            			try{
            				JOptionPane.showMessageDialog(null, "Tente novamente observando se:\n*A senha possui no m�nimo 6 caracteres.\n*A confirma��o foi digitada corretamente.","Senha n�o Cadastrada.",2);
            			}catch(NullPointerException e2){JOptionPane.showMessageDialog(null, "O usu�rio que voc� est� tentando cadastrar j� existe.","Opera��o n�o Realizada!",2);}
            		 	}
            	 }
             }});
         
         
         checkVIP = new JCheckBox();
         checkVIP.setBounds(new Rectangle(6, 100, 20, 20));
         this.getContentPane().add(checkVIP, null);
         if(privilegio.equals("0")){
        	 checkVIP.setVisible(false);
         }
         lblAdmin = new JLabel("Admin");
         lblAdmin.setBounds(new Rectangle(28, 103, 57, 13));
         this.getContentPane().add(lblAdmin, null);
         
         //Ao clicar no X da Janela, A aplica��o ter� uma nova inst�ncia com o mesmo privil�gio de acesso do usu�rio logado.
         this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	new InterfaceWittel2(privilegio);
            }
         });
         this.setVisible(true);
    }
    
    
    //Vai retornar true caso o usu�rio j� tenha sido cadastrado.
    //Esse m�todo ser� usado para validar a inclus�o do novo usu�rio.
    public boolean usuarioJaExiste(){
    	boolean existe = false;
    	String linha = "";
    	String arrayDoUsuario[] = new String[2];
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("X:\\NotDelete.txt");
				bfLeitor = new BufferedReader(frLeitor);
				if(bfLeitor.readLine()== null){
		        	JOptionPane.showMessageDialog(null, "Voc� � o primeiro Usu�rio Adicionado nesta Aplica��o!","Seja Bem-Vindo!",1);
				}else{
					while((linha=bfLeitor.readLine()) != null) {
						arrayDoUsuario = linha.split("J");
						if(arrayDoUsuario[0].equals(usuario)){
							existe = true;
						}
					}
				}
				bfLeitor.close();
				frLeitor.close();
	       
    	}catch(IOException eee){return false;}
    	return existe;
    }
    
}