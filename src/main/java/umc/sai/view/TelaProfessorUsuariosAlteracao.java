package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.model.Usuario;

public class TelaProfessorUsuariosAlteracao extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private JButton btnSair,btnUsuariosC;
	private JTextField txtNome,txtNascimento,txtRG,txtEndereco,txtTelefone,txtCPF,txtLogin,txtSenha,txtOBS;
	private ControllerFonte fonte;
	private Usuario userx;
	private JCheckBox checkA,checkP;
	private int tipoCadastro = 1;
	private Usuario usuarioCadastro;
	
	/* 				
    				String array[] = new String[12];
    			    array = selecionado.split("#");
    			    array[0]=array[0].trim();
    			    new ControllerConexaoDB().deleteUser(Integer.parseInt(array[0]));
    			    setVisible(false);
    			    new TelaProfessorUsuariosMenuConsultaAlunos(userx);
	 	 */
	
    public TelaProfessorUsuariosAlteracao(Usuario user, String selecionado) {
    	String array[] = new String[12];
	    array = selecionado.split("#");
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
        
        txtNome = new JTextField();
        txtNome.setFont(fonte.getFontPlain(11));
        txtNome.setText(array[2]);
        txtNome.setBounds(new Rectangle(266,259,209,27));
        this.getContentPane().add(txtNome, null);
       
        txtNascimento = new JTextField();
        txtNascimento.setFont(fonte.getFontPlain(11));
        txtNascimento.setText(array[3]);
        txtNascimento.setBounds(new Rectangle(629,259,120,27));
        this.getContentPane().add(txtNascimento, null);
        
        txtRG = new JTextField();
        txtRG.setFont(fonte.getFontPlain(11));
        txtRG.setText(array[5]);
        txtRG.setBounds(new Rectangle(570,299,179,27));
        this.getContentPane().add(txtRG, null);
        
        txtEndereco = new JTextField();
        txtEndereco.setFont(fonte.getFontPlain(11));
        txtEndereco.setText(array[7]);
        txtEndereco.setBounds(new Rectangle(215,337,534,27));
        this.getContentPane().add(txtEndereco, null);
        
        txtTelefone = new JTextField();
        txtTelefone.setFont(fonte.getFontPlain(11));
        txtTelefone.setText(array[6]);
        txtTelefone.setBounds(new Rectangle(215,377,260,27));
        this.getContentPane().add(txtTelefone, null);
       
        txtCPF = new JTextField();
        txtCPF.setFont(fonte.getFontPlain(11));
        txtCPF.setText(array[4]);
        txtCPF.setBounds(new Rectangle(570,377,179,27));
        this.getContentPane().add(txtCPF, null);
        
        txtLogin = new JTextField();
        txtLogin.setFont(fonte.getFontPlain(11));
        txtLogin.setText(array[8]);
        txtLogin.setBounds(new Rectangle(215,417,260,27));
        this.getContentPane().add(txtLogin, null);
        
        txtSenha = new JTextField();
        txtSenha.setFont(fonte.getFontPlain(11));
        txtSenha.setText(array[9]);
        txtSenha.setBounds(new Rectangle(570,417,179,27));
        this.getContentPane().add(txtSenha, null);
        
        txtOBS = new JTextField();
        txtOBS.setFont(fonte.getFontPlain(11));
        txtOBS.setText(array[10]);
        txtOBS.setBounds(new Rectangle(309,456,280,27));
        this.getContentPane().add(txtOBS, null);
        
        
        
        checkA = new JCheckBox();
        checkA.setBounds(new Rectangle(183,299,24,25));
        checkA.setSelected(false);
        this.getContentPane().add(checkA, null);
        checkA.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(checkA.isSelected()){
            	   checkP.setSelected(false); 
            	   tipoCadastro = 1;
            
               }
            }
        });
        
        
        
        
        
        checkP = new JCheckBox();
        checkP.setSelected(false);
        checkP.setBounds(new Rectangle(301,299, 24,25));
        this.getContentPane().add(checkP, null);
        checkP.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(checkA.isSelected()){
            	   checkP.setSelected(true);
            	   checkA.setSelected(false);
            	   tipoCadastro = 2;
            
               }
            }
        });
        
        
        
        if(array[0].equals("1")){
        	 checkA.setSelected(true);
        	 checkP.setSelected(false);
        }else{
       	 checkA.setSelected(false);
    	 checkP.setSelected(true);
        }
        

        btnUsuariosC = new JButton("Alterar");
        btnUsuariosC.setFont(fonte.getFontPlain(9));;
        btnUsuariosC.setBounds(new Rectangle(354,511,92,23));
        this.getContentPane().add(btnUsuariosC, null);
        btnUsuariosC.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()){
                	usuarioCadastro = new Usuario(8,tipoCadastro,txtNome.getText(),txtNascimento.getText(),txtCPF.getText(),txtRG.getText(),txtTelefone.getText(),txtEndereco.getText(),txtLogin.getText(),txtSenha.getText(),txtOBS.getText());
                	new ControllerConexaoDB().alterUser(usuarioCadastro);
                	setVisible(false);
                	JOptionPane.showMessageDialog(null, "O usu�rio foi cadastrado corretamente no sistema!","Opera��o Realizada com Sucesso!",1);
                	new TelaProfessorUsuarios(userx);
                }else{
                	JOptionPane.showMessageDialog(null, "N�o � poss�vel cadastrar este usu�rio, \npor favor verifique: \n* Mude o campo Login;\n* Os campos de login e senha podem conter no m�ximo 8 caracteres;\n* Se o campo login,nome e senha est�o preenchidos com mais de 5 caracteres;\n* Se o tipo de usu�rio est� selecionado;\n* Faltou algum campo?","Opera��o n�o Realizada!",0);
                }
            }
        });
        
        
        
        btnSair = new JButton("Voltar");
        btnSair.setFont(fonte.getFontPlain(10));
        btnSair.setBounds(new Rectangle(104, 498, 75, 19));
        this.getContentPane().add(btnSair, null);
        btnSair.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
              	new TelaProfessor(userx);
            }
        });


        ImageIcon Image = new ImageIcon("C:\\SAI\\img\\BackgroundInicioProfessorUsuariosMenuConsultaAltera.png");
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
    
    
    public boolean validarCampos(){
    	if(txtSenha.getText().trim().length()>3&&txtLogin.getText().trim().length()>3&&txtNome.getText().trim().length()>5&&validarflagUser()&&txtSenha.getText().length()<=8&&txtLogin.getText().trim().length()<=8&&txtCPF.getText().trim().length()<15&&txtRG.getText().trim().length()<21 &&txtTelefone.getText().trim().length()<21)  {
    		ArrayList<String> users = new ArrayList<String>();
    		users = new ControllerConexaoDB().returnLogins();
    		for(int i=0; i<users.size();i++){
    			if(users.get(i).equalsIgnoreCase(txtLogin.getText())){
    				return false;
    			}
    		}
    		return true;
        }
    	return false;
    }
    
    
    public boolean validarflagUser(){
    	if(checkA.isSelected()||checkP.isSelected()){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
}