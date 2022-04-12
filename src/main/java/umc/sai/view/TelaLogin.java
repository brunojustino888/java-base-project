package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import umc.sai.controller.ControllerFonte;
import umc.sai.controller.ControllerLogin;
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;


/** <h1>TelaLogin:</h1>
 *	 <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * 		<p>Essa � a primeira interface gr�fica que � mostrada ao usu�rio.</p> 
 *		 <p>Ap�s realizar a autentica��o, o usu�rio � direcionado para a interface correspondente.</p>
 *		 <p>Exemplo:</p>
 * 	 <ul>
 * 		<li>O Usu�rio do tipo Professor ser� direcionado para TelaProfessor.</li>
 * 		<li>O Usu�rio do tipo Aluno ser� direcionado para TelaProfessor. </li>
 * 	 </ul>
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 */
public class TelaLogin extends JDialog {

	/**<p>Objetos classe<p>*/
	private static final long serialVersionUID = 1L;
    private JTextField jtfLogin;
    private JPasswordField jpfSenha;
    private JButton btnOK,objetoDecorativoI,objetoDecorativoII;
    private JLabel lblDecorativoI;
    private ImageIcon icone,lapisLogin;
    private ControllerFonte fonte;
    private ControllerMusica musica,maux;
    private ControllerLogin login;
    private Usuario user;
    
    /**<p>Construtor do Frame</p>*/
    public TelaLogin(ControllerMusica mu) {
        maux =mu;
	    this.getContentPane().setLayout(null);
	    this.getContentPane().setBackground(new Color(255, 255, 255));
	    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(new java.awt.Dimension(806, 628));
        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
	    this.setTitle("Login");
	    this.setResizable(false);
	    icone = new ImageIcon("C:\\SAI\\img\\xbtn.png");
	    this.setIconImage(icone.getImage());
	    fonte = new ControllerFonte();
	  
	    jtfLogin = new JTextField();
	    jtfLogin.setBounds(new Rectangle(374, 264, 144, 29));
	    jtfLogin.setForeground(Color.BLACK);
	    this.getContentPane().add(jtfLogin, null);
	  
	    jpfSenha = new JPasswordField();
	    jpfSenha.setBounds(new Rectangle(374, 306, 144, 29));
	    jpfSenha.setForeground(Color.BLACK);
	    this.getContentPane().add(jpfSenha, null);
	    objetoDecorativoI = new JButton();
	    objetoDecorativoI.setBounds(new Rectangle(263,364, 276, 2));
	    this.getContentPane().add(objetoDecorativoI, null);
	    objetoDecorativoI.addMouseListener(new MouseListener() {  
	        public void mouseReleased(MouseEvent e) {} 
	        public void mousePressed(MouseEvent e) {}  
	        public void mouseExited(MouseEvent e) {  
	           mudaCores();
	        }  
	        public void mouseEntered(MouseEvent e) {}  
	        public void mouseClicked(MouseEvent e) {}});
	    objetoDecorativoII = new JButton();
	    objetoDecorativoII.setBounds(new Rectangle(263,233, 276, 2));
	    this.getContentPane().add(objetoDecorativoII, null);
	    objetoDecorativoII.addMouseListener(new MouseListener() {  
	        public void mouseReleased(MouseEvent e) {} 
	        public void mousePressed(MouseEvent e) {}  
	        public void mouseExited(MouseEvent e) {  
	           mudaCores();
	        }  
	        public void mouseEntered(MouseEvent e) {}  
	        public void mouseClicked(MouseEvent e) {}});
	    login = new ControllerLogin();
	    btnOK = new JButton("OK");
	    btnOK.setVisible(true);
	    btnOK.setFont(fonte.getFontPlain(20));
	    btnOK.setBounds(new Rectangle(364, 422, 73, 29));
	    this.getContentPane().add(btnOK, null);
	    btnOK.addActionListener (new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            mudaCores();
	            String senha = new String(jpfSenha.getPassword());

	            if(login.isUsuarioValido(jtfLogin.getText(),senha)){     
	            	user = login.getValidUser();
	            	
	            	if(user.getId_tipo()==1){
	            		
	            		 //Tocando a m�sica fazendo uso do Objeto Musica.
	       	         try {	
	       	            	musica = null;
	       	    			musica = new ControllerMusica("C:\\SAI\\audio\\audio\\SinoIII.mp3");
	       	    			musica.play();
	       	    	 }catch(Exception e1) {e1.printStackTrace();}
	       	        
	       	        setVisible(false);
	       	        interrompeMusica();
	            	new TelaMenuPrincipalAluno(user, musica);
	            	
	            	}else{
	            		interrompeMusica();
	            		 //Tocando a m�sica fazendo uso do Objeto Musica.
		       	         try {	
		       	            	musica = null;
		       	    			musica = new ControllerMusica("C:\\SAI\\audio\\audio\\SinoIII.mp3");
		       	    			musica.play();
		       	    	 }catch(Exception e1) {e1.printStackTrace();}
		       	        
	            		
	            		setVisible(false);
	            		new TelaProfessor(user);
	            	}
	            	
	            }else if(senha.length()>0||jtfLogin.getText().length()>0){
	        		Toolkit.getDefaultToolkit().beep();
	            	JOptionPane.showMessageDialog(null, "Usu�rio ou Senha Inv�lidos !", "Acesso Negado!",0);
	            }else{
	        		Toolkit.getDefaultToolkit().beep();
	            }
	            
	            
	        }
	    });
	    btnOK.addMouseListener(new MouseListener() {  
	        public void mouseReleased(MouseEvent e) {} 
	        public void mousePressed(MouseEvent e) {}  
	        public void mouseExited(MouseEvent e) {  
	           mudaCores();
	        }  
	        public void mouseEntered(MouseEvent e) {}  
	        public void mouseClicked(MouseEvent e) {}});
	    lapisLogin = new ImageIcon("C:\\SAI\\img\\BackgroundTelaLogin.png");
	    lblDecorativoI = new JLabel(lapisLogin);
	    lblDecorativoI.setBounds(new Rectangle(0,0, 800, 600));
	    this.getContentPane().add(lblDecorativoI, null);
	   
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
	    			if(resp==0){
	    				aoFechar();
	    			}
	            }
	        });
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);
	        jtfLogin.requestFocus();
	       
    }

    /**<p>M�todo Respons�vel por modificar as cores dos campos na Tela de Login</p>*/
    private void mudaCores(){
    	if(jtfLogin.getBackground()==Color.WHITE){
    		jpfSenha.setBackground(Color.PINK);
    		jtfLogin.setBackground(Color.PINK);
    	}else if(jtfLogin.getBackground()==Color.MAGENTA){
    		jpfSenha.setBackground(Color.CYAN);
    		jtfLogin.setBackground(Color.CYAN);
    	}else if(jtfLogin.getBackground()==Color.PINK){
    		jpfSenha.setBackground(Color.ORANGE);
    		jtfLogin.setBackground(Color.ORANGE);
    	}else if(jtfLogin.getBackground()==Color.ORANGE){
    		jpfSenha.setBackground(Color.MAGENTA);
    		jtfLogin.setBackground(Color.MAGENTA);
    	}else if(jtfLogin.getBackground()==Color.CYAN){
    		jpfSenha.setBackground(Color.YELLOW);
    		jtfLogin.setBackground(Color.YELLOW);
    	}else if(jtfLogin.getBackground()==Color.YELLOW){
    		jpfSenha.setBackground(Color.RED);
    		jtfLogin.setBackground(Color.RED);
    	}else if(jtfLogin.getBackground()==Color.RED){
    		jpfSenha.setBackground(Color.GREEN);
    		jtfLogin.setBackground(Color.GREEN);
    	}else if(jtfLogin.getBackground()==Color.GREEN){
    		jtfLogin.setBackground(Color.WHITE);
    		jpfSenha.setBackground(Color.WHITE);
    	}else{
    		jpfSenha.setBackground(Color.WHITE);
    		jtfLogin.setBackground(Color.WHITE);
    	}
    }
    
    /**<p>M�todo usado para interromper a execu��o da aplica��o.</p>*/
    public void aoFechar(){
    	System.exit(0);
    }

    public void interrompeMusica() {
    	maux.stop();
    	maux.close();
    }
    
}