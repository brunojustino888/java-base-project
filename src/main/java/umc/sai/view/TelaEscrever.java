package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerFonte;
import umc.sai.controller.ControllerInsertAtividade;
import umc.sai.controller.ControllerMusica;
import umc.sai.controller.ControllerTxt;
import umc.sai.model.Usuario;

public class TelaEscrever extends JDialog {

     /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private Usuario userx;
	private final JTextField jtfPC,jtfAluno;
	private ControllerFonte fonte;
	private ControllerMusica mmm;
	private ControllerTxt ctxt;
	private ArrayList<String> linhastxt;
	private int quantidadelinhas,escolhidaPC = 0;
	private String palavraPC="";
	
	public TelaEscrever(Usuario user) {

		 userx=user;   	 
		 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(255, 255, 255));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(806, 628));
         this.setLocation((screenSize.width-806)/2,(screenSize.height-616)/2);
         this.setTitle("SAI - Menu Principal");

         ImageIcon wittelIcon = new ImageIcon("C://sai//img//xbtn.png");
         this.setIconImage(wittelIcon.getImage());
         fonte = new ControllerFonte();
         
  		 try {	
        		new ControllerMusica("C:\\SAI\\audio\\voice\\audiopalavras.mp3").play();
  		 }catch(Exception e8) {e8.printStackTrace();}
	     
         
         if(userx.getId_tipo()==0){
             ctxt = new ControllerTxt();
    		 linhastxt = ctxt.getLineTxt();
    		 quantidadelinhas = ctxt.getQuantidadeLinhas();		 
    		 Random r = new Random();
             escolhidaPC = r.nextInt(quantidadelinhas);
    	     palavraPC = linhastxt.get(escolhidaPC);
         }else{
        	 linhastxt = new ControllerConexaoDB().returnPalavras(1);
        	 quantidadelinhas = linhastxt.size();	 
    		 Random r = new Random();
             escolhidaPC = r.nextInt(quantidadelinhas);
    	     palavraPC = linhastxt.get(escolhidaPC);
         }
	
         
         
         jtfPC = new JTextField();
         jtfPC.setFont(fonte.getFonteBold(60));
         jtfPC.setBackground(new Color(150,115,255));
         jtfPC.setBounds(new Rectangle(262, 152, 464,98));
         jtfPC.setText(palavraPC);
         jtfPC.setEditable(false);
         this.getContentPane().add(jtfPC, null);         
         

         
         jtfAluno = new JTextField();
         jtfAluno.setFont(fonte.getFonteBold(80));
         jtfAluno.setBounds(new Rectangle(264, 350, 464,98));
         jtfAluno.addKeyListener (new KeyListener() {
 			//@Override
 			public void keyPressed(KeyEvent arg0) {
 			}
 			//@Override
 			public void keyReleased(KeyEvent e) {
 				if(jtfAluno.getText().trim().length()>=jtfPC.getText().trim().length()){
 					setVisible(false);
 					
 					if(jtfAluno.getText().trim().equalsIgnoreCase(jtfPC.getText().trim())){
		 	            		 try {	
		 			          		new ControllerMusica("C:\\SAI\\audio\\voice\\Acertou.mp3").play();
		 	            		 }catch(Exception e8) {e8.printStackTrace();}
		             	     
			             		 try {	
			 			           mmm = new ControllerMusica("C:\\SAI\\audio\\music\\Acertou2.mp3");
			 			           mmm.play();
			 			    	 }catch(Exception e8) {e8.printStackTrace();}
			             		 try {
			 						Thread.sleep(3500);
			 					} catch (InterruptedException e1) {e1.printStackTrace();}
			             		new ControllerInsertAtividade().insertEsvreveu(userx, "Acertou !", jtfPC.getText().trim(), jtfAluno.getText().trim());
 					}else{
		 						 try {	
		 			          		new ControllerMusica("C:\\SAI\\audio\\voice\\Errou.mp3").play();
		 						 }catch(Exception e8) {e8.printStackTrace();}
		          	     
		 						 try {	
		     			           mmm = new ControllerMusica("C:\\SAI\\audio\\music\\Errou2.mp3");
		     			           mmm.play();
		     			    	 }catch(Exception e8) {e8.printStackTrace();}  		 
		             		 
				          		 try {
				 						Thread.sleep(3500);
				 				} catch (InterruptedException e1) {e1.printStackTrace();}
				          		new ControllerInsertAtividade().insertEsvreveu(userx, "Errou !", jtfPC.getText().trim(), jtfAluno.getText().trim()); 
 					}
 					
 					new TelaMenuPrincipalAluno(userx, mmm);
 				}
 			}
 			//@Override
 			public void keyTyped(KeyEvent e) {}
         	});
         this.getContentPane().add(jtfAluno, null);    
         
         
         ImageIcon Image = new ImageIcon("C://sai//img//BackgroundEscrever.png");
         lblImageBackground = new JLabel(Image);
         lblImageBackground.setBounds(new Rectangle(0, 0, 800, 600));
         this.getContentPane().add(lblImageBackground, null);
         
 		
         
         this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            }
	            public void windowOpened( WindowEvent e ){
	            	jtfAluno.requestFocus();
	            }
	        });
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
 
    }
    
}