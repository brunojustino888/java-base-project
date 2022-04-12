package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import umc.sai.model.Usuario;

public class TelaVogais extends JDialog {

     /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel  lblImageBackground;
	private static ViewPainelVogais painelvogais;
	private Usuario userx;

	
	public TelaVogais(Usuario user) {

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
         
         

         
         painelvogais = new ViewPainelVogais(this, userx); 
         painelvogais.setBounds(new Rectangle(297, 226, 206,148));
         this.getContentPane().add(painelvogais, null); 
                
         
         ImageIcon Image = new ImageIcon("C://sai//img//Background1Vogais1.png");
         lblImageBackground = new JLabel(Image);
         lblImageBackground.setBounds(new Rectangle(0, 0, 800, 600));
         this.getContentPane().add(lblImageBackground, null);
         
 		
         
         this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            }
	        });
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
 
    }
    
}