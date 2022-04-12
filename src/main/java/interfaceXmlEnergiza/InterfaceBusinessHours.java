package interfaceXmlEnergiza;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InterfaceBusinessHours extends JDialog {
	
	//Atributos da Classe
	private static final long serialVersionUID = 1L;
    private JLabel lblInicio,lblTermino,lblTrabalha,lblData;
    private JComboBox<String> comboData;
    private JTextField jtfInicio,jtfTermino;
    private JCheckBox checkTrabalha;
    private JButton btnNovoFeriado,objeto13,btnAplicar;
    private String ArquivoXML, privilegio;
    private boolean erro;
    
    //Construtor
    public InterfaceBusinessHours(String xml, String privilegioDoUsuario) {
    	privilegio = privilegioDoUsuario;
    	ArquivoXML = xml;
    	ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
        this.setIconImage(wittelIcon.getImage());
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(260, 198));
        this.setLocation((screenSize.width-260)/2,(screenSize.height-198)/2);
        this.setTitle("XML Callback");
        this.setResizable(false);
        lblInicio = new JLabel("In�cio:");
        lblInicio.setBounds(new Rectangle(5, 30, 40, 13));
        lblInicio.setFont(new Font("Arial", Font.BOLD,11));
        this.getContentPane().add(lblInicio, null);
        lblTermino = new JLabel("Termino:");
        lblTermino.setFont(new Font("Arial", Font.BOLD,11));
        lblTermino.setBounds(new Rectangle(5, 55, 58, 13));
        this.getContentPane().add(lblTermino, null);
        lblTrabalha = new JLabel("Trabalha:");
        lblTrabalha.setFont(new Font("Arial", Font.BOLD,11));
        lblTrabalha.setBounds(new Rectangle(5, 80, 60, 13));
        this.getContentPane().add(lblTrabalha, null);
        lblData = new JLabel("Data:");
        lblData.setFont(new Font("Arial", Font.BOLD,11));
        lblData.setBounds(new Rectangle(5, 5, 40, 13));
        this.getContentPane().add(lblData, null);
        comboData = new JComboBox<String>();
        comboData.setBounds(new Rectangle(70, 2, 150, 20));
        this.getContentPane().add(comboData, null);
        comboData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	loadComboBox();
           }
        });
        jtfInicio = new JTextField();
        jtfInicio.setBounds(new Rectangle(70, 26, 57, 21));
        this.getContentPane().add(jtfInicio, null);
        jtfTermino = new JTextField();
        jtfTermino.setBounds(new Rectangle(70, 50, 57, 21));
        this.getContentPane().add(jtfTermino, null);
        checkTrabalha = new JCheckBox();
        checkTrabalha.setBounds(new Rectangle(68, 75, 22, 25));
        this.getContentPane().add(checkTrabalha, null);
        
        try{
        	preencherComboBox();
        	if(comboData.getItemAt(0).equals("")){
        		erro = true;
        	}
        }catch(NullPointerException e){
        		erro = true;
        }
        
        

        btnNovoFeriado = new JButton("Novo Feriado");
        btnNovoFeriado.setBounds(new Rectangle(138, 38, 109, 50));
        btnNovoFeriado.setFont(new Font("Arial", Font.BOLD,11));
        this.getContentPane().add(btnNovoFeriado, null);
        btnNovoFeriado.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(erro){
              		 JOptionPane.showMessageDialog(null, "N�o foi poss�vel carregar o arquivo XML.\nVerifique a sintaxe do arquivo.","Falha no carregamento do XML",0);
              		 setVisible(false);
              		 new InterfaceWittel2(privilegio);
              	}else{
              	  	setVisible(false);
                    new CadastraNovoFeriado(ArquivoXML,privilegio);
              	}
          
            }
        });
        objeto13 = new JButton();
        objeto13.setBounds(new Rectangle(4, 106, 246, 8));
        this.getContentPane().add(objeto13, null);
        btnAplicar = new JButton("Aplicar");
        btnAplicar.setFont(new Font("Arial", Font.BOLD,11));
        btnAplicar.setBounds(new Rectangle(79, 126, 100, 30));
        this.getContentPane().add(btnAplicar, null);
        btnAplicar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            if(erro){
       		 JOptionPane.showMessageDialog(null, "N�o foi poss�vel carregar o arquivo XML.\nVerifique a sintaxe do arquivo.","Falha no carregamento do XML",0);
       		 setVisible(false);
       		 new InterfaceWittel2(privilegio);
            }else{
            	if(jtfInicio.getText().equals("")||jtfTermino.getText().equals("")){
   					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.","Opera��o n�o realizada!",0);
   				}else{
   				 new AlterarXML(ArquivoXML,comboData.getSelectedItem().toString(),String.valueOf(checkTrabalha.isSelected()),jtfInicio.getText(),jtfTermino.getText());
   				 setVisible(false);
   				 new InterfaceWittel2(privilegio);
   				}
            	
            }	
            	
            }
        });
        
        
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new InterfaceWittel2(privilegio);
            }
        });
        this.setVisible(true);
    }
    
    
    //M�todo usado para preencher SOMENTE os itens do ComboBox assim que � carregado o XML.
    public void preencherComboBox(){
    	try {
  	         File arquivoXML = new File(ArquivoXML);
  	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  	         DocumentBuilder db = dbf.newDocumentBuilder();
  	         Document doc = db.parse(arquivoXML);
  	         Element raiz = doc.getDocumentElement();
  	         NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
  	         for(int i=0;i<nodeDataFeriado.getLength();i++){
  	             Element dataFeriado = (Element) nodeDataFeriado.item(i);
  	             Attr id =  dataFeriado.getAttributeNode("id");      
  	             comboData.addItem((String) id.getNodeValue()); 
  	         }
  	     } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {}
    }
    
    
    
    
    
    //M�todo usado para atualizar as informa��es na tela ao selecionar outro item do comboBox.
    public void loadComboBox(){
 		String sDataId = comboData.getSelectedItem().toString();
 		
		try{ 	
			File arquivoXML = new File(ArquivoXML);
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(arquivoXML);
	        Element raiz = doc.getDocumentElement();
	        NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
        
	        	for(int i=0;i<nodeDataFeriado.getLength();i++){
			    	
	        		Element dataFeriado = (Element) nodeDataFeriado.item(i);
			    	Attr date =  dataFeriado.getAttributeNode("id"); 
			    	String sHolidayProcurado =  date.toString();
			    	
			    	sHolidayProcurado = sHolidayProcurado.replace("id=\"", "");
			    	sHolidayProcurado = sHolidayProcurado.replace("\"", "");
			
			    	NodeList listaDia = 	dataFeriado.getElementsByTagName("dia");
			    	NodeList listaI	  =		dataFeriado.getElementsByTagName("hora_inicial");
			    	NodeList listaF   =	 	dataFeriado.getElementsByTagName("hora_final");
			    	
				    Node nodeDia	 = 	   listaDia.item(0).getFirstChild();
				    Node nodeListaI	 =	   listaI.item(0).getFirstChild();
				    Node nodeListaF  = 	   listaF.item(0).getFirstChild();
			 
				    if(sDataId.equals(sHolidayProcurado)){
			    		jtfInicio.setText(nodeListaI.getTextContent());
			 			jtfTermino.setText(nodeListaF.getTextContent());
			 			if(nodeDia.getTextContent().equals("true")){
			 				checkTrabalha.setSelected(true);
			 			}else {
			 				checkTrabalha.setSelected(false);
			 			}
				    }
				}
		}catch(ParserConfigurationException | SAXException | IOException | DOMException e) {erro = true;}
 	} 
    
}