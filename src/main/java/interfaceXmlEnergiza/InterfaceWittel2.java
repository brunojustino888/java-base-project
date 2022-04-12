package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InterfaceWittel2 extends JFrame {

	//Dados dos Objetos da Janela
	private static final long serialVersionUID = 1L;
	private JButton btnUsers, btnSair, objeto13, objeto13II, btnCarregar;
	private JComboBox<String> jcbXML;
	private JLabel lblImage;
	private String privilegio;

	    
	//Construtor
    public InterfaceWittel2(String privilegioDoUsuario) {
    	privilegio = privilegioDoUsuario;
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(396, 300));
        this.setLocation((screenSize.width-396)/2,(screenSize.height-245)/2);
        this.setTitle("Menu Principal");
        this.setResizable(false);
        ImageIcon icWttl = new ImageIcon(getClass().getResource("img/wwl.png"));
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        lblImage = new JLabel(icWttl);
        lblImage.setBounds(new Rectangle(-8, -15, 415, 205));
        this.getContentPane().add(lblImage);
        objeto13II = new JButton(" ");
        objeto13II.setBounds(new Rectangle(-9, 211, 500, 3));
        this.getContentPane().add(objeto13II, null);
        jcbXML = new JComboBox<String>();
        jcbXML.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,11));
        jcbXML.addItem("Bypass.xml");
        jcbXML.addItem("Callback_BO.xml");
        jcbXML.addItem("Callback_MG.xml");
        jcbXML.addItem("Callback_NF.xml");
        jcbXML.addItem("Callback_PB.xml");
        jcbXML.addItem("Callback_SE.xml");
        jcbXML.addItem("Horario_Verao.xml");
        jcbXML.addItem("Operadora_Callback.xml");
        jcbXML.addItem("Prioridade_Opcao.xml");
        jcbXML.addItem("Prioridade_Sites.xml");
        jcbXML.addItem("Retencao.xml");
        jcbXML.setBounds(new Rectangle(15, 234, 250, 20));
        this.getContentPane().add(jcbXML, null);
        btnCarregar = new JButton("Carregar");
        btnCarregar.setBounds(new Rectangle(281, 234, 88, 20));
        btnCarregar.setFont(new Font("Arial", Font.BOLD,11));
        this.getContentPane().add(btnCarregar, null);
        btnCarregar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jcbXML.getSelectedItem()=="Bypass.xml"){
                	setVisible(false);
                	new InterfaceBypass("X:\\Bypass.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Callback_BO.xml"){
                	setVisible(false);
                	new InterfaceBusinessHours("X:\\Callback_BO.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Callback_MG.xml"){
                	setVisible(false);
                	new InterfaceBusinessHours("X:\\Callback_MG.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Callback_NF.xml"){
                	setVisible(false);
                	new InterfaceBusinessHours("X:\\Callback_NF.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Callback_PB.xml"){
                	setVisible(false);
                	new InterfaceBusinessHours("X:\\Callback_PB.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Callback_SE.xml"){
                	setVisible(false);
                	new InterfaceBusinessHours("X:\\Callback_SE.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Horario_Verao.xml"){
                	setVisible(false);
                	new InterfaceHorarioVerao("X:\\HorarioVerao.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Operadora_Callback.xml"){
                	setVisible(false);
                	new InterfaceOperadoraCallback("C:\\OperadoraCallback.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Prioridade_Opcao.xml"){
                	setVisible(false);
                	new InterfaceDefiniPrioridades("X:\\Prioridade_Opcao.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Prioridade_Sites.xml"){
                	setVisible(false);
                	new InterfacePrioridade("X:\\Prioridade_Sites.xml",privilegio);
                }else if(jcbXML.getSelectedItem()=="Retencao.xml"){
                	setVisible(false);
                	new InterfaceRetencaoEstado("X:\\Retencao.xml",privilegio);
                }
            }
        });
        
        btnUsers = new JButton("Usu�rios");
        btnUsers.setBounds(new Rectangle(50, 170, 100, 30));
        btnUsers.setFont(new Font("Arial", Font.BOLD,11));
        this.getContentPane().add(btnUsers, null);
        if(privilegio.equals("0")){btnUsers.setVisible(false);}else{btnUsers.setVisible(true);}
        btnUsers.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	try{
            	String sOperacao = JOptionPane.showInputDialog(null, "Digite o que voc� deseja fazer?\n1 - Cadastrar um novo usu�rio.\n2 - Apagar um determinado Usu�rio.","Escolha uma Op��o",3); 
            
            		setVisible(false);
            		new Cadastros(sOperacao, privilegio);
            	
            	}catch(Exception e1){
            		new InterfaceWittel2(privilegio);
            	}
            }
        });
        btnSair = new JButton("Sair");
        btnSair.setBounds(new Rectangle(239, 170, 100, 30));
        btnSair.setFont(new Font("Arial", Font.BOLD,11));
        this.getContentPane().add(btnSair, null);
        btnSair.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               aoFechar();
            }
        });
        objeto13 = new JButton();
        objeto13.setBounds(new Rectangle(-1, 158, 500, 3));
        this.getContentPane().add(objeto13, null);
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