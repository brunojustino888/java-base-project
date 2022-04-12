package umc.sai.view;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** <h1>TelaInicio:</h1>
 *	 <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * 		<p>Essa � a primeira interface gr�fica que � mostrada ao usu�rio.</p> 
 *		 <p>Apenas para apresentar o logo do projeto.</p>
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 */
public class ViewTelaInicio extends JDialog {

	/**<p>Objetos da classe<p>*/
	private static final long serialVersionUID = 1L;
    private JLabel lblDecorativoI;
    private ImageIcon icone,lapisLogin;


    
    /**<p>Construtor do Frame</p>*/
    public ViewTelaInicio() {
	    this.getContentPane().setLayout(null);
	    this.getContentPane().setBackground(new Color(255, 255, 255));
	    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(new java.awt.Dimension(806, 628));
        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
	    this.setTitle("SAI - Sistema de Aprendizagem Infantil");
	    this.setResizable(false);
	   	icone = new ImageIcon("C:\\SAI\\img\\xbtn.png");
	  	this.setIconImage(icone.getImage());
	  
	    lapisLogin = new ImageIcon("C:\\SAI\\img\\BackgroundInicio.jpg");
	    lblDecorativoI = new JLabel(lapisLogin);
	    lblDecorativoI.setBounds(new Rectangle(0,0, 800, 600));
	    this.getContentPane().add(lblDecorativoI, null);
	   
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            }
	        });
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);

    }

}