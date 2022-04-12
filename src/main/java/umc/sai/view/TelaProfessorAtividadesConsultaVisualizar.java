package umc.sai.view;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextArea;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.model.Usuario;

public class TelaProfessorAtividadesConsultaVisualizar extends JDialog {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private JButton btnSair;
	private JTextArea btnUsuariosConsulta;
	private ControllerFonte fonte;
	private Usuario userx;
	private ControllerConexaoDB c;
	
	
    public TelaProfessorAtividadesConsultaVisualizar(Usuario user, String jcbselecionado) {
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
        c = new ControllerConexaoDB();
        
        String array[] = new String[2];
        array = jcbselecionado.split("#");
        array[0] = array[1].trim();
        String ativ = "";
        ativ= c.returnAtividadeById(Integer.parseInt(array[0]));
        
        btnUsuariosConsulta = new JTextArea();
        btnUsuariosConsulta.setText(ativ);
        btnUsuariosConsulta.setEditable(false);
        btnUsuariosConsulta.setLineWrap(true); //Quebra de linha automatica  
        btnUsuariosConsulta.setFont(new Font("Arial",Font.BOLD,15));
        btnUsuariosConsulta.setBounds(new Rectangle(201,247, 420,200));       
        this.getContentPane().add(btnUsuariosConsulta, null);
        
      
        
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

        
        ImageIcon Image = new ImageIcon("C:\\SAI\\img\\BackgroundInicioProfessorAtividadeConsultaVisualizar.png");
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