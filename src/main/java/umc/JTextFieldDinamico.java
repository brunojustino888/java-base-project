package umc;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;  
import java.util.List;  

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;  
import javax.swing.JTextField;  
import javax.swing.LookAndFeel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

  
  
public class JTextFieldDinamico extends JFrame {  
	
	private String nomeXML;
	private int iQuantidadeDosTextFields;
    List<JTextField> lista = new ArrayList<JTextField>();  
    private JTextField aux = new JTextField();  
    private javax.swing.JButton btnOK;  
    private JLabel lblGuide;
    
    public JTextFieldDinamico() {   
    	
        btnOK = new javax.swing.JButton(); 
        btnOK.setText("SALVAR");  
        lblGuide = new JLabel();
        lblGuide.setText("Ap�s editar os campos abaixo, clique em SALVAR para aplicar as altera��es.");
        lblGuide.setHorizontalAlignment(SwingConstants.CENTER); 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.getContentPane().setBackground(new Color(103, 151, 225));
        quantidadeDosJTextFields();
        this.setTitle("Swing Wittel - Arquivo: "+ nomeXML);
        
        this.setLocation((screenSize.width-800)/2,(screenSize.height-600)/2);  
        this.setSize(800,600);  
        this.setLayout(new GridLayout(0,1,8,8));
        
        this.add(lblGuide);
        this.add(btnOK);
        
        for(int i =0;i<=(iQuantidadeDosTextFields-1);i++){  
        	aux = new JTextField();
        	aux.setSize(80, 60);
        	lista.add(aux);  
            this.add(lista.get(i));  
            
        }  
    }  
        
	public int quantidadeDosJTextFields(){
		try {
	        File filexml = new File("D:\\3891.xml");
	        nomeXML = "3891.xml";
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(filexml);
	        Element raiz = doc.getDocumentElement();
	        NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
	        iQuantidadeDosTextFields = nodeDataFeriado.getLength();
	       	} catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
	             System.out.println(e);
	        }
		return iQuantidadeDosTextFields;
	}
    
    public static void main(String args[]) {  
  
    	//try {UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");}catch(Exception e){e.printStackTrace();}
    	JTextFieldDinamico dialog = new JTextFieldDinamico();  
        dialog.setVisible(true);  
    
    }  

}  