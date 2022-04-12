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

public class InterfaceDefiniPrioridades extends JDialog {

    //Vari�veis da Janela
    private JComboBox<String> comboBO,comboMG,comboSE,comboPB,comboNF;
    private JLabel lblPB,lblBO,lblSE,lblMG,lblNF,lblLegenda,lblLegendaI,lblLegendaII,lblDesativar,lblEnergia,lblDebitos,lblRenda,lblReclamacoes,objeto13,lblAtendimento;
    private JButton btnAplicar, btnDiv;
    private String privilegio, ArquivoXML;
	private static final long serialVersionUID = 1L;
	private boolean erro;

	public InterfaceDefiniPrioridades(String xml, String privilegioDoUsuario) {
        // Bloco 2 - Dados da Cria��o da Janela
		privilegio = privilegioDoUsuario;
		ArquivoXML = xml;
  	  	ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(334, 247));
        this.setLocation((screenSize.width-334)/2,(screenSize.height-247)/2);
        this.setTitle("Defini��o de Prioridades");
        this.setResizable(false);
		
        // Bloco 3 - Dados da Cria��o dos Controles na Janela
        comboBO = new JComboBox<String>();
        comboBO.addItem("0");
        comboBO.addItem("1");
        comboBO.addItem("2");
        comboBO.addItem("4");
        comboBO.addItem("6");
        comboBO.addItem("7");
        comboBO.addItem("9");
        comboBO.setBounds(new Rectangle(250, 84, 57, 20));
        this.getContentPane().add(comboBO, null);
        comboMG = new JComboBox<String>();
        comboMG.addItem("0");
        comboMG.addItem("1");
        comboMG.addItem("2");
        comboMG.addItem("4");
        comboMG.addItem("6");
        comboMG.addItem("7");
        comboMG.addItem("9");
        comboMG.setBounds(new Rectangle(250, 152, 57, 20));
        this.getContentPane().add(comboMG, null);
        comboSE = new JComboBox<String>();
        comboSE.addItem("0");
        comboSE.addItem("1");
        comboSE.addItem("2");
        comboSE.addItem("4");
        comboSE.addItem("6");
        comboSE.addItem("7");
        comboSE.addItem("9");
        comboSE.setBounds(new Rectangle(250, 118, 57, 20));
        this.getContentPane().add(comboSE, null);
        comboPB = new JComboBox<String>();
        comboPB.addItem("0");
        comboPB.addItem("1");
        comboPB.addItem("2");
        comboPB.addItem("4");
        comboPB.addItem("6");
        comboPB.addItem("7");
        comboPB.addItem("9");
        comboPB.setBounds(new Rectangle(250, 50, 57, 20));
        this.getContentPane().add(comboPB, null);
        comboNF = new JComboBox<String>();
        comboNF.addItem("0");
        comboNF.addItem("1");
        comboNF.addItem("2");
        comboNF.addItem("4");
        comboNF.addItem("6");
        comboNF.addItem("7");
        comboNF.addItem("9");
        comboNF.setBounds(new Rectangle(250, 186, 57, 20));
        this.getContentPane().add(comboNF, null);
        lblLegenda = new JLabel("Legenda:");
        lblLegenda.setBounds(new Rectangle(5, 5, 57, 13));
        lblLegenda.setForeground(Color.red);
        lblLegenda.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblLegenda, null);
        lblLegendaI = new JLabel("Defina a prioridade de atendimento dos sites");
        lblLegendaI.setBounds(new Rectangle(68, 5, 500, 13));
        lblLegendaI.setForeground(Color.gray);
        lblLegendaI.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblLegendaI, null);
        lblLegendaII = new JLabel("de acordo com as informa��es em destaque abaixo:");
        lblLegendaII.setBounds(new Rectangle(5, 25, 500, 13));
        lblLegendaII.setForeground(Color.gray);
        lblLegendaII.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblLegendaII, null);
        lblDesativar = new JLabel("Desativar = 0");
        lblDesativar.setBounds(new Rectangle(10, 50, 90, 13));
        lblDesativar.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblDesativar, null);
        lblEnergia = new JLabel("Falta de Energia = 1");
        lblEnergia.setBounds(new Rectangle(10, 65, 120, 13));
        lblEnergia.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblEnergia, null);
        lblDebitos = new JLabel("Consulta D�bitos = 2");
        lblDebitos.setFont(new Font("Arial",Font.BOLD,11));
        lblDebitos.setBounds(new Rectangle(10, 80, 130, 13));
        this.getContentPane().add(lblDebitos, null);
        lblRenda = new JLabel("Baixa Renda = 4");
        lblRenda.setFont(new Font("Arial",Font.BOLD,11));
        lblRenda.setBounds(new Rectangle(10, 95, 120, 13));
        this.getContentPane().add(lblRenda, null);
        lblReclamacoes = new JLabel("Reclama��es = 6");
        lblReclamacoes.setFont(new Font("Arial",Font.BOLD,11));
        lblReclamacoes.setBounds(new Rectangle(10, 110, 120, 13));
        this.getContentPane().add(lblReclamacoes, null);
        objeto13 = new JLabel("Cancelamento = 7");
        objeto13.setBounds(new Rectangle(10, 125, 120, 13));
        objeto13.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(objeto13, null);
        lblAtendimento = new JLabel("Atendimento = 9");
        lblAtendimento.setFont(new Font("Arial",Font.BOLD,11));
        lblAtendimento.setBounds(new Rectangle(10, 140, 120, 13));
        this.getContentPane().add(lblAtendimento, null);
        btnAplicar = new JButton("Aplicar Altera��es");
        btnAplicar.setFont(new Font("Arial",Font.BOLD,11));
        btnAplicar.setBounds(new Rectangle(14, 175, 179, 30));
        this.getContentPane().add(btnAplicar, null);
        try{
        	loadData();
        }catch(Exception e){
        	erro = true;
        }
        btnAplicar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
          	  String PB = comboPB.getSelectedItem().toString();
          	  String BO = comboBO.getSelectedItem().toString();
          	  String SE = comboSE.getSelectedItem().toString(); 
          	  String MG = comboMG.getSelectedItem().toString();
          	  String NF = comboNF.getSelectedItem().toString();
          	  
          	 if(erro){
        		 JOptionPane.showMessageDialog(null, "N�o foi poss�vel carregar o arquivo XML.\nVerifique a sintaxe do arquivo.","Falha no carregamento do XML",0);
           		 setVisible(false);
           		 new InterfaceWittel2(privilegio);
          	 }else{
          		 new AlterarXMLDefiniPrioridades(PB, BO, SE, MG, NF);
                 btnAplicar.setVisible(false);
          	 }
            }
        });
        lblPB = new JLabel("PB:");
        lblPB.setBounds(new Rectangle(220, 53, 57, 13));
        lblPB.setFont(new Font("Arial",Font.BOLD,11));
        this.getContentPane().add(lblPB, null);
        lblBO = new JLabel("BO:");
        lblBO.setFont(new Font("Arial",Font.BOLD,11));
        lblBO.setBounds(new Rectangle(220, 87, 57, 13));
        this.getContentPane().add(lblBO, null);
        lblSE = new JLabel("SE:");
        lblSE.setFont(new Font("Arial",Font.BOLD,11));
        lblSE.setBounds(new Rectangle(220, 121, 57, 13));
        this.getContentPane().add(lblSE, null);
        lblMG = new JLabel("MG:");
        lblMG.setFont(new Font("Arial",Font.BOLD,11));
        lblMG.setBounds(new Rectangle(220, 155, 57, 13));
        this.getContentPane().add(lblMG, null);
        lblNF = new JLabel("NF:");
        lblNF.setFont(new Font("Arial",Font.BOLD,11));
        lblNF.setBounds(new Rectangle(220, 189, 57, 13));
        this.getContentPane().add(lblNF, null);
        btnDiv = new JButton();
        btnDiv.setBounds(new Rectangle(169, 57, 3, 104));
        this.getContentPane().add(btnDiv, null);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new InterfaceWittel2(privilegio);
            }
        });
        this.setVisible(true);
    }

    
    public void loadData(){
    	
    	try{ 	
    		
			File arquivoXML = new File(ArquivoXML);
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(arquivoXML);
	        Element raiz = doc.getDocumentElement();
	        NodeList pb = raiz.getElementsByTagName("PB");
	        NodeList bo = raiz.getElementsByTagName("BO");
	        NodeList se = raiz.getElementsByTagName("SE");
	        NodeList mg = raiz.getElementsByTagName("MG");
	        NodeList nf = raiz.getElementsByTagName("NF");

	        Node PB	 = pb.item(0).getFirstChild();
	        Node BO	 = bo.item(0).getFirstChild();
	        Node SE	 = se.item(0).getFirstChild();
	        Node MG	 = mg.item(0).getFirstChild();
	        Node NF	 = nf.item(0).getFirstChild();
	        
	        if(PB.getTextContent().equals("0")){
	        	comboPB.setSelectedIndex(0);
	        }else if(PB.getTextContent().equals("1")){
	        	comboPB.setSelectedIndex(1);
	        }else if(PB.getTextContent().equals("2")){
	        	comboPB.setSelectedIndex(2);
	        }else if(PB.getTextContent().equals("4")){
	        	comboPB.setSelectedIndex(3);
	        }else if(PB.getTextContent().equals("6")){
	        	comboPB.setSelectedIndex(4);
	        }else if(PB.getTextContent().equals("7")){
	        	comboPB.setSelectedIndex(5);
	        }else if(PB.getTextContent().equals("9")){
	        	comboPB.setSelectedIndex(6);
	        }
	        
	        if(BO.getTextContent().equals("0")){
	        	comboBO.setSelectedIndex(0);
	        }else if(BO.getTextContent().equals("1")){
	        	comboBO.setSelectedIndex(1);
	        }else if(BO.getTextContent().equals("2")){
	        	comboBO.setSelectedIndex(2);
	        }else if(BO.getTextContent().equals("4")){
	        	comboBO.setSelectedIndex(3);
	        }else if(BO.getTextContent().equals("6")){
	        	comboBO.setSelectedIndex(4);
	        }else if(BO.getTextContent().equals("7")){
	        	comboBO.setSelectedIndex(5);
	        }else if(BO.getTextContent().equals("9")){
	        	comboBO.setSelectedIndex(6);
	        }
	        
	        if(SE.getTextContent().equals("0")){
	        	comboSE.setSelectedIndex(0);
	        }else if(SE.getTextContent().equals("1")){
	        	comboSE.setSelectedIndex(1);
	        }else if(SE.getTextContent().equals("2")){
	        	comboSE.setSelectedIndex(2);
	        }else if(SE.getTextContent().equals("4")){
	        	comboSE.setSelectedIndex(3);
	        }else if(SE.getTextContent().equals("6")){
	        	comboSE.setSelectedIndex(4);
	        }else if(SE.getTextContent().equals("7")){
	        	comboSE.setSelectedIndex(5);
	        }else if(SE.getTextContent().equals("9")){
	        	comboSE.setSelectedIndex(6);
	        }
	        
	        if(MG.getTextContent().equals("0")){
	        	comboMG.setSelectedIndex(0);
	        }else if(MG.getTextContent().equals("1")){
	        	comboMG.setSelectedIndex(1);
	        }else if(MG.getTextContent().equals("2")){
	        	comboMG.setSelectedIndex(2);
	        }else if(MG.getTextContent().equals("4")){
	        	comboMG.setSelectedIndex(3);
	        }else if(MG.getTextContent().equals("6")){
	        	comboMG.setSelectedIndex(4);
	        }else if(MG.getTextContent().equals("7")){
	        	comboMG.setSelectedIndex(5);
	        }else if(MG.getTextContent().equals("9")){
	        	comboMG.setSelectedIndex(6);
	        }
	        
	        if(NF.getTextContent().equals("0")){
	        	comboNF.setSelectedIndex(0);
	        }else if(NF.getTextContent().equals("1")){
	        	comboNF.setSelectedIndex(1);
	        }else if(NF.getTextContent().equals("2")){
	        	comboNF.setSelectedIndex(2);
	        }else if(NF.getTextContent().equals("4")){
	        	comboNF.setSelectedIndex(3);
	        }else if(NF.getTextContent().equals("6")){
	        	comboNF.setSelectedIndex(4);
	        }else if(NF.getTextContent().equals("7")){
	        	comboNF.setSelectedIndex(5);
	        }else if(NF.getTextContent().equals("9")){
	        	comboNF.setSelectedIndex(6);
	        }
	        
    	}catch(ParserConfigurationException | SAXException | IOException | DOMException e){erro = true;}
    	
    }
    
}