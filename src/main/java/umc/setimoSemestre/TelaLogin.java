package umc.setimoSemestre;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TelaLogin extends JDialog {


	private static final long serialVersionUID = 1L;
    private JTextField jtfLogin;
    private JPasswordField jpfSenha;
    private JButton btnOK;
    private JLabel label1, label2, label3;

    public TelaLogin() {
	    this.getContentPane().setLayout(null);
	    this.getContentPane().setBackground(new Color(0,0,0));
	    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(new java.awt.Dimension(306, 228));
        this.setLocation((screenSize.width-306)/2,(screenSize.height-228)/2);
	    this.setTitle("Login");
	    this.setResizable(false);
	    
	    label1 = new JLabel("FA�A O LOGIN");
	    label1.setBounds(new Rectangle(88, 20, 144, 29));
	    label1.setForeground(Color.WHITE);
	    label1.setFont(new Font("Rockwell", Font.PLAIN, 18));
	    this.getContentPane().add(label1, null);
	    
	    label2 = new JLabel("Usu�rio:");
	    label2.setBounds(new Rectangle(20, 65, 144, 29));
	    label2.setForeground(Color.WHITE);
	    this.getContentPane().add(label2, null);
	    
	    label3 = new JLabel("Senha:");
	    label3.setBounds(new Rectangle(20, 105, 144, 29));
	    label3.setForeground(Color.WHITE);
	    this.getContentPane().add(label3, null);
	  
	    jtfLogin = new JTextField();
	    jtfLogin.setBounds(new Rectangle(80, 64, 144, 29));
	    jtfLogin.setForeground(Color.BLACK);
	    this.getContentPane().add(jtfLogin, null);
	  
	    jpfSenha = new JPasswordField();
	    jpfSenha.setBounds(new Rectangle(80, 106, 144, 29));
	    jpfSenha.setForeground(Color.BLACK);
	    this.getContentPane().add(jpfSenha, null);
	 
	    btnOK = new JButton("OK");
	    btnOK.setVisible(true);
	    btnOK.setBounds(new Rectangle(115, 150, 73, 29));
	    this.getContentPane().add(btnOK, null);
	    
	    
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar?");
	    			if(resp==0){
	    				aoFechar();
	    			}
	            }
	        });
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);
	        btnOK.requestFocus();
    }

    public void aoFechar(){
    	System.exit(0);
    }

    
}