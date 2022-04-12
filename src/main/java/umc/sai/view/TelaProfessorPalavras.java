package umc.sai.view;
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

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.model.Usuario;

public class TelaProfessorPalavras extends JDialog {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private JButton btnSair,btnUsuariosC, btnUsuariosConsulta,btnUsuariosApaga;
	private ControllerFonte fonte;
	private Usuario userx;
	private ControllerConexaoDB c;
	
    public TelaProfessorPalavras(Usuario user) {
        fonte = new ControllerFonte();
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(806, 628));
        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
        this.setTitle("Professor");
        this.setResizable(false);
        ImageIcon wittelIcon = new ImageIcon("C:\\xbtdn.png");
        this.setIconImage(wittelIcon.getImage());  
        userx = user;
        
        
        
        btnUsuariosC = new JButton("Cadastrar");
        btnUsuariosC.setFont(fonte.getFontPlain(15));;
        btnUsuariosC.setBounds(new Rectangle(111, 328, 164,19));
        this.getContentPane().add(btnUsuariosC, null);
        btnUsuariosC.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c = new ControllerConexaoDB();
            	String nova = JOptionPane.showInputDialog(null,"Digite a nova palavra que voc� deseja cadastrar...","Cadastrar Nova Palavra",3);
                if(nova.length()>0){
                    nova = nova.toUpperCase();
                    if(c.returnPalavraExiste(nova)||nova.length()>10){
                    	JOptionPane.showMessageDialog(null, "Essa palavra j� est� cadastrada ou cont�m mais de 10 caracteres.\nTente escolher uma outra!","Palavra n�o cadastrada!",0);
                    }else{
                    	c.InsertPalavra(nova);
                    	JOptionPane.showMessageDialog(null, "A palavra foi cadastrada corretamente!","Palavra Cadastrada!",1);
                    }
                }
            }
        });
        
        btnUsuariosConsulta = new JButton("Consultar");
        btnUsuariosConsulta.setFont(fonte.getFontPlain(15));
        btnUsuariosConsulta.setBounds(new Rectangle(318, 328, 164,19));
        this.getContentPane().add(btnUsuariosConsulta, null);
        btnUsuariosConsulta.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaProfessorPalavrasConsultar(userx);
            }
        });
        
        btnUsuariosApaga = new JButton("Apagar");
        btnUsuariosApaga.setFont(fonte.getFontPlain(15));
        btnUsuariosApaga.setBounds(new Rectangle(530,328, 164,19));
        this.getContentPane().add(btnUsuariosApaga, null);
        btnUsuariosApaga.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c = new ControllerConexaoDB();
            	String nova = JOptionPane.showInputDialog(null,"Digite a nova palavra que voc� deseja apagar...\nOBS:Importante lembrar que a aplica��o precisa ter no m�nimo 2 palavras funcionar corretamente","Apagar Palavra",3);
                if(nova.length()>0){
                    nova = nova.toUpperCase();
                    if(c.returnPalavraExiste(nova)){
                    	c.deletePalavra(nova);
                    	JOptionPane.showMessageDialog(null, "A palavra foi apagada corretamente!","Palavra Apagada!",1);
                    }else{
                    	JOptionPane.showMessageDialog(null, "Essa palavra n�o existe cadastrada!","Palavra n�o cadastrada!",0);
                    }
                }
            }
        });
        
        btnSair = new JButton("Voltar");
        btnSair.setFont(fonte.getFontPlain(10));
        btnSair.setBounds(new Rectangle(104, 468, 75, 19));
        this.getContentPane().add(btnSair, null);
        btnSair.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new TelaProfessor(userx);
            }
        });

        
        // Bloco 3 - Dados da Cria��o dos Controles na Janela
        ImageIcon Image = new ImageIcon("C:\\SAI\\img\\BackgroundInicioProfessorPalavras.png");
        lblImageBackground = new JLabel(Image);
        lblImageBackground.setBounds(new Rectangle(0,0,800,600));
        this.getContentPane().add(lblImageBackground, null);
        
        
        this.setVisible(true);
        btnSair.requestFocus();
        
        /** <p>Parte no construtor para definir uma a��o padr�o para fechar o sistema </p>*/
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Toolkit.getDefaultToolkit().beep();
            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
    			if(resp==0){
    				aoFechar();
    			}
            }
        });

        
    }

    /**<p>M�todo usado para interromper a execu��o da aplica��o.</p>*/
    public void aoFechar(){
    	System.exit(0);
    }
    
}