package umc.sai.view;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import umc.sai.controller.ControllerAvaliacao;
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;
  
public class ViewPainelVogais extends JPanel {  

	private static final long serialVersionUID = 1L;

    private JLabel lblImg;  
    private ImageIcon img[];
    private String paths[];
    private TelaVogais tvaux;
    private Usuario userx;

    public ViewPainelVogais(TelaVogais tv,Usuario user) {  
        userx=user;
    	tvaux = tv;
           
        img = new ImageIcon[5];
        img[0] = new ImageIcon("C://sai//img//Package//Letras//a.png");
        img[1] = new ImageIcon("C://sai//img//Package//Letras//e.png");
        img[2] = new ImageIcon("C://sai//img//Package//Letras//i.png");
        img[3] = new ImageIcon("C://sai//img//Package//Letras//o.png");
        img[4] = new ImageIcon("C://sai//img//Package//Letras//u.png");

        paths = new String[5]; 
        paths[0] = "C://SAI//audio//voice//a.mp3";
        paths[1] = "C://SAI//audio//voice//e.mp3";
        paths[2] = "C://SAI//audio//voice//i.mp3";
        paths[3] = "C://SAI//audio//voice//o.mp3";
        paths[4] = "C://SAI//audio//voice//u.mp3";
        
        
        setLayout(new FlowLayout());
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(206,148));
        setBackground(new Color(0,0,0));
        this.setLocation((screenSize.width-206)/2,(screenSize.height-148)/2);
        this.setName("SAI");
        add(getLblImg());  
        setSize(206,148);  
        setVisible(true);  
        
      
  
        // Iniciamos um timer para atualizar o panel  
        ClockAction t = new ClockAction();                 
        t.start();  
    }  
  
    private JLabel getLblImg() {  
        if (lblImg == null) {  
            lblImg = new JLabel();  
        }  
        return lblImg;  
    }  
  
    /** 
     * M�todo para atualizar o panel. N�o � thread-safe, portanto, 
     * se o utilizado fora da thread da AWT, deve-se utilizar um dos comandos da 
     * EventQueue (invokeLater ou invokeAndWait). 
     */  
    public void setImg(ImageIcon i) {  
        getLblImg().setIcon(i);  
    }  
  
    /** 
     * Action que cont�m o c�digo que atuar� na nossa thread. Basicamente, ele 
     * chama o m�todo que atualiza de fato o panel a cada 3 segundos, passando a imagem atual. 
     * Roda diretamente na thread da AWT.  
     */  
    private class ClockAction extends Thread {  
    	
    	public synchronized void run(){

    		 for (int i = 0;i<5;i++){
	         
	         		 setImg(img[i]);
	         		 try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		         	 try {
		     			new ControllerMusica(paths[i]).play();
		     			
		     		 }catch (Exception e) {e.printStackTrace();}
		         	 try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	         		  

	         }
    		 try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            tvaux.setVisible(false);
            new ControllerAvaliacao(0,userx);
            
        }  
    }  
  
}  