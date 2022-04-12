package applicationgi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/** TelaGI:
 * Essa � a tela principal da aplica��o. 
 * Nela existem dois bot�es para seguir com a navega��o.
 * O bot�o Informa��es direciona a aplica��o para a tela especifica
 * O bot�o de Mitologia direciona para uma outra interface que ter� informa��es sobre a mitologia grega.
 * @author Bruno Alves Justino
 * @date � Mar�o - 2014
 */

public class TelaGI extends JDialog {

    //Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JLabel lblGI;
	private JButton btnInfo,btnMitologia;
	private Musica m;
	
	public TelaGI() {
        
    	//Dados da Cria��o da Janela
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(238, 238, 238));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(750, 470));
        this.setLocation((screenSize.width-750)/2,(screenSize.height-470)/2);
        this.setTitle("Teste");
        this.setResizable(false);
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        c.setBackground(Color.white);
        
        //Tocando uma m�sica utilizando a classe Musica.
        try {
    		m = null;
    		m = new Musica("C:\\Application4GI\\audio\\Johann Pachelbel.mp3");
    		m.play();
    	} catch (Exception e2) {
    		e2.printStackTrace();
    	}
        
        btnInfo = new JButton("Homenagem");
        btnInfo.setFont(new Font("Vivaldi",Font.BOLD,14));
        btnInfo.setBounds(new Rectangle(470, 380, 120, 45));
        this.getContentPane().add(btnInfo, null);
        btnInfo.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            	m.stop();
            	new TelaHmGI();
            }
        });
        
        btnMitologia = new JButton("Mitologia");
        btnMitologia.setFont(new Font("Vivaldi",Font.BOLD,14));
        btnMitologia.setBounds(new Rectangle(610, 380, 120, 45));
        this.getContentPane().add(btnMitologia, null);
        btnMitologia.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            	m.stop();
            	new TelaMitologia();
            }
        });
        
        //Imagem de teste
        ImageIcon ImageGi = new ImageIcon(getClass().getResource("img/Moldura Teste.jpg"));
        lblGI = new JLabel(ImageGi);
        lblGI.setBounds(new Rectangle(0, 0, 744, 446));
        this.getContentPane().add(lblGI, null);
        
        //Dados da Cria��o dos Controles na Janela
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                aoFechar();
            }
        });
        this.setVisible(true);
    }

    private void aoFechar() {
        System.exit(0);
    }

}