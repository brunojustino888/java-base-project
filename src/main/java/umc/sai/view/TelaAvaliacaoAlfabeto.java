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

public class TelaAvaliacaoAlfabeto extends JDialog {

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
	
	public TelaAvaliacaoAlfabeto(Usuario user) {
		 
		
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
         sbtn1 = r.nextInt(26);
         
         do{
        	 sbtn2 = r.nextInt(26);
        	 sbtn3 = r.nextInt(26);
         }while(sbtn1==sbtn2||sbtn1==sbtn3||sbtn2==sbtn3);
        	 
    	 ImageIcon img[] = new ImageIcon[26];
         img[0] = new ImageIcon("C://sai//img//Package//Letras//a.png");
         img[1] = new ImageIcon("C://sai//img//Package//Letras//b.png");
         img[2] = new ImageIcon("C://sai//img//Package//Letras//c.png");
         img[3] = new ImageIcon("C://sai//img//Package//Letras//d.png");
         img[4] = new ImageIcon("C://sai//img//Package//Letras//e.png");
         img[5] = new ImageIcon("C://sai//img//Package//Letras//f.png");
         img[6] = new ImageIcon("C://sai//img//Package//Letras//g.png");
         img[7] = new ImageIcon("C://sai//img//Package//Letras//h.png");
         img[8] = new ImageIcon("C://sai//img//Package//Letras//i.png");
         img[9] = new ImageIcon("C://sai//img//Package//Letras//j.png");
         img[10] = new ImageIcon("C://sai//img//Package//Letras//k.png");
         img[11] = new ImageIcon("C://sai//img//Package//Letras//l.png");
         img[12] = new ImageIcon("C://sai//img//Package//Letras//m.png");
         img[13] = new ImageIcon("C://sai//img//Package//Letras//n.png");
         img[14] = new ImageIcon("C://sai//img//Package//Letras//o.png");
         img[15] = new ImageIcon("C://sai//img//Package//Letras//p.png");
         img[16] = new ImageIcon("C://sai//img//Package//Letras//q.png");
         img[17] = new ImageIcon("C://sai//img//Package//Letras//r.png");
         img[18] = new ImageIcon("C://sai//img//Package//Letras//s.png");
         img[19] = new ImageIcon("C://sai//img//Package//Letras//t.png");
         img[20] = new ImageIcon("C://sai//img//Package//Letras//u.png");
         img[21] = new ImageIcon("C://sai//img//Package//Letras//v.png");
         img[22] = new ImageIcon("C://sai//img//Package//Letras//w.png");
         img[23] = new ImageIcon("C://sai//img//Package//Letras//x.png");
         img[24] = new ImageIcon("C://sai//img//Package//Letras//y.png");
         img[25] = new ImageIcon("C://sai//img//Package//Letras//z.png");
         
         String paths[] = new String[26]; 
         paths[0] = "C://SAI//audio//voice//a.mp3";
         paths[1] = "C://SAI//audio//voice//b.mp3";
         paths[2] = "C://SAI//audio//voice//c.mp3";
         paths[3] = "C://SAI//audio//voice//d.mp3";
         paths[4] = "C://SAI//audio//voice//e.mp3";
         paths[5] = "C://SAI//audio//voice//f.mp3";
         paths[6] = "C://SAI//audio//voice//g.mp3";
         paths[7] = "C://SAI//audio//voice//h.mp3";
         paths[8] = "C://SAI//audio//voice//i.mp3";
         paths[9] = "C://SAI//audio//voice//j.mp3";
         paths[10] = "C://SAI//audio//voice//k.mp3";
         paths[11] = "C://SAI//audio//voice//l.mp3";
         paths[12] = "C://SAI//audio//voice//m.mp3";
         paths[13] = "C://SAI//audio//voice//n.mp3";
         paths[14] = "C://SAI//audio//voice//o.mp3";
         paths[15] = "C://SAI//audio//voice//p.mp3";
         paths[16] = "C://SAI//audio//voice//q.mp3";
         paths[17] = "C://SAI//audio//voice//r.mp3";
         paths[18] = "C://SAI//audio//voice//s.mp3";
         paths[19] = "C://SAI//audio//voice//t.mp3";
         paths[20] = "C://SAI//audio//voice//u.mp3";
         paths[21] = "C://SAI//audio//voice//v.mp3";
         paths[22] = "C://SAI//audio//voice//w.mp3";
         paths[23] = "C://SAI//audio//voice//x.mp3";
         paths[24] = "C://SAI//audio//voice//y.mp3";
         paths[25] = "C://SAI//audio//voice//z.mp3";
         

         String pathsp[] = new String[26]; 
         pathsp[0] = "C://SAI//audio//voice//qa.mp3";
         pathsp[1] = "C://SAI//audio//voice//qb.mp3";
         pathsp[2] = "C://SAI//audio//voice//qc.mp3";
         pathsp[3] = "C://SAI//audio//voice//qd.mp3";
         pathsp[4] = "C://SAI//audio//voice//qe.mp3";
         pathsp[5] = "C://SAI//audio//voice//qf.mp3";
         pathsp[6] = "C://SAI//audio//voice//qg.mp3";
         pathsp[7] = "C://SAI//audio//voice//qh.mp3";
         pathsp[8] = "C://SAI//audio//voice//qi.mp3";
         pathsp[9] = "C://SAI//audio//voice//qj.mp3";
         pathsp[10] = "C://SAI//audio//voice//qk.mp3";
         pathsp[11] = "C://SAI//audio//voice//ql.mp3";
         pathsp[12] = "C://SAI//audio//voice//qm.mp3";
         pathsp[13] = "C://SAI//audio//voice//qn.mp3";
         pathsp[14] = "C://SAI//audio//voice//qo.mp3";
         pathsp[15] = "C://SAI//audio//voice//qp.mp3";
         pathsp[16] = "C://SAI//audio//voice//qq.mp3";
         pathsp[17] = "C://SAI//audio//voice//qr.mp3";
         pathsp[18] = "C://SAI//audio//voice//qs.mp3";
         pathsp[19] = "C://SAI//audio//voice//qt.mp3";
         pathsp[20] = "C://SAI//audio//voice//qu.mp3";
         pathsp[21] = "C://SAI//audio//voice//qv.mp3";
         pathsp[22] = "C://SAI//audio//voice//qw.mp3";
         pathsp[23] = "C://SAI//audio//voice//qx.mp3";
         pathsp[24] = "C://SAI//audio//voice//qy.mp3";
         pathsp[25] = "C://SAI//audio//voice//qz.mp3";
        
        
         switch(sbtn1) {
         case 0: letra1 = "a"; break;
         case 1: letra1 = "b"; break;
         case 2: letra1 = "c"; break;
         case 3: letra1 = "d"; break;
         case 4: letra1 = "e"; break;
         case 5: letra1 = "f"; break;
         case 6: letra1 = "g"; break;
         case 7: letra1 = "h"; break;
         case 8: letra1 = "i"; break;
         case 9: letra1 = "j"; break;
         case 10: letra1 = "k"; break;
         case 11: letra1 = "l"; break;
         case 12: letra1 = "m"; break;
         case 13: letra1 = "n"; break;
         case 14: letra1 = "o"; break;
         case 15: letra1 = "p"; break;
         case 16: letra1 = "q"; break;
         case 17: letra1 = "r"; break;
         case 18: letra1 = "s"; break;
         case 19: letra1 = "t"; break;
         case 20: letra1 = "u"; break;
         case 21: letra1 = "v"; break;
         case 22: letra1 = "w"; break;
         case 23: letra1 = "x"; break;
         case 24: letra1 = "y"; break;
         case 25: letra1 = "z"; break;
         }
         
         switch(sbtn2) {
         case 0: letra2 = "a"; break;
         case 1: letra2 = "b"; break;
         case 2: letra2 = "c"; break;
         case 3: letra2 = "d"; break;
         case 4: letra2 = "e"; break;
         case 5: letra2 = "f"; break;
         case 6: letra2 = "g"; break;
         case 7: letra2 = "h"; break;
         case 8: letra2 = "i"; break;
         case 9: letra2 = "j"; break;
         case 10: letra2 = "k"; break;
         case 11: letra2 = "l"; break;
         case 12: letra2 = "m"; break;
         case 13: letra2 = "n"; break;
         case 14: letra2 = "o"; break;
         case 15: letra2 = "p"; break;
         case 16: letra2 = "q"; break;
         case 17: letra2 = "r"; break;
         case 18: letra2 = "s"; break;
         case 19: letra2 = "t"; break;
         case 20: letra2 = "u"; break;
         case 21: letra2 = "v"; break;
         case 22: letra2 = "w"; break;
         case 23: letra2 = "x"; break;
         case 24: letra2 = "y"; break;
         case 25: letra2 = "z"; break;
         }
        
         switch(sbtn3) {
         case 0: letra3 = "a"; break;
         case 1: letra3 = "b"; break;
         case 2: letra3 = "c"; break;
         case 3: letra3 = "d"; break;
         case 4: letra3 = "e"; break;
         case 5: letra3 = "f"; break;
         case 6: letra3 = "g"; break;
         case 7: letra3 = "h"; break;
         case 8: letra3 = "i"; break;
         case 9: letra3 = "j"; break;
         case 10: letra3 = "k"; break;
         case 11: letra3 = "l"; break;
         case 12: letra3 = "m"; break;
         case 13: letra3 = "n"; break;
         case 14: letra3 = "o"; break;
         case 15: letra3 = "p"; break;
         case 16: letra3 = "q"; break;
         case 17: letra3 = "r"; break;
         case 18: letra3 = "s"; break;
         case 19: letra3 = "t"; break;
         case 20: letra3 = "u"; break;
         case 21: letra3 = "v"; break;
         case 22: letra3= "w"; break;
         case 23: letra3 = "x"; break;
         case 24: letra3 = "y"; break;
         case 25: letra3 = "z"; break;
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
         perguntada =  r.nextInt(26);
         }while(perguntada!=sbtn1&&perguntada!=sbtn2&&perguntada!=sbtn3);
         
         
         
         try {
  			new ControllerMusica(pathsp[perguntada]).play();
  		 }catch (Exception e) {e.printStackTrace();}
         
         
         switch(perguntada) {
         case 0: sperguntada = "a"; break;
         case 1: sperguntada = "b"; break;
         case 2: sperguntada = "c"; break;
         case 3: sperguntada = "d"; break;
         case 4: sperguntada = "e"; break;
         case 5: sperguntada = "f"; break;
         case 6: sperguntada = "g"; break;
         case 7: sperguntada = "h"; break;
         case 8: sperguntada = "i"; break;
         case 9: sperguntada = "j"; break;
         case 10: sperguntada = "k"; break;
         case 11: sperguntada = "l"; break;
         case 12: sperguntada = "m"; break;
         case 13: sperguntada = "n"; break;
         case 14: sperguntada = "o"; break;
         case 15: sperguntada = "p"; break;
         case 16: sperguntada = "q"; break;
         case 17: sperguntada = "r"; break;
         case 18: sperguntada = "s"; break;
         case 19: sperguntada = "t"; break;
         case 20: sperguntada = "u"; break;
         case 21: sperguntada = "v"; break;
         case 22: sperguntada = "w"; break;
         case 23: sperguntada = "x"; break;
         case 24: sperguntada = "y"; break;
         case 25: sperguntada = "z"; break;
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
            		 c.InsertAlfabeto(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra1);
            		 
            	    	
            	    	
            	    	
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
	         		 c.InsertAlfabeto(userx,"Errou",letra1+letra2+letra3,sperguntada,letra1);
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
	         		 c.InsertAlfabeto(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra2);
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
         		 c.InsertAlfabeto(userx,"Errou",letra1+letra2+letra3,sperguntada,letra2);
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
         		 c.InsertAlfabeto(userx,"Acertou",letra1+letra2+letra3,sperguntada,letra3);
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
         		 c.InsertAlfabeto(userx,"Errou",letra1+letra2+letra3,sperguntada,letra3);
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