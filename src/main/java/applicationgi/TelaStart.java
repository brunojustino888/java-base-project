package applicationgi;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;

/** TelaStart:
 * Essa � a primeira interface gr�fica que � mostrada ao usu�rio. 
 * Ap�s clicar, o usu�rio � direcionado para a interface principal da aplica��o.
 * @author Bruno Alves Justino
 * @date � Mar�o - 2014
 */

public class TelaStart extends JDialog {

	private static final long serialVersionUID = 1L;
    private JButton btnOK;
    public Musica m = null;
    public JLabel lblGI;
    
    public TelaStart() {
    
    	
    //Dados da Cria��o da Janela
    Container c = getContentPane();
    c.setLayout(null);
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(new java.awt.Dimension(180, 180));
    this.setLocation((screenSize.width-180)/2,(screenSize.height-180)/2);
    this.setTitle("  Application4GI");
    this.setResizable(false);
    ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
    this.setIconImage(wittelIcon.getImage());
    c.setBackground(Color.black);
    
    btnOK = new JButton("Start");
    btnOK.setFont(getFonte(22));
    btnOK.setBounds(new Rectangle(29, 50, 120, 55));
    this.getContentPane().add(btnOK, null);
    btnOK.addActionListener (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        	new TelaGI();
        }
    });
    
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	System.exit(0);
            }
        });
    
        
        
        //Imagem
        ImageIcon ImageGi = new ImageIcon(getClass().getResource("img/Start.jpg"));
        lblGI = new JLabel(ImageGi);
        lblGI.setBounds(new Rectangle(0, -20, 190, 190));
        this.getContentPane().add(lblGI, null);
        
        this.setVisible(true);
        btnOK.requestFocus();
    }

    
    
    public Font getFonte(int tamanho){  
        Font font = null;  
        try{  
            File file = new File("C:\\Application4GI\\font\\maiden.ttf");  
            FileInputStream fis = new FileInputStream( file );  
            font = Font.createFont( Font.TRUETYPE_FONT , fis );  
        }catch( Exception e ){  
            System.out.println(e.getMessage());  
        }  
        font = font.deriveFont( Font.PLAIN , tamanho );  
        return font;  
    } 

}