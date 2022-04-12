package umc.video;

import java.io.File;
import java.net.MalformedURLException;  
import java.net.URL;  

import javax.swing.JFileChooser;  
import javax.swing.JFrame;  


public class Main {  
  
    public static void main(String[] args) {  
       
    	  
  
          
                JFrame mediaTest = new JFrame("Media PLayer");  
                mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                mediaTest.getContentPane().setLayout(null);  
                mediaTest.setSize(700,700);  
             
                URL videoURL = null;
				try {
					videoURL = new URL("C:\\Application4GI\\video\\Mitologia Grega.mpg");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                MediaPanel mediaPanel = new MediaPanel(videoURL);  
                mediaTest.getContentPane().add(mediaPanel);  
  
                mediaTest.setVisible(true);  
  
            
    }  
  
}  