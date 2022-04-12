package applicationgi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/** TelaHmGI:
 * Essa � a interface para hmGi. 
 * @author Bruno Alves Justino
 * @date � Mar�o - 2014
 */

public class TelaHmGI extends JDialog {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
    private JLabel lblTitulo;
    private JLabel lbl0;
    private JLabel lbl2;
    private JLabel lbl4;
    private JLabel lbl1;
    private JLabel lbl3;
    private JLabel lbl6;
    private JLabel lbl7;
    private JLabel lbl9;
    private JLabel lbl8;
    private JLabel lbl12;
    private JLabel lbl11;
    private JLabel lbl10;
    private JLabel lbl13;
    private JLabel lbl14;
    private JLabel lbl15;
    private JLabel lbl16;
    private JLabel lbl17;
    private JLabel lbl18;
    private JLabel lbl19;
    private JLabel lbl20;
    private JLabel lbl21,lblGI;
    private JLabel lbl22;
    private Musica m;
    
    public TelaHmGI() {
        
    	System.gc();
    	//Dados da Cria��o da Janela
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(0,0,0));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(1095, 620));
        this.setLocation((screenSize.width-1095)/2,(screenSize.height-620)/2);
        this.setTitle("Hm teste");
        this.setResizable(false);
        this.setModal(true);
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        
        //Tocando uma m�sica utilizando a classe Musica.
        try {
    		m = null;
    		m = new Musica("C:\\Application4GI\\audio\\Ode to Joy.mp3");
    		m.play();
    	} catch (Exception e2) {
    		e2.printStackTrace();
    	}
        

        
        //Dados da Cria��o dos Controles na Janela
        lblTitulo = new JLabel("Teste");
        lblTitulo.setFont(new Font("Vivaldi",Font.BOLD,18));
        lblTitulo.setBounds(new Rectangle(463, 32, 120, 13));
        lblTitulo.setForeground(Color.white);
        this.getContentPane().add(lblTitulo, null);
        lbl0 =  new JLabel("Teste");
        lbl0.setFont(new Font("Arial",Font.PLAIN,14));
        lbl0.setBounds(new Rectangle(80, 80, 800, 13));
        lbl0.setForeground(Color.GRAY);
        this.getContentPane().add(lbl0, null);
        lbl2 =  new JLabel("Teste");
        lbl2.setBounds(new Rectangle(80, 120, 1500, 13));
        lbl2.setForeground(Color.GRAY);
        lbl2.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl2, null);
        lbl4 = new JLabel("Teste");
        lbl4.setBounds(new Rectangle(80, 160, 1500, 13));
        lbl4.setFont(new Font("Arial",Font.PLAIN,14));
        lbl4.setForeground(Color.GRAY);
        this.getContentPane().add(lbl4, null);
        lbl1 =  new JLabel("Teste");
        lbl1.setBounds(new Rectangle(80, 100, 1500, 13));
        lbl1.setForeground(Color.GRAY);
        lbl1.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl1, null);
        lbl3 =  new JLabel("Teste");
        lbl3.setForeground(Color.GRAY);
        lbl3.setBounds(new Rectangle(80, 140, 1500, 13));
        lbl3.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl3, null);
        lbl6 =  new JLabel("Teste");
        lbl6.setBounds(new Rectangle(80, 180, 1500, 13));
        lbl6.setForeground(Color.GRAY);
        lbl6.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl6, null);
        lbl7 = new JLabel("Teste");
        lbl7.setBounds(new Rectangle(80, 200, 1500, 13));
        lbl7.setForeground(Color.GRAY);
        lbl7.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl7, null);
        lbl9 = new JLabel("Teste");
        lbl9.setBounds(new Rectangle(80, 240, 1500, 13));
        lbl9.setForeground(Color.GRAY);
        lbl9.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl9, null);
        lbl8 =  new JLabel("Teste");
        lbl8.setBounds(new Rectangle(80, 220, 1500, 13));
        lbl8.setForeground(Color.GRAY);
        lbl8.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl8, null);
        lbl12 =  new JLabel("Teste");
        lbl12.setBounds(new Rectangle(80, 300, 1500, 13));
        lbl12.setForeground(Color.GRAY);
        lbl12.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl12, null);
        lbl11 =  new JLabel("Teste");
        lbl11.setBounds(new Rectangle(80, 280, 1500, 13));
        lbl11.setForeground(Color.GRAY);
        lbl11.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl11, null);
        lbl10 =  new JLabel("Teste");
        lbl10.setBounds(new Rectangle(80, 260, 1500, 13));
        lbl10.setForeground(Color.GRAY);
        lbl10.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl10, null);
        lbl13 = new JLabel("Teste");
        lbl13.setBounds(new Rectangle(80, 320, 1500, 13));
        lbl13.setForeground(Color.GRAY);
        lbl13.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl13, null);
        lbl14 =  new JLabel("Teste");
        lbl14.setBounds(new Rectangle(80, 340, 1500, 13));
        lbl14.setForeground(Color.GRAY);
        lbl14.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl14, null);
        lbl15 =  new JLabel("Teste");
        lbl15.setBounds(new Rectangle(80, 360, 1500, 13));
        lbl15.setForeground(Color.GRAY);
        lbl15.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl15, null);
        lbl16 =  new JLabel("Teste");
        lbl16.setBounds(new Rectangle(80, 380, 1500, 13));
        lbl16.setForeground(Color.GRAY);
        lbl16.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl16, null);
        lbl17 =  new JLabel("Teste");
        lbl17.setForeground(Color.GRAY);
        lbl17.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl17, null);
        lbl18 =  new JLabel("Teste");
        lbl18.setBounds(new Rectangle(80, 420, 1500, 13));
        lbl18.setForeground(Color.GRAY);
        lbl18.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl18, null);
        lbl19 =  new JLabel("Teste");
        lbl19.setBounds(new Rectangle(80, 440, 1500, 13));
        lbl19.setForeground(Color.GRAY);
        lbl19.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl19, null);
        lbl20 =  new JLabel("Teste");
        lbl20.setBounds(new Rectangle(80, 460, 1500, 13));
        lbl20.setForeground(Color.GRAY);
        lbl20.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl20, null);
        lbl21 = new JLabel("Teste");
        lbl21.setBounds(new Rectangle(80, 480, 1500, 13));
        lbl21.setForeground(Color.GRAY);
        lbl21.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl21, null);
        lbl22 =  new JLabel("Teste");
        lbl22.setBounds(new Rectangle(80, 500, 1500, 13));
        lbl22.setForeground(Color.GRAY);
        lbl22.setFont(new Font("Arial",Font.PLAIN,14));
        this.getContentPane().add(lbl22, null);
        
        ImageIcon ImageGi = new ImageIcon(getClass().getResource("img/teste.jpg"));
        lblGI = new JLabel(ImageGi);
        lblGI.setBounds(new Rectangle(180, 45, 705, 529));
        this.getContentPane().add(lblGI, null);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                m.stop();
                setVisible(false);
            	new TelaGI();
            }
        });
        this.setVisible(true);
    }

}