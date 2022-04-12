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
import javax.swing.JTextField;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.controller.ControllerMusica;
import umc.sai.controller.ControllerXML;

/** <b>TelaLogin:<\b><\ ln>
 * Essa � a primeira interface gr�fica que � mostrada ao usu�rio. 
 * Ap�s realizar a autentica��o, o usu�rio � direcionado para a interface correspondente.
 * Exemplo:
 * O Usu�rio do tipo Professor ser� direcionado para TelaProfessor.
 * O Usu�rio do tipo Aluno ser� direcionado para TelaProfessor. 
 * @author Bruno Alves Justino
 * @date � Dez - 2013
 */
public class TelaConfig extends JDialog {

	private static final long serialVersionUID = 1L;
    private JButton btnConfigurar, btnTestar, btnVoltar;
    private JTextField jtfURL,jtfPass, jtfUser;
    private JLabel lblImageBackground;
    private ControllerFonte fonte = new ControllerFonte();
    private ImageIcon icone;
    private ControllerConexaoDB db;
    private ControllerXML xml;
    private ControllerMusica maux;
    
    public TelaConfig(ControllerMusica musica) {
    maux = musica;	
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(0, 0, 0));
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(new java.awt.Dimension(657, 388));
    this.setLocation((screenSize.width-657)/2,(screenSize.height-388)/2);
    this.setTitle("Configura��o do Servidor de Banco de Dados");
    this.setResizable(false);
    icone = new ImageIcon("C:\\SAI\\img\\xbtn.png");
    this.setIconImage(icone.getImage());
    	
    xml = new ControllerXML();
 	db = new ControllerConexaoDB();
    
    jtfURL = new JTextField();
    jtfURL.setText(xml.getUrl());
    jtfURL.setBounds(new Rectangle(206, 109, 347,30));
    this.getContentPane().add(jtfURL, null);
    jtfPass= new JTextField();
    jtfPass.setText(xml.getPassword());
    jtfPass.setBounds(new Rectangle(206, 220, 347,30));
    this.getContentPane().add(jtfPass, null);
    jtfUser = new JTextField();
    jtfUser.setText(xml.getUserdb());
    jtfUser.setBounds(new Rectangle(206, 166, 347,30));
    this.getContentPane().add(jtfUser, null);

    btnVoltar = new JButton("Voltar");
    btnVoltar.setFont(fonte.getFonteBold(12));
    btnVoltar.setBounds(new Rectangle(473,301, 111, 30));
    btnVoltar.setFont(fonte.getFontPlain(15));
    this.getContentPane().add(btnVoltar, null);
    btnVoltar.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
       
       
        	if(db.testarConexao()){
        		setVisible(false);
        		new TelaLogin(maux);
        	}else{
        		setVisible(false);
        		new AmbienteAplicacao(false,maux);
        	}
        		
        }
    });
    
    btnTestar = new JButton("Testar");
    btnTestar.setFont(fonte.getFonteBold(12));
    btnTestar.setBounds(new Rectangle(67, 301, 111, 30));
    btnTestar.setFont(fonte.getFontPlain(15));
    this.getContentPane().add(btnTestar, null);
    btnTestar.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        	if(db.testarConexao(jtfURL.getText(), jtfUser.getText(), jtfPass.getText())){
        		Toolkit.getDefaultToolkit().beep();
        	   JOptionPane.showMessageDialog(null, "Conex�o estabelecida com sucesso!\nClique em \"Salvar\" para manter estas configura��es.","Teste Realizado com Sucesso!",1);
        	}else{
        		Toolkit.getDefaultToolkit().beep();
        	   JOptionPane.showMessageDialog(null, "Verifique as informa��es dos campos.\nN�o foi poss�vel estabelecer uma conex�o com o banco de dados","Erro encontrado durante Teste!",0);
        	}

        }
    });
    
    btnConfigurar = new JButton("Salvar");
    btnConfigurar.setFont(fonte.getFonteBold(12));
    btnConfigurar.setBounds(new Rectangle(268,301, 111, 30));
    btnConfigurar.setFont(fonte.getFontPlain(15));
    this.getContentPane().add(btnConfigurar, null);
    btnConfigurar.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Toolkit.getDefaultToolkit().beep();    		
			int resp = JOptionPane.showConfirmDialog(null, "Deseja modificar e salvar as configura��es do sistema?\nVoc� ser� redirecionado para a tela de Login.");
			if(resp==0){
				
				if(jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")||jtfURL.getText().contains("�")|| jtfUser.getText().contains("�")|| jtfPass.getText().contains("�")){
					
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "N�o � permitido ter acento nos campos de configura��o do sistema.","Erro!",0);
					
				}else{
				
					xml = new ControllerXML(jtfURL.getText(), jtfUser.getText(), jtfPass.getText());
					setVisible(false);
					new TelaLogin(maux);

				}
					
			}
	}
	});
    
    ImageIcon Image = new ImageIcon("C:\\SAI\\img\\TelaConfig.jpg");
    lblImageBackground = new JLabel(Image);
    lblImageBackground.setBounds(new Rectangle(0, 0, 650, 360));
    this.getContentPane().add(lblImageBackground, null);
    
    //Controle do fechamento da Janela
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
        	Toolkit.getDefaultToolkit().beep();
        	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
     	
			if(resp==0){
				aoFechar();
			}else{
				System.err.println(resp);
			}
        	
        }
    });
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setVisible(true);
    }
    
	public void aoFechar(){
		System.exit(0);
	}

}