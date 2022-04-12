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

import umc.sai.controller.ControllerFonte;
import umc.sai.model.Usuario;

public class TelaProfessorUsuariosMenuConsulta extends JDialog {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private JButton btnSair,btnUsuariosC,btnP, btnUsuariosConsulta;
	private ControllerFonte fonte;
	private Usuario userx;
	
	
    public TelaProfessorUsuariosMenuConsulta(Usuario user) {
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
        
        btnUsuariosC = new JButton("Alunos");
        btnUsuariosC.setFont(fonte.getFontPlain(11));;
        btnUsuariosC.setBounds(new Rectangle(125,314,118,54));
        this.getContentPane().add(btnUsuariosC, null);
        btnUsuariosC.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new TelaProfessorUsuariosMenuConsultaAlunos(userx);
            } 
        });
        
        btnP = new JButton("Professores");
        btnP.setFont(fonte.getFontPlain(11));;
        btnP.setBounds(new Rectangle(353,314,118,54));
        this.getContentPane().add(btnP, null);
        btnP.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new TelaProfessorUsuariosMenuConsultaProfessores(userx);
            }
        });
        
        btnUsuariosConsulta = new JButton("Todos");
        btnUsuariosConsulta.setFont(fonte.getFontPlain(11));
        btnUsuariosConsulta.setBounds(new Rectangle(580,314,118,54));
        this.getContentPane().add(btnUsuariosConsulta, null);
        btnUsuariosConsulta.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	new TelaProfessorUsuariosMenuConsultaTudo(userx);
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
        ImageIcon Image = new ImageIcon("C:\\SAI\\img\\BackgroundInicioProfessorUsuariosMenuConsulta.png");
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