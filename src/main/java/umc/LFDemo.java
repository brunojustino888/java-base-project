package umc;
import java.awt.*;  

import javax.swing.*;  
import javax.swing.plaf.metal.*;  


//import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
//import com.birosoft.liquid.LiquidLookAndFeel; 

public class LFDemo extends JFrame{  
      
	//define caracteristicas da janela  
    public LFDemo(){  
        super("L&F");  
        setLayout(new GridLayout(2,3));  
        setBounds(300,400,200,100);  
          
         //O codigo que define o look est� logo abaixo e  
         // deve est� entre um try catch pra funcionar  
        try {  
          
        	//ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel();
        	//UIManager.setLookAndFeel(new Plastic3DLookAndFeel()); 
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel"); //Windows  
        	//UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
        	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        	//UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
        	UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        	
        }catch(Exception e) {  
            //Inseira qualuquer codigo, se necess�rio.  
        }  
          
        //Inserir bot�o  
        add(new JButton("But�o1"));  
    }  
    	//Principal ou MAIN  
    	public static void main (String[] args) {  
    		new LFDemo().setVisible(true);  
    	}  
} 

/*
com.sun.java.swing.plaf.gtk.GTKLookAndFeel - padr�o GTK+
javax.swing.plaf.metal.MetalLookAndFeel - Metal
com.sun.java.swing.plaf.windows.WindowsLookAndFeel - Windows
com.sun.java.swing.plaf.motif.MotifLookAndFeel - Motif
javax.swing.plaf.mac.MacLookAndFeel - Mac */