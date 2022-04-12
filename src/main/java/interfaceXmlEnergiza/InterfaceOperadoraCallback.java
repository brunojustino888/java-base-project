package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class InterfaceOperadoraCallback extends JFrame {

	private static final long serialVersionUID = 1L;
    private JLabel lblSites,lbl83Paraiba,lbl83Borborema,lblSergipe,lbl31MinasGerais,lbl32MinasGerais,lbl33MinasGerais,lbl21novaFriburgo,lbl22NovaFriburgo,lbl24NovaFriburgo,lblOperadora;
    private JComboBox<String> jcb83PB,jcb83BO,jcb79SE,jcb31MG,jcb32MG,jcb33MG,jcb21NF,jcb25NF,jcb222NF;
    private JButton btnAplicar,objeto13;
    private String privilegio,ArquivoXML;
    private boolean erro = false;
    
    
    public InterfaceOperadoraCallback(String xml, String privilegio) {
        this.privilegio = privilegio;
        ArquivoXML = xml;
    	this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(316, 343));
        this.setLocation((screenSize.width-316)/2,(screenSize.height-343)/2);
        this.setTitle("Sele��o da Operadora de Callback");
        this.setResizable(false);
        ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());

        // Label's e propriedades
        lblSites = new JLabel("Sites:");
        lblSites.setBounds(new Rectangle(40, 10, 57, 13));
        lblSites.setForeground(Color.red);
        lblSites.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblSites, null);
        lbl83Paraiba = new JLabel("(083) Para�ba:");
        lbl83Paraiba.setBounds(new Rectangle(15, 40, 110, 13));
        lbl83Paraiba.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lbl83Paraiba, null);
        lbl83Borborema = new JLabel("(083) Borborema:");
        lbl83Borborema.setBounds(new Rectangle(15, 65, 110, 13));
        lbl83Borborema.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lbl83Borborema, null);
        lblSergipe = new JLabel("(079) Sergipe:");
        lblSergipe.setFont(new Font("Arial",Font.BOLD,11));
        lblSergipe.setBounds(new Rectangle(15, 90, 100, 13));
        this.getContentPane().add(lblSergipe, null);
        lbl31MinasGerais = new JLabel("(031) Minas Gerais:");
        lbl31MinasGerais.setFont(new Font("Arial",Font.BOLD,11));
        lbl31MinasGerais.setBounds(new Rectangle(15, 115, 115, 13));
        this.getContentPane().add(lbl31MinasGerais, null);
        lbl32MinasGerais = new JLabel("(032) Minas Gerais:");
        lbl32MinasGerais.setFont(new Font("Arial",Font.BOLD,11));
        lbl32MinasGerais.setBounds(new Rectangle(15, 140, 110, 13));
        this.getContentPane().add(lbl32MinasGerais, null);
        lbl33MinasGerais = new JLabel("(033) Minas Gerais:");
        lbl33MinasGerais.setFont(new Font("Arial",Font.BOLD,11));
        lbl33MinasGerais.setBounds(new Rectangle(15, 165, 115, 13));
        this.getContentPane().add(lbl33MinasGerais, null);
        lbl21novaFriburgo = new JLabel("(021) Nova Friburgo:");
        lbl21novaFriburgo.setFont(new Font("Arial",Font.BOLD,11));
        lbl21novaFriburgo.setBounds(new Rectangle(15, 190, 115, 13));
        this.getContentPane().add(lbl21novaFriburgo, null);
        lbl22NovaFriburgo = new JLabel("(022) Nova Friburgo:");
        lbl22NovaFriburgo.setFont(new Font("Arial",Font.BOLD,11));
        lbl22NovaFriburgo.setBounds(new Rectangle(15, 215, 125, 13));
        this.getContentPane().add(lbl22NovaFriburgo, null);
        lbl24NovaFriburgo = new JLabel("(024) Nova Friburgo:");
        lbl24NovaFriburgo.setFont(new Font("Arial",Font.BOLD,11));
        lbl24NovaFriburgo.setBounds(new Rectangle(15, 240, 120, 13));
        this.getContentPane().add(lbl24NovaFriburgo, null);
        lblOperadora = new JLabel("Operadora:");
        lblOperadora.setFont(new Font("Arial",Font.BOLD,11));
        lblOperadora.setBounds(new Rectangle(207, 10, 211, 11));
        lblOperadora.setForeground(Color.red);
        this.getContentPane().add(lblOperadora, null);
        
        //JCOmboBox's da Interface
        jcb83PB = new JComboBox<String> ();
        jcb83PB.setBounds(new Rectangle(173, 35, 130, 20));
        jcb83PB.addItem("012-CTBC");
        jcb83PB.addItem("014-Brasil Telecom");
        jcb83PB.addItem("015-Vivo");
        jcb83PB.addItem("021-Embratel/NET/Claro");
        jcb83PB.addItem("023-Intelig");
        jcb83PB.addItem("025-GVT");
        jcb83PB.addItem("031-Oi");
        jcb83PB.addItem("041-TIM");
        jcb83PB.addItem("043-Sercomtel");
        jcb83PB.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb83PB, null);
        jcb83BO = new JComboBox<String> ();
        jcb83BO.setBounds(new Rectangle(173, 60, 130, 20));
        jcb83BO.addItem("012-CTBC");
        jcb83BO.addItem("014-Brasil Telecom");
        jcb83BO.addItem("015-Vivo");
        jcb83BO.addItem("021-Embratel/NET/Claro");
        jcb83BO.addItem("023-Intelig");
        jcb83BO.addItem("025-GVT");
        jcb83BO.addItem("031-Oi");
        jcb83BO.addItem("041-TIM");
        jcb83BO.addItem("043-Sercomtel");
        jcb83BO.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb83BO, null);
        jcb79SE = new JComboBox<String> ();
        jcb79SE.setBounds(new Rectangle(173, 85, 130, 20));
        jcb79SE.addItem("012-CTBC");
        jcb79SE.addItem("014-Brasil Telecom");
        jcb79SE.addItem("015-Vivo");
        jcb79SE.addItem("021-Embratel/NET/Claro");
        jcb79SE.addItem("023-Intelig");
        jcb79SE.addItem("025-GVT");
        jcb79SE.addItem("031-Oi");
        jcb79SE.addItem("041-TIM");
        jcb79SE.addItem("043-Sercomtel");
        jcb79SE.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb79SE, null);
        jcb31MG = new JComboBox<String> ();
        jcb31MG.setBounds(new Rectangle(173, 110, 130, 20));
        jcb31MG.addItem("012-CTBC");
        jcb31MG.addItem("014-Brasil Telecom");
        jcb31MG.addItem("015-Vivo");
        jcb31MG.addItem("021-Embratel/NET/Claro");
        jcb31MG.addItem("023-Intelig");
        jcb31MG.addItem("025-GVT");
        jcb31MG.addItem("031-Oi");
        jcb31MG.addItem("041-TIM");
        jcb31MG.addItem("043-Sercomtel");
        jcb31MG.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb31MG, null);
        jcb32MG = new JComboBox<String> ();
        jcb32MG.setBounds(new Rectangle(173, 135, 130, 20));
        jcb32MG.addItem("012-CTBC");
        jcb32MG.addItem("014-Brasil Telecom");
        jcb32MG.addItem("015-Vivo");
        jcb32MG.addItem("021-Embratel/NET/Claro");
        jcb32MG.addItem("023-Intelig");
        jcb32MG.addItem("025-GVT");
        jcb32MG.addItem("031-Oi");
        jcb32MG.addItem("041-TIM");
        jcb32MG.addItem("043-Sercomtel");
        jcb32MG.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb32MG, null);
        jcb33MG = new JComboBox<String> ();
        jcb33MG.setBounds(new Rectangle(173, 160, 130, 20));
        jcb33MG.addItem("012-CTBC");
        jcb33MG.addItem("014-Brasil Telecom");
        jcb33MG.addItem("015-Vivo");
        jcb33MG.addItem("021-Embratel/NET/Claro");
        jcb33MG.addItem("023-Intelig");
        jcb33MG.addItem("025-GVT");
        jcb33MG.addItem("031-Oi");
        jcb33MG.addItem("041-TIM");
        jcb33MG.addItem("043-Sercomtel");
        jcb33MG.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb33MG, null);
        jcb21NF = new JComboBox<String> ();
        jcb21NF.setBounds(new Rectangle(173, 185, 130, 20));
        jcb21NF.addItem("012-CTBC");
        jcb21NF.addItem("014-Brasil Telecom");
        jcb21NF.addItem("015-Vivo");
        jcb21NF.addItem("021-Embratel/NET/Claro");
        jcb21NF.addItem("023-Intelig");
        jcb21NF.addItem("025-GVT");
        jcb21NF.addItem("031-Oi");
        jcb21NF.addItem("041-TIM");
        jcb21NF.addItem("043-Sercomtel");
        jcb21NF.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb21NF, null);
        jcb25NF = new JComboBox<String> ();
        jcb25NF.setBounds(new Rectangle(173, 235, 130, 20));
        jcb25NF.addItem("012-CTBC");
        jcb25NF.addItem("014-Brasil Telecom");
        jcb25NF.addItem("015-Vivo");
        jcb25NF.addItem("021-Embratel/NET/Claro");
        jcb25NF.addItem("023-Intelig");
        jcb25NF.addItem("025-GVT");
        jcb25NF.addItem("031-Oi");
        jcb25NF.addItem("041-TIM");
        jcb25NF.addItem("043-Sercomtel");
        jcb25NF.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb25NF, null);
        jcb222NF = new JComboBox<String> ();
        jcb222NF.setBounds(new Rectangle(173, 210, 130, 20));
        jcb222NF.addItem("012-CTBC");
        jcb222NF.addItem("014-Brasil Telecom");
        jcb222NF.addItem("015-Vivo");
        jcb222NF.addItem("021-Embratel/NET/Claro");
        jcb222NF.addItem("023-Intelig");
        jcb222NF.addItem("025-GVT");
        jcb222NF.addItem("031-Oi");
        jcb222NF.addItem("041-TIM");
        jcb222NF.addItem("043-Sercomtel");
        jcb222NF.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(jcb222NF, null);
        btnAplicar = new JButton("Aplicar");
        btnAplicar.setFont(new Font("Arial",Font.BOLD,11));
        btnAplicar.setBounds(new Rectangle(36, 272, 241, 25));
        this.getContentPane().add(btnAplicar, null);
        btnAplicar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String pb83 = jcb83PB.getSelectedItem().toString().substring(0,3);
                String bo83 = jcb83BO.getSelectedItem().toString().substring(0,3);
		        String se79 = jcb79SE.getSelectedItem().toString().substring(0,3);
		        String mg31 = jcb31MG.getSelectedItem().toString().substring(0,3);
		        String mg32 = jcb32MG.getSelectedItem().toString().substring(0,3);
		        String mg33 = jcb33MG.getSelectedItem().toString().substring(0,3);
		        String nf21 = jcb21NF.getSelectedItem().toString().substring(0,3);
		        String nf25 = jcb25NF.getSelectedItem().toString().substring(0,3);
		        String nf222 = jcb222NF.getSelectedItem().toString().substring(0,3);
            	btnAplicar.setVisible(false);
            	if(erro){
            		JOptionPane.showMessageDialog(null, "N�o foi poss�vel carregar esse arquivo.\nSe poss�vel, por favor verifique a sintaxe do mesmo.","Erro!",0);
            	}else{
            		new AlterarXMLOperadoraCallback(pb83,bo83,se79,mg31,mg32,mg33,nf21,nf222,nf25);
            		
            	}

            }
        });
        objeto13 = new JButton();
        loadComboBox();
        objeto13.setBounds(new Rectangle(151, 37, 4, 220));
        this.getContentPane().add(objeto13, null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	new InterfaceWittel2(InterfaceOperadoraCallback.this.privilegio);
            }
        });
        this.setVisible(true);
    }
    
    public void loadComboBox(){
    	try{ 	
			File arquivoXML = new File(ArquivoXML);
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(arquivoXML);
	        Element raiz = doc.getDocumentElement();
	        NodeList pb83 = raiz.getElementsByTagName("PB83");
	        NodeList bo83 = raiz.getElementsByTagName("BO83");
	        NodeList se79 = raiz.getElementsByTagName("SE79");
	        NodeList mg31 = raiz.getElementsByTagName("MG31");
	        NodeList mg32 = raiz.getElementsByTagName("MG32");
	        NodeList mg33 = raiz.getElementsByTagName("MG33");
	        NodeList nf21 = raiz.getElementsByTagName("NF21");
	        NodeList nf22 = raiz.getElementsByTagName("NF22");
	        NodeList nf24 = raiz.getElementsByTagName("NF24");

	        Node PB83= pb83.item(0).getFirstChild();
	        Node BO83= bo83.item(0).getFirstChild();
	        Node SE79= se79.item(0).getFirstChild();
	        Node MG31= mg31.item(0).getFirstChild();
	        Node MG32= mg32.item(0).getFirstChild();
	        Node MG33= mg33.item(0).getFirstChild();
	        Node NF21= nf21.item(0).getFirstChild();
	        Node NF22= nf22.item(0).getFirstChild();
	        Node NF24= nf24.item(0).getFirstChild();
	        
	        for(int i =0 ; i<jcb83PB.getItemCount();i++){if(PB83.getTextContent().equals(jcb83PB.getItemAt(i).substring(0,3))){jcb83PB.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb83BO.getItemCount();i++){if(BO83.getTextContent().equals(jcb83BO.getItemAt(i).substring(0,3))){jcb83BO.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb79SE.getItemCount();i++){if(SE79.getTextContent().equals(jcb79SE.getItemAt(i).substring(0,3))){jcb79SE.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb31MG.getItemCount();i++){if(MG31.getTextContent().equals(jcb31MG.getItemAt(i).substring(0,3))){jcb31MG.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb32MG.getItemCount();i++){if(MG32.getTextContent().equals(jcb32MG.getItemAt(i).substring(0,3))){jcb32MG.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb33MG.getItemCount();i++){if(MG33.getTextContent().equals(jcb33MG.getItemAt(i).substring(0,3))){jcb33MG.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb21NF.getItemCount();i++){if(NF21.getTextContent().equals(jcb21NF.getItemAt(i).substring(0,3))){jcb21NF.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb25NF.getItemCount();i++){if(NF24.getTextContent().equals(jcb25NF.getItemAt(i).substring(0,3))){jcb25NF.setSelectedIndex(i);}}
	        for(int i =0 ; i<jcb222NF.getItemCount();i++){if(NF22.getTextContent().equals(jcb222NF.getItemAt(i).substring(0,3))){jcb222NF.setSelectedIndex(i);}}

	       
    	}catch(ParserConfigurationException | SAXException | IOException |NullPointerException | DOMException e){erro = true;}
    	
    	 
    }
    
    
}