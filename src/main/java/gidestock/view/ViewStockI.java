package gidestock.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import gidestock.controller.ControllerLogin;
import gidestock.model.Usuario;


public class ViewStockI extends JDialog{
	
	/**<p>Objetos classe<p>*/
	private static final long serialVersionUID = 1L;
    private JTextField jtfLogin;
    private JPasswordField jpfSenha;
    private JButton btnOK;
    private JLabel lblDecorativoI;
    private ImageIcon icone,lapisLogin;
    private ControllerLogin login;
    private Usuario user;
    
    /**<p>Construtor do Frame</p>*/
    public ViewStockI() {
        
	    this.getContentPane().setLayout(null);
	    this.getContentPane().setBackground(new Color(255, 255, 255));
	    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(new java.awt.Dimension(306, 328));
        this.setLocation((screenSize.width-306)/2,(screenSize.height-328)/2);
	    this.setTitle("Login - GideStock");
	    this.setResizable(false);
	    icone = new ImageIcon("C:\\GideStock\\img\\xbtn.png");
	    this.setIconImage(icone.getImage());

	    jtfLogin = new JTextField();
	    jtfLogin.setBounds(new Rectangle(127, 129, 139, 34));
	    jtfLogin.setForeground(Color.BLACK);
	    this.getContentPane().add(jtfLogin, null);
	  
	    jpfSenha = new JPasswordField();
	    jpfSenha.setBounds(new Rectangle(127, 185, 139, 34));
	    jpfSenha.setForeground(Color.BLACK);
	    this.getContentPane().add(jpfSenha, null);
	   
	    login = new ControllerLogin();
	    btnOK = new JButton("OK");
	    btnOK.setVisible(true);
	    btnOK.setBounds(new Rectangle(93, 243, 115, 34));
	    this.getContentPane().add(btnOK, null);
	    btnOK.addActionListener (new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	           
	            String senha = new String(jpfSenha.getPassword());

	            if(login.isUsuarioValido(jtfLogin.getText(),senha)){     
	            	user = login.getValidUser();
	            	
	            	if(user.getId_tipo()==1){
	            		
	            		setVisible(false);
	            		new ViewPrincipal();
	            	}
	            	
	            }else if(senha.length()>0||jtfLogin.getText().length()>0){
	        		Toolkit.getDefaultToolkit().beep();
	            	JOptionPane.showMessageDialog(null, "Usu�rio ou Senha Inv�lidos !", "Acesso Negado!",0);
	            }else{
	        		Toolkit.getDefaultToolkit().beep();
	            }
	                
	        }
	    });

	    lapisLogin = new ImageIcon("C:\\GideStock\\img\\BackgroundTelaLogin.png");
	    lblDecorativoI = new JLabel(lapisLogin);
	    lblDecorativoI.setBounds(new Rectangle(0,0,300,300));
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
    
    /**<p>M�todo usado para interromper a execu��o da aplica��o.</p>*/
    public void aoFechar(){
    	System.exit(0);
    }

}
