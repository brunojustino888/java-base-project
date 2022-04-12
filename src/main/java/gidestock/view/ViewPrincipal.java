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

public class ViewPrincipal extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon icone, background;
	private JLabel lblImageBackground;
	private JButton btncadastraproduto, btnconsultaproduto, btnconsultauser, btncadastrauser, btnestoque1, btnestoque2, btnfornecedorcadastra, btnfornecedorconsulta;
	
	public ViewPrincipal(){
		    this.getContentPane().setLayout(null);
		    this.getContentPane().setBackground(new Color(255, 255, 255));
		    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		    this.setSize(new java.awt.Dimension(806, 628));
	        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
		    this.setTitle("Menu Principal - GideStock");
		    this.setResizable(false);
		    icone = new ImageIcon("C:\\GideStock\\img\\xbtn.png");
		    this.setIconImage(icone.getImage());
		    
		    btnconsultaproduto = new JButton("Consulta");
		    btnconsultaproduto.setVisible(true);
		    btnconsultaproduto.setBounds(new Rectangle(110,182, 107,30));
		    this.getContentPane().add(btnconsultaproduto, null);
		    btnconsultaproduto.addActionListener (new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	setVisible(false);
		        	new ViewConsultaProduto();
		        }});
		    
		    btncadastraproduto = new JButton("Cadastro");
		    btncadastraproduto.setVisible(true);
		    btncadastraproduto.setBounds(new Rectangle(110,221, 107,30));
		    this.getContentPane().add(btncadastraproduto, null);
		    btncadastraproduto.addActionListener (new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	setVisible(false);
		        	new CadastraProduto();
		        }});
		    
		    btnconsultauser = new JButton("Consulta");
		    btnconsultauser.setVisible(true);
		    btnconsultauser.setBounds(new Rectangle(586,182, 107,30));
		    this.getContentPane().add(btnconsultauser, null);
		    
		    btncadastrauser = new JButton("Cadastro");
		    btncadastrauser.setVisible(true);
		    btncadastrauser.setBounds(new Rectangle(586,221, 107,30));
		    this.getContentPane().add(btncadastrauser, null);
		    
		    btnestoque1 = new JButton("Relat�rios");
		    btnestoque1.setVisible(true);
		    btnestoque1.setBounds(new Rectangle(110,342, 107,30));
		    this.getContentPane().add(btnestoque1, null);
		    
		    btnestoque2 = new JButton("Configurar");
		    btnestoque2.setVisible(true);
		    btnestoque2.setBounds(new Rectangle(110,381, 107,30));
		    this.getContentPane().add(btnestoque2, null);
		       
		    btnfornecedorcadastra = new JButton("Cadastro");
		    btnfornecedorcadastra.setVisible(true);
		    btnfornecedorcadastra.setBounds(new Rectangle(586,381, 107,30));
		    this.getContentPane().add(btnfornecedorcadastra, null);
		    
		    btnfornecedorconsulta = new JButton("Consulta");
		    btnfornecedorconsulta.setVisible(true);
		    btnfornecedorconsulta.setBounds(new Rectangle(586,342, 107,30));
		    this.getContentPane().add(btnfornecedorconsulta, null);
		    
		    
		    background = new ImageIcon("C:\\GideStock\\img\\BackgroundMenuPrincipal.png");
	        lblImageBackground = new JLabel(background);
	        lblImageBackground.setBounds(new Rectangle(0,0,800,600));
	        this.getContentPane().add(lblImageBackground, null);
		    
		    
		    this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
	    			if(resp==0){
	    				System.exit(0);
	    			}
	            }
	        });
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);
	}
	
}
