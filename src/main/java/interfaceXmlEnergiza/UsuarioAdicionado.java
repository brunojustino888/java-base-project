package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 /*	
 * Essa classe foi desenvolvida somente para mostrar uma janela que informa ao usu�rio que 
 * 	a opera��o executada foi realizada com sucesso pela aplica��o. 
 * 	Essa classe recebe como par�metro o n�vel de privil�gio do usu�rio que logou no sistema. 
 *  Privil�gio 1 = Usu�rio ADMIN -/- Privil�gio 0 = Usu�rio NORMAL
 */

public class UsuarioAdicionado extends JDialog {
	
	//Vari�veis da classe
	private static final long serialVersionUID = 1L;
	private String privilegio;
    private JButton btnOK;
    private JLabel lblFrase, lblImage2;
    
    public UsuarioAdicionado(String pr) {
    	privilegio = pr;												//Privil�gio do usu�rio Logado na aplica��o.
        this.getContentPane().setLayout(null);  						//Recupera-se o container default do JDialog para definir um Layout padr�o. 
        this.getContentPane().setBackground(new Color(255, 255, 255));	//Recupera-se o container default do JDialog para definir uma cor de fundo.
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //Recupera-se o container default do JDialog descobrir o tamanho do monitor.
        this.setSize(new java.awt.Dimension(254, 154));					//Defini o tamanho da janela.
        this.setLocation((screenSize.width-254)/2,(screenSize.height-154)/2);  //Centraliza a janela no centro do monitor.
        this.setTitle("Usu�rio Adicionado!");							//T�tulo da janela.
        this.setResizable(false);										//Op��o de maximizar a janela.
        this.setModal(true);											//Op��o de maximizar a janela.
        ImageIcon energisa = new ImageIcon(getClass().getResource("img/checked.png")); //Imagem e caminho da mesma.
   	 	lblImage2 = new JLabel(energisa);								//Label que carregar� a imagem.
        lblImage2.setBounds(new Rectangle(-84	,-45, 415, 205));		//Tamanho da imagem.
        this.getContentPane().add(lblImage2);							//Adicionando a imagem no container do frame.
        
        //Configura��es do bot�o OK
        btnOK = new JButton("OK");
        btnOK.setBounds(new Rectangle(94, 86, 60, 24));
        this.getContentPane().add(btnOK, null);
        btnOK.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.gc();											//Chama-se o GarbageCollector para finalizar os objetos da mem�ria
            	setVisible(false);										//Deixa a janela invis�vel
            	new InterfaceWittel2(privilegio);						//Instancia-se uma nova InterfaceWittel
            }
        });
        
        //Label que informa que o usu�rio foi cadastrado com sucesso.
        lblFrase = new JLabel("O Usu�rio foi cadastrado com sucesso."); 
        lblFrase.setBounds(new Rectangle(12, 14, 250, 13));
        this.getContentPane().add(lblFrase, null);
        
        
        //Ao clicar no X da janela que informa que o usu�rio foi cadastrado, instacia-se uma nova InterfaceWittel.
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	new InterfaceWittel2(privilegio);
            }
        });

        this.setVisible(true); //Deixa a janela vis�vel ao usu�rio
    
    }

}