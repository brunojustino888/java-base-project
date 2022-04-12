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
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;

public class TelaMenuPrincipalAluno extends JDialog {

	/** <h1>TelaMenuPrincipalAluno</h1>
	 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
	 * <p>Essa classe � primeira � ser chamada pela aplica��o quando um usu�rio do tipo aluno faz login no sistema.</p> 
	 * <p>Ao iniciar, verifica-se a possibilidade de conex�o com uma base de dados.</p> 
	 * <p>Caso aplica��o consiga estabelecer uma conex�o com uma base de dados, dever� ser instanciada a classe TelaLogin com o par�metro true.</p> 
	 * <p>Caso contr�rio, a classe TelaLogin ser� instanciada com o par�mentro false.</p>  
	 * @author Bruno Alves Justino
	 * @date � Ago - 2014
	 * @version 8.0
	 * @see TelaLogin
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel lblImageBackground;
	private JButton btnPalavras, btnAlfabeto, btnVogais;
	private ImageIcon icone,imagebackground;
	private ControllerMusica musica;
	private ControllerFonte fonte;
	private Usuario userx;
	
	public TelaMenuPrincipalAluno(Usuario user, ControllerMusica mu) {
		
		userx= user;
		
		 try{
		 musica = mu;
		 musica.stop();
		 musica.close();
		 }catch(NullPointerException e11) {e11.printStackTrace();}
    	
		 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(255, 255, 255));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(806, 628));
         this.setLocation((screenSize.width-806)/2,(screenSize.height-616)/2);
         this.setTitle("SAI - Menu Principal");
         this.setResizable(false);
         this.setModal(true);
         icone = new ImageIcon("C:\\SAI\\img\\img.png");
         this.setIconImage(icone.getImage());
         fonte = new ControllerFonte();
         ImageIcon wittelIcon = new ImageIcon("C://sai//img//xbtn.png");
         this.setIconImage(wittelIcon.getImage());
         
     	//Tocando a m�sica fazendo uso do Objeto Musica.
         try {	
            	musica = null;
    			musica = new ControllerMusica("C:\\SAI\\audio\\audio\\ffxii01.mp3");
    			musica.play();
    	 }catch(Exception e1) {e1.printStackTrace();}

      	//Tocando a m�sica fazendo uso do Objeto Musica.
         try {	
            	ControllerMusica musica11 = null;
    			musica11 = new ControllerMusica("C:\\SAI\\audio\\voice\\oque.mp3");
    			musica11.play();
    	 }catch(Exception e11) {e11.printStackTrace();}

         
         
         btnVogais = new JButton("Vogais");
         btnVogais.setFont(fonte.getFontPlain(14));
         btnVogais.setBounds(new Rectangle(30, 352, 150, 30));
         this.getContentPane().add(btnVogais, null);
         btnVogais.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 setVisible(false);
            	 new TelaMenuAlunoVogais(musica,userx);
             }
         });
         
         btnAlfabeto = new JButton("Alfabeto");
         btnAlfabeto.setFont(fonte.getFontPlain(14));
         btnAlfabeto.setBounds(new Rectangle(327, 352, 150, 30));
         this.getContentPane().add( btnAlfabeto, null);
         btnAlfabeto.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 setVisible(false);
            	 new TelaMenuAlunoAlfabeto(musica,userx);
             }
         });
         
         btnPalavras = new JButton("Palavras");
         btnPalavras .setFont(fonte.getFontPlain(14));
         btnPalavras .setBounds(new Rectangle(612,352, 150, 30));
         this.getContentPane().add(btnPalavras , null);
         btnPalavras .addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 setVisible(false);
            	 new TelaMenuAlunoEscrever(musica,userx);
             }
         });
         

         imagebackground = new ImageIcon("C:\\SAI\\img\\BackgroundMenuPrincipalAluno.png");
         lblImageBackground = new JLabel(imagebackground);
         lblImageBackground.setBounds(new Rectangle(0, 0, 800, 600));
         this.getContentPane().add(lblImageBackground, null);
         
     
         this.addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
             	Toolkit.getDefaultToolkit().beep();
             	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
          		if(resp==0){System.exit(0);}else{}}
         });
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
        
        
    }

	
	
	
	
}