package umc.threads;

//import musica.Musica;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;


public class SafetyThreads extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JLabel lblAcertou,lblImageBackground;
	//public Musica m ;
	
	
    public SafetyThreads(boolean acertou) {

    	
        if(acertou){
    
        	 String path = "X:\\SAI\\img\\xbtn.png";
        	 ImageIcon wittelIcon = new ImageIcon(path);
             this.setIconImage(wittelIcon.getImage());
             this.getContentPane().setLayout(null);
             this.getContentPane().setBackground(new Color(0, 0, 0));
             java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
             this.setSize(new java.awt.Dimension(680, 720));
             this.setLocation((screenSize.width-680)/2,(screenSize.height-720)/2);
             this.setTitle("Acertou !");
             this.setResizable(false);
        	
        	
        	 lblAcertou = new JLabel("Acertou !");
             lblAcertou.setForeground(Color.GREEN);
             lblAcertou.setFont(getFonte(80));
             lblAcertou.setBounds(new Rectangle(150, 550, 500, 90));
             this.getContentPane().add(lblAcertou, null);
             String smilePNG = "X:\\SAI\\img\\SmileAcertou.png";
             ImageIcon Image = new ImageIcon(smilePNG);
             lblImageBackground = new JLabel(Image);
             lblImageBackground.setBounds(new Rectangle(20, -50, 640, 586));
             this.getContentPane().add(lblImageBackground, null);
             
             //Tocando uma m�sica utilizando a classe Musica.
	         try {	
	        //    	Musica m = null;
	    		//	m = new Musica("X:\\SAI\\audio\\Acertou.mp3");
	    	//		m.play();
	    		
	    			//Iniciamos a thread safety, que � uma deamon thread para que morra assim que a aplica��o fechar.  
	    	        Thread gloomThread = new Thread(new SafetyRunnable(), "Funciona por favor.");  
	    	        gloomThread.setDaemon(true);  
	    	        gloomThread.start();  
	    			
	    	}catch (Exception e2) {	e2.printStackTrace();}
	            
	        fechaEssaPorra();
 
        }else{
		        	
		          	String path = "X:\\SAI\\img\\xbtdn.png";
		       	    ImageIcon wittelIcon = new ImageIcon(path);
		            this.setIconImage(wittelIcon.getImage());
		            this.getContentPane().setLayout(null);
		            this.getContentPane().setBackground(new Color(0, 0, 0));
		            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		            this.setSize(new java.awt.Dimension(680, 720));
		            this.setLocation((screenSize.width-680)/2,(screenSize.height-720)/2);
		            this.setTitle("Errou !");
		            this.setResizable(false);
			        lblAcertou = new JLabel("Errou !");
			        lblAcertou.setForeground(Color.RED);
			        lblAcertou.setFont(getFonte(80));
			        lblAcertou.setBounds(new Rectangle(205, 550, 500, 90));
			        this.getContentPane().add(lblAcertou, null);
			        String smilePNG = "D:\\SAI\\img\\SmileErrou.png";
			        ImageIcon Image = new ImageIcon(smilePNG);
			        lblImageBackground = new JLabel(Image);
			        lblImageBackground.setBounds(new Rectangle(20, -50, 640, 586));
			        this.getContentPane().add(lblImageBackground, null);
			        
        	 }
        
		
        
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	fechaEssaPorra();
            }
        });
        this.setVisible(true);
    }

    private void fechaEssaPorra() {
    	setVisible(false); 
    }

    public Font getFonte(int tamanho){  
        Font font = null;  
        try{  
            File file = new File("X:\\SAI\\font\\FingerPaint-Regular.ttf");  
            FileInputStream fis = new FileInputStream( file );  
            font = Font.createFont( Font.TRUETYPE_FONT , fis );  
        }catch( Exception e ){  
            System.out.println(e.getMessage());  
        }  
        font = font.deriveFont( Font.PLAIN , tamanho );  
        return font;  
    } 

    
    /** 
     * Nossa Innerclass SafetyRunnable que cont�m o c�digo que ser� executado na thread. Esse c�digo chama o m�todo m.getIsAcabou() de segundo em segundo. 
     * Esse Runnable � uma InnerClass n�o est�tica, ent�o podemos chamar os m�todos da nossa classe swing explicitamente. 
     * Isso far� "Thread safety" para a nossa classse Swing.
     * Faremos nossa thread "dormir" por 1 segundo para que libere o processador as para outras threads processarem.
     */  
    private class SafetyRunnable implements Runnable {  
        public void run() {  
            try {  
            	boolean aux=true;
                while (aux) {			 
                	
                    //Enquanto a m�sica n�o acaba, demora 10 segundos e vai fechar a janela... ou pelo menos deveria...  
                    EventQueue.invokeLater(new Runnable() {public void run(){}});  
                    Thread.sleep(10000);
                    aux=false;
                    fechaEssaPorra(); 
                    new SafetyThreads(false);
                }  
                        
            }  
            catch (InterruptedException e) {  
            }  
        }  
    }  
    
    
    public static void main(String args[]) {
        new SafetyThreads(true);
    }
    
    
    
}

