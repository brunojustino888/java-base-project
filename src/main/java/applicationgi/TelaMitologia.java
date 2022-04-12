package applicationgi;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/** TelaMitologia:
 * Essa � a interface � para a mitologia. 
 * @author Bruno Alves Justino
 * @date � Mar�o - 2014
 */

public class TelaMitologia extends JDialog {

    //Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel lblGI;
	private Musica m;
	
	public TelaMitologia() {
        
		//Dados da Cria��o da Janela
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(238, 238, 238));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(790, 674));
        this.setLocation((screenSize.width-790)/2,(screenSize.height-674)/2);
        this.setTitle(" Mitologia");
        this.setResizable(false);
        this.setModal(true);
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        
        //Tocando uma m�sica utilizando a classe Musica.
        try {
    		m = null;
    		m = new Musica("C:\\Application4GI\\audio\\Moonlight Sonata.mp3");
    		m.play();
    	} catch (Exception e2) {
    		e2.printStackTrace();
    	}

        ImageIcon ImageGi = new ImageIcon(getClass().getResource("img/hm.jpg"));
        lblGI = new JLabel(ImageGi);
        lblGI.setBounds(new Rectangle(0, 0, 790, 674));
        this.getContentPane().add(lblGI, null);
        
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                m.stop();
            	new TelaGI();
            }
        });
        this.setVisible(true);
    }

}