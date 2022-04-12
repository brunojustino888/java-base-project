package application4paradox;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Congratulations extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblImage;
    private JButton btnOK;
    private Musica m;
    
    public Congratulations() {
    	
    	 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(0, 0,0));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(310, 310));
         this.setLocation((screenSize.width-310)/2,(screenSize.height-310)/2);
         this.setTitle("MSIT - Paradox 4 TXT");
         this.setResizable(false);
         this.setModal(true);
         ImageIcon icon = new ImageIcon("C:/Application4Paradox/img/xbtn.png");
         this.setIconImage(icon.getImage());
       
        
         //Tocando uma m�sica utilizando a classe Musica.
         try {
 			m = null;
 			m = new Musica("C:/Application4Paradox/audio/Goodnight.mp3");
 			m.play();
 	     }catch ( Exception e2) {
 			e2.printStackTrace();
 		 }
         
         btnOK = new JButton("OK");
         btnOK.setToolTipText("Voltar � tela anterior");
         btnOK.setBounds(new Rectangle(107, 225, 90, 21));
         this.getContentPane().add(btnOK, null);
         btnOK.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                setVisible(false);
            	new Interface();
                
             }
         });
      
         ImageIcon background = new ImageIcon("C:/Application4Paradox/img/background3.png");
         lblImage = new JLabel(background);
         lblImage.setBounds(new Rectangle(0, -20, 300, 300));
         this.getContentPane().add(lblImage);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	  setVisible(false);
                  m.stop();
                  m.close();
                  new Interface();
            }
        });
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }


  
   
}