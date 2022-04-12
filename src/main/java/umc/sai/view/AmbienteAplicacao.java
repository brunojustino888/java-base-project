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
import umc.sai.controller.ControllerInsertAtividade;
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;

/** AmbienteAplicacao
 * Projeto: SAI - Sistema de Aprendizagem Infantil 
 * Essa classe � a primeira tela que ser� exibida para o aluno. 
 * Essa classe se trata de um frame com m�sica, decora��es e dois bot�es.
 * O seguinte frame somente dever� aparecer no caso da aplica��o n�o estabelecer conex�o com a base de dados.
 * Bot�o Escola: Esse bot�o dever� abrir uma nova janela que permitir� a altera��o das configura��es e par�metros da base de dados.  
 * Bot�o Casa: Esse bot�o ser� habilitado pela aplica��o caso o par�metro passado � esssa classe for false, dessa forma o aluno poder� executar o sistema em sua casa.
 * Ao clicar no bot�o Escola, a classe AmbienteAplicacao dever� ser� instanciar a tela de login passando o par�metro true para �cesso ao sistema no ambiente escolar.
 * Ao clicar no bot�o Casa, a classe AmbienteAplicacao dever� ser� instanciar a tela de login (passando o par�metro false) para �cesso ao sistema no ambiente caseiro.
 * @author Bruno Alves Justino
 * @version 8.0
 * @see {@link TelaLogin}, {@link TelaMenuPrincipalAluno}, {@link Musica}
 */

public class AmbienteAplicacao extends JDialog {

    //Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JButton btnCasa,btnEscola;
	private JLabel lblLapis;
	private ControllerFonte fonte;
	private boolean baux;
	private ControllerMusica maux;
	
	public AmbienteAplicacao(boolean bd, ControllerMusica musica) {
        baux= bd;
        maux= musica;
        fonte= new ControllerFonte();
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(806, 628));
        this.setLocation((screenSize.width-806)/2,(screenSize.height-616)/2);
        this.setTitle("SAI - Sistema de Aprendizagem Infantil - Ambiente da Aplica��o");
        this.setResizable(false);
        if(bd){
        	ImageIcon wittelIcon = new ImageIcon("C:\\SAI\\img\\xbtn.png");
        	this.setIconImage(wittelIcon.getImage());
        }else{
        	ImageIcon wittelIcon = new ImageIcon("C:\\SAI\\img\\xbtdn.png");
        	this.setIconImage(wittelIcon.getImage());
        }
        
      	//Tocando a m�sica fazendo uso do Objeto Musica.
        try {	
           	ControllerMusica musica11 = null;
   			musica11 = new ControllerMusica("C:\\SAI\\audio\\voice\\casaescola.mp3");
   			musica11.play();
        }catch(Exception e11) {e11.printStackTrace();}


        
        //Dados e propriedades do Bot�o Casa
        btnCasa = new JButton("CASA");
        btnCasa.setFont(fonte.getFontPlain(15));
        btnCasa.setBounds(new Rectangle(135, 422, 100, 30));
        this.getContentPane().add(btnCasa, null);
        btnCasa.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(baux){
            		Toolkit.getDefaultToolkit().beep();
            	}else{
            		setVisible(false);
            		new ControllerInsertAtividade().InsertIni();
            		Usuario user = new Usuario(1, 0, "Usu�rio de Casa",  "Usu�rio de Casa", "Usu�rio de Casa",  "Usu�rio de Casa",  "Usu�rio de Casa",  "Usu�rio de Casa",  "Usu�rio de Casa",  "Usu�rio de Casa",  "Usu�rio de Casa");
            		new TelaMenuPrincipalAluno(user,maux);
            	}
            }
        });
                
        //Dados e propriedades do bot�o Escola
        btnEscola = new JButton("ESCOLA");
        btnEscola.setFont(fonte.getFontPlain(15));
        btnEscola.setBounds(new Rectangle(507, 422, 100, 30));
        this.getContentPane().add(btnEscola, null);
        btnEscola.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(baux==false){
            		
            	//Tocando a m�sica fazendo uso do Objeto Musica.
   		         try {	
   		            	ControllerMusica musica111 = null;
   		    			musica111 = new ControllerMusica("C:\\SAI\\audio\\voice\\certezaescola.mp3");
   		    			musica111.play();
   		    	 }catch(Exception e11) {e11.printStackTrace();}
            		
            			int resp = JOptionPane.showConfirmDialog(null, "Deseja modificar as configura��es do sistema?");
            			if(resp==0){
            				
            		      

            				System.out.println("Sim");
            				setVisible(false);
            				new TelaConfig(maux);
            				
            			}else{
            				System.out.println(resp);
            			}
            		
            		
            	}else{
					setVisible(false);
            		new TelaLogin(maux);
            	}
            }
        });
        
        //Imagem do fundo da janela.
        ImageIcon ImageLapis = new ImageIcon("C:\\SAI\\img\\BackgroundPrincipal.png");
        lblLapis = new JLabel(ImageLapis);
        lblLapis.setBounds(new Rectangle(0, 0, 800, 600));
        this.getContentPane().add(lblLapis, null);

        
        //Controle do fechamento da Janela
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Toolkit.getDefaultToolkit().beep();
            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
         		if(resp==0){System.exit(0);}else{}
            }
        });
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
	
	

	
}