package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import umc.sai.controller.ControllerFonte;
import umc.sai.controller.ControllerInsertAtividade;
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;

public class TelaAvaliacaoVogais extends JDialog {

     /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground, label1, label2, label3;	
	private JButton btn1, btn2,btn3;
	private ControllerFonte fonte;
	private int sbtn1,sbtn2,sbtn3,perguntada;
	private String letra1, letra2, letra3,sperguntada;
	private Usuario userx;
	private  ControllerMusica mmm;
	
	public TelaAvaliacaoVogais(Usuario user) {
		 userx=user;   	 
		 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(255, 255, 255));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(806, 628));
         this.setLocation((screenSize.width-806)/2,(screenSize.height-616)/2);
         this.setTitle("SAI - Menu Principal");
         this.setResizable(false);
         ImageIcon wittelIcon = new ImageIcon("C://sai//img//xbtn.png");
         this.setIconImage(wittelIcon.getImage());
         fonte = new ControllerFonte();
         Random r = new Random();
         sbtn1 = r.nextInt(5);
         
         do{
        	 sbtn2 = r.nextInt(5);
        	 sbtn3 = r.nextInt(5);
         }while(sbtn1==sbtn2||sbtn1==sbtn3||sbtn2==sbtn3);
        	 
         ImageIcon img[] = new ImageIcon[5];
         img[0] = new ImageIcon("C://sai//img//Package//Letras//a.png");
         img[1] = new ImageIcon("C://sai//img//Package//Letras//e.png");
         img[2] = new ImageIcon("C://sai//img//Package//Letras//i.png");
         img[3] = new ImageIcon("C://sai//img//Package//Letras//o.png");
         img[4] = new ImageIcon("C://sai//img//Package//Letras//u.png");
         
         String paths[] = new String[5]; 
         paths[0] = "C://SAI//audio//voice//a.mp3";
         paths[1] = "C://SAI//audio//voice//e.mp3";
         paths[2] = "C://SAI//audio//voice//i.mp3";
         paths[3] = "C://SAI//audio//voice//o.mp3";
         paths[4] = "C://SAI//audio//voice//u.mp3";
         
         String perguntas[] = new String[5]; 
         perguntas[0] = "C://SAI//audio//voice//qa.mp3";
         perguntas[1] = "C://SAI//audio//voice//qe.mp3";
         perguntas[2] = "C://SAI//audio//voice//qi.mp3";
         perguntas[3] = "C://SAI//audio//voice//qo.mp3";
         perguntas[4] = "C://SAI//audio//voice//qu.mp3";
         
         switch(sbtn1) {
         case 0: letra1 = "a"; break;
         case 1: letra1 = "e"; break;
         case 2: letra1 = "i"; break;
         case 3: letra1 = "o"; break;
         case 4: letra1 = "u"; break;
         }
         
         switch(sbtn2) {
         case 0: letra2 = "a"; break;
         case 1: letra2 = "e"; break;
         case 2: letra2 = "i"; break;
         case 3: letra2 = "o"; break;
         case 4: letra2 = "u"; break;
         }
        
         switch(sbtn3) {
         case 0: letra3 = "a"; break;
         case 1: letra3 = "e"; break;
         case 2: letra3 = "i"; break;
         case 3: letra3 = "o"; break;
         case 4: letra3 = "u"; break;
         }
         
         label1 = new JLabel(img[sbtn1]);
         label1.setBounds(new Rectangle(110, 235, 123, 130));
         this.getContentPane().add(label1, null);

         label2 = new JLabel(img[sbtn2]);
         label2.setBounds(new Rectangle(339, 235, 123, 130));
         this.getContentPane().add(label2, null);
         
         label3 = new JLabel(img[sbtn3]);
         label3.setBounds(new Rectangle(568, 235, 123, 130));
         this.getContentPane().add(label3, null);
         
         do{
         perguntada =  r.nextInt(5);
         }while(perguntada!=sbtn1&&perguntada!=sbtn2&&perguntada!=sbtn3);
         
         try {
  			new ControllerMusica(perguntas[perguntada]).play();
  		 }catch (Exception e) {e.printStackTrace();}
         
         switch(perguntada) {
         case 0: sperguntada = "a"; break;
         case 1: sperguntada = "e"; break;
         case 2: sperguntada = "i"; break;
         case 3: sperguntada = "o"; break;
         case 4: sperguntada = "u"; break;
         }
         
         btn1 = new JButton(letra1);
         btn1.setFont(fonte.getFonteBold(18));
         btn1.setBounds(new Rectangle(112, 411, 119, 30));
         this.getContentPane().add(btn1, null);
         btn1.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	
            	 
            	 
            	 if(perguntada==sbtn1){
            		 setVisible(false);
            		 System.out.println("Acertou");
            		 
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
            		 
            		 
            		 ControllerInsertAtividade c = new ControllerInsertAtividade();
            		 c.InsertVogais(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra1);
            		 
            	    	
            	    	
            	    	
            		 new TelaMenuPrincipalAluno(userx, mmm);
            	     
            	     
            	 }else{
            		 setVisible(false);
            		 System.out.println("Errou");
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
         		 
     
	         		 ControllerInsertAtividade c = new ControllerInsertAtividade();
	         		 c.InsertVogais(userx,"Errou",letra1+letra2+letra3,sperguntada,letra1);
	         		 new TelaMenuPrincipalAluno(userx, mmm);
            	 }
        	
             }
         });
        
         btn2 = new JButton(letra2);
         btn2.setFont(fonte.getFonteBold(18));
         btn2.setBounds(new Rectangle(341, 411, 119, 30));
         this.getContentPane().add(btn2, null);
         btn2.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
   
            	 
            	 
            	 
               	 if(perguntada==sbtn2){
               		 setVisible(false);
               		 System.out.println("Acertou");
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
	         		 
	         		 
	         		 ControllerInsertAtividade c = new ControllerInsertAtividade();
	         		 c.InsertVogais(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra2);
            		 new TelaMenuPrincipalAluno(userx, mmm);
            	
               	 
               	 }else{
            		 setVisible(false);
            		 System.out.println("Errou");
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
         		 
         		 
         		 ControllerInsertAtividade c = new ControllerInsertAtividade();
         		 c.InsertVogais(userx,"Errou",letra1+letra2+letra3,sperguntada,letra2);
        		 new TelaMenuPrincipalAluno(userx, mmm);
            	 }
        	
             }
         });
       
         btn3 = new JButton(letra3);
         btn3.setFont(fonte.getFonteBold(18));
         btn3.setBounds(new Rectangle(570, 411, 119, 30));
         this.getContentPane().add(btn3, null);
         btn3.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
   
               	 if(perguntada==sbtn3){
               		 setVisible(false);
               		 System.out.println("Acertou");
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
         		 
         		 
         		 ControllerInsertAtividade c = new ControllerInsertAtividade();
         		 c.InsertVogais(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra3);
        		 new TelaMenuPrincipalAluno(userx, mmm);
         		 
         		 
            	 }else{
            		 setVisible(false);
            		 System.out.println("Errou");
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
         		 
         		 
         		 ControllerInsertAtividade c = new ControllerInsertAtividade();
         		 c.InsertVogais(userx,"Errou",letra1+letra2+letra3,sperguntada,letra3);
        		 new TelaMenuPrincipalAluno(userx, mmm);
            	 }
             }
         });

         ImageIcon Image = new ImageIcon("C://sai//img//Background1Avaliacao.png");
         lblImageBackground = new JLabel(Image);
         lblImageBackground.setBounds(new Rectangle(0, 0, 800, 600));
         this.getContentPane().add(lblImageBackground, null);

         this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            }
	        });
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
    }
}