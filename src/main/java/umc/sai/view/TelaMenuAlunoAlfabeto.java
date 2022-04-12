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


public class TelaMenuAlunoAlfabeto extends JDialog {

     /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel lblImageBackground;
	private JButton btnComecar;
	private ControllerFonte fonte;
	private ControllerMusica maux;
	private Usuario userx;
	
	public TelaMenuAlunoAlfabeto(ControllerMusica musica, Usuario user) {
		 maux = musica;
		 userx=user;
    	 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(255, 255, 255));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(806, 628));
         this.setLocation((screenSize.width-806)/2,(screenSize.height-616)/2);
         this.setTitle("SAI - Menu Principal");
         this.setResizable(false);
         this.setModal(true);
         ImageIcon wittelIcon = new ImageIcon("C://sai//img//xbtn.png");
         this.setIconImage(wittelIcon.getImage());
         fonte= new ControllerFonte();
         
         
      	//Tocando a m�sica fazendo uso do Objeto Musica.
         try {	
            	ControllerMusica musica11 = null;
    			musica11 = new ControllerMusica("C:\\SAI\\audio\\voice\\comecoalfabeto.mp3");
    			musica11.play();
    	 }catch(Exception e11) {e11.printStackTrace();}

       
         
         btnComecar = new JButton("COME�AR");
         btnComecar.setFont(fonte.getFonteBold(14));
         btnComecar.setBounds(new Rectangle(326, 436, 150, 30));
         this.getContentPane().add(btnComecar, null);
         btnComecar.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 
            	 try{
        			 maux.stop();
        			 maux.close();
        		 }catch(NullPointerException e11) {e11.printStackTrace();}
            	 
                setVisible(false);
        		
                
                new TelaAlfabeto(userx);
         		
         		
         		

        		//try {
        	//		Thread.sleep(2000);
        	//	} catch (InterruptedException e3) {e3.printStackTrace();}
        		
        		//tv.setVisible(false);
               
        		
        	
             }
         });
         
     
         ImageIcon Image = new ImageIcon("C://sai//img//BackgroundTelaAlfabeto.png");
         lblImageBackground = new JLabel(Image);
         lblImageBackground.setBounds(new Rectangle(0, 0, 800, 600));
         this.getContentPane().add(lblImageBackground, null);
         
         
         this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
	    			System.out.println(resp);
	            	if(resp==0){
	    				aoFechar();
	    			}
	            }
	        });
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
    }


    /**<p>M�todo usado para interromper a execu��o da aplica��o.</p>*/
    public void aoFechar(){
    	System.exit(0);
    }
	
}