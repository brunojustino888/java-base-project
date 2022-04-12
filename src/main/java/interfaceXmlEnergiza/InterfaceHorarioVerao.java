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

public class InterfaceHorarioVerao extends JDialog {
	
	// Atributos privados da classe. 
	private static final long serialVersionUID = 1L;
    private JCheckBox checkSE, checkPB, checkBO, checkNF, checkMG;
    private JLabel lblPB, lblBO, lblSE, lblMG, lblNF, lblExemploI, lblExemploII, lblExemploIII;
    private JButton btnAplicar;
    private String privilegio, ArquivoXML;
    private boolean erro;
    
    public InterfaceHorarioVerao(String xml, String privilegioDoUsuario) {
          //Propriedades e configura��es da janela
    	  privilegio = privilegioDoUsuario;
    	  ArquivoXML = xml;
    	  ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
          this.setIconImage(wittelIcon.getImage());
    	  this.getContentPane().setLayout(null);
          this.getContentPane().setBackground(new Color(255, 255, 255));
          java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
          this.setSize(new java.awt.Dimension(265, 212));
          this.setLocation((screenSize.width-255)/2,(screenSize.height-212)/2);
          this.setTitle("Hor�rio de Ver�o");
          this.setResizable(false);
    	
          //Controles na Janela
          lblExemploI = new JLabel("Legenda:");
          lblExemploI.setBounds(new Rectangle(100, 9, 57, 13));
          lblExemploI.setForeground(Color.RED);
          lblExemploI.setFont(new Font("Arial",Font.BOLD,11));
          this.getContentPane().add(lblExemploI, null);
          lblExemploII = new JLabel("ON  = Hor�rio de ver�o desativado.");
          lblExemploII.setBounds(new Rectangle(15, 31, 230, 13));
          lblExemploII.setForeground(Color.gray);
          lblExemploII.setFont(new Font("Arial",Font.BOLD,11));
          this.getContentPane().add(lblExemploII, null);
          lblExemploIII = new JLabel("OFF = Hor�rio de ver�o ativado.");
          lblExemploIII.setBounds(new Rectangle(15, 48, 251, 13));
          lblExemploIII.setForeground(Color.gray);
          lblExemploIII.setFont(new Font("Arial",Font.BOLD,11));
          this.getContentPane().add(lblExemploIII, null);
          checkNF = new JCheckBox();
          checkNF.setBounds(new Rectangle(215, 105, 21, 30));
          this.getContentPane().add(checkNF, null);
          checkMG = new JCheckBox();
          checkMG.setBounds(new Rectangle(15, 105, 21, 30));
          this.getContentPane().add(checkMG, null);
          checkSE = new JCheckBox();
          checkSE.setBounds(new Rectangle(165, 105, 23, 30));
          this.getContentPane().add(checkSE, null);
          checkPB = new JCheckBox();
          checkPB.setBounds(new Rectangle(65, 105, 21, 30));
          this.getContentPane().add(checkPB, null);
          checkBO = new JCheckBox();
          checkBO.setBounds(new Rectangle(115, 105, 20, 30));
          this.getContentPane().add(checkBO, null);
          lblNF = new JLabel("NF:");
          lblNF.setFont(new Font("Arial",Font.BOLD,11));
          lblNF.setBounds(new Rectangle(220, 88, 30, 13));
          this.getContentPane().add(lblNF, null);
          lblPB = new JLabel("PB:");
          lblPB.setFont(new Font("Arial",Font.BOLD,11));
          lblPB.setBounds(new Rectangle(70, 88, 30, 13));
          this.getContentPane().add(lblPB, null);
          lblBO = new JLabel("BO:");
          lblBO.setFont(new Font("Arial",Font.BOLD,11));
          lblBO.setBounds(new Rectangle(120, 88, 27, 13));
          this.getContentPane().add(lblBO, null);
          lblSE = new JLabel("SE:");
          lblSE.setFont(new Font("Arial",Font.BOLD,11));
          lblSE.setBounds(new Rectangle(170, 88, 81, 13));
          this.getContentPane().add(lblSE, null);
          lblMG = new JLabel("MG:");
          lblMG.setFont(new Font("Arial",Font.BOLD,11));
          lblMG.setBounds(new Rectangle(18, 88, 30, 13));
          this.getContentPane().add(lblMG, null);
          try{
        	  loadCheckBox2();
          }catch(Exception  w){
        	  erro = true;
          }
         
          btnAplicar = new JButton("Aplicar");
          btnAplicar.setBounds(new Rectangle(82, 143, 90, 24));
          btnAplicar.setFont(new Font("Arial",Font.BOLD,11));
          this.getContentPane().add(btnAplicar, null);
          btnAplicar.addActionListener (new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	 

            	  String PB = ""; String BO = ""; String SE = ""; String MG = "";String NF = "";
            	  
            	  if(checkPB.isSelected()){PB = "1";}else{PB = "0";}
            	  if(checkBO.isSelected()){BO = "1";}else{BO = "0";}
            	  if(checkSE.isSelected()){SE = "1";}else{SE = "0";}
            	  if(checkMG.isSelected()){MG = "1";}else{MG = "0";}
            	  if(checkNF.isSelected()){NF = "1";}else{NF = "0";}

            	 if(erro){
            		 JOptionPane.showMessageDialog(null, "N�o foi poss�vel carregar o arquivo XML.\nVerifique a sintaxe do arquivo.","Falha no carregamento do XML",0);
               		 setVisible(false);
               		 new InterfaceWittel2(privilegio);
            	 }else{
                  new AlterarXMLHorarioVerao(PB, BO, SE, MG, NF);
                  btnAplicar.setVisible(false);
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

    
    public void loadCheckBox2(){
    	
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
	              
	        if(PB.getTextContent().equals("1")){checkPB.setSelected(true);}else{checkPB.setSelected(false);}
	        if(BO.getTextContent().equals("1")){checkBO.setSelected(true);}else{checkBO.setSelected(false);}
	        if(SE.getTextContent().equals("1")){checkSE.setSelected(true);}else{checkSE.setSelected(false);}
	        if(MG.getTextContent().equals("1")){checkMG.setSelected(true);}else{checkMG.setSelected(false);}
	        if(NF.getTextContent().equals("1")){checkNF.setSelected(true);}else{checkNF.setSelected(false);}
	        
    	}catch(ParserConfigurationException | SAXException | IOException | DOMException e){}
    	erro = true;
    }
    
    
}