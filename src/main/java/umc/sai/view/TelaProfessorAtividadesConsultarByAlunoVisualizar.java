package umc.sai.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.model.Usuario;

public class TelaProfessorAtividadesConsultarByAlunoVisualizar extends JDialog {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private JButton btnSair, btnVisualizar;
	private JComboBox<String> jcb;
	private ControllerFonte fonte;
	private Usuario userx;
	private ControllerConexaoDB c;
	
	
    public TelaProfessorAtividadesConsultarByAlunoVisualizar(Usuario user, String jcbselecionado) {
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
        
        String array[] = new String[12];
        array = jcbselecionado.split("#");
        array[0]=array[0].trim();
        ArrayList<String> ativ = new ArrayList<String>();
        ativ= c.returnAtividadeByIdUser(Integer.parseInt(array[0]));
        
        jcb = new JComboBox<String>();
        jcb.setFont(new Font("Arial",Font.BOLD,15));
        jcb.setBounds(new Rectangle(120, 276, 565,31));
        for(int i=0;i<ativ.size();i++){
			jcb.addItem(ativ.get(i));
		}
        this.getContentPane().add(jcb, null);
        
        btnVisualizar = new JButton("Visualizar Atividade");
        btnVisualizar.setFont(fonte.getFontPlain(10));
        btnVisualizar.setBounds(new Rectangle(303,364, 200, 19));
        this.getContentPane().add( btnVisualizar , null);
        btnVisualizar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(jcb.getSelectedItem()==null){
            		btnVisualizar.setVisible(false);
            		jcb.addItem("Usu�rio N�o Possui Atividades Cadastradas...");
            	}else{
            		setVisible(false);
                	String selecionado = (String) jcb.getSelectedItem();
                	new TelaProfessorAtividadesConsultarByAlunoVisualizarII(userx,selecionado);
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

        
        ImageIcon Image = new ImageIcon("C:\\SAI\\img\\BackgroundInicioProfessorAtividadeConsultaAlunoAtividades.png");
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