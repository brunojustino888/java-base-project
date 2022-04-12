package umc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;






public class Janelinha  {

	JFrame j = new JFrame();
	
    public Janelinha() {
        
    j.getContentPane().setLayout(null);
    j.getContentPane().setBackground(new Color(153, 51, 255));
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //cria uma vari�vel do tipo dimens�o
    j.setLocation((screenSize.width-800)/2,(screenSize.height-600)/2);  //serve para abrir no meio do screen
    j.setTitle("Prot�tipo SAI - Sistema de Aprendizagem Infantil - Tela Aprender");
    j.setResizable(false); //habilita tela inteira	
    j.setVisible(true);
    j.setSize(800,600);
    
    

    
	/*try {
		//UIManager.setLookAndFeel("com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel");
		//UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
		//UIManager.setLookAndFeel(new PlasticXPLookAndFeel()); 
		
		
		UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}*/
    
  
    
      //TelaLogin tl = new TelaLogin();
      
        
    }
    
 public static void main(String args[]) {
        
    	
    	new Janelinha();

}}