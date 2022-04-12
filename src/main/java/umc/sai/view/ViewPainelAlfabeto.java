package umc.sai.view;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import umc.sai.controller.ControllerAvaliacao;
import umc.sai.controller.ControllerMusica;
import umc.sai.model.Usuario;
  
public class ViewPainelAlfabeto extends JPanel {  

	private static final long serialVersionUID = 1L;

    private JLabel lblImg;  
    private ImageIcon img[];
    private String paths[];
    private TelaAlfabeto tvaux;
    private Usuario userx;

    public ViewPainelAlfabeto(TelaAlfabeto tv,Usuario user) {  
        userx=user;
    	tvaux = tv;
           
    	 img = new ImageIcon[26];
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

        paths = new String[26]; 
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

    		 for (int i = 0;i<26;i++){
	         
	         		 setImg(img[i]);
	         		 try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		         	 try {
		     			new ControllerMusica(paths[i]).play();
		     			
		     		 }catch (Exception e) {e.printStackTrace();}
		         	 try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	         		  

	         }
    		 try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            tvaux.setVisible(false);
            new ControllerAvaliacao(1,userx);
            
        }  
    }  
  
}  