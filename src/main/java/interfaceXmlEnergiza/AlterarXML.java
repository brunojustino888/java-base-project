package interfaceXmlEnergiza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*	
* Essa classe � respons�vel por fazer as altera��es nos arquivos:
* Callback_BO.xml
* Callback_PB.xml
* Callback_SE.xml
* Callback_MG.xml
* Callback_NF.xml 
*/
public class AlterarXML {
	
	private String ArquivoXML;
	
	//O construtor dessa classe recebe como par�metro o caminho do arquivo, o id do elemento que ser� incluso, 
	//condi��o para expediente, hora do inicio  da opera��o, e hora do fim da opera��o.
	public AlterarXML(String file, String sid,String trabalha, String inicio, String fim){	
			writeOnlyLnXML(file, sid, trabalha, inicio, fim);
	}
	
	//M�todo respons�vel por varrer o xml a procura do elemento que ser� incluso no xml.
	//Caso encontre um elemento com o mesmo id do xml, ele retornar� true para que o usu�rio n�o inclua uma tag j� existente
	public boolean tagJaExistente(String file, String sid, String trabalha, String inicio, String fim){
		try {
            File fileXML = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(fileXML);            
            org.w3c.dom.Element raiz = doc.getDocumentElement();           
            NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
	            for(int i=0;i<=nodeDataFeriado.getLength()-1;i++){
	            	Element dataFeriado = (Element) nodeDataFeriado.item(i);
	            	Attr id =  dataFeriado.getAttributeNode("id");
	        	    if(sid.equals(id.getValue())){
	        	    	return true;
	        	    }
	            } 
            }catch(ParserConfigurationException | SAXException | IOException | DOMException e) {JOptionPane.showMessageDialog(null, "M�todo: loadArray()","Alerta!",0);}
		return false;
	}


	//M�todo respons�vel por retornar um arraylist com todos os elementos que ser�o inclusos no arquivo xml.
	public ArrayList<BusinessHours> incluirNode(String file, String sid,String trabalha, String inicio, String fim){
		ArrayList<BusinessHours> array = new ArrayList<BusinessHours>();
        try {
            File fileXML = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(fileXML);            
            org.w3c.dom.Element raiz = doc.getDocumentElement();           
            NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
            for(int i=0;i<=nodeDataFeriado.getLength()-1;i++){
            	Element dataFeriado = (Element) nodeDataFeriado.item(i);
            	Attr id =  dataFeriado.getAttributeNode("id");
            	NodeList listadia   = dataFeriado.getElementsByTagName("dia");
            	NodeList listahoraI = dataFeriado.getElementsByTagName("hora_inicial");
            	NodeList listahoraF = dataFeriado.getElementsByTagName("hora_final");
        	    Node nodedia = listadia.item(0).getFirstChild();
        	    Node nodeI 	 = listahoraI.item(0).getFirstChild();
        	    Node nodeF   = listahoraF.item(0).getFirstChild();
            	String sID =  id.toString();
            	sID = sID.toString();
            	sID = sID.replace("id=", "");
            	sID = sID.replace("\"", "");	
            	array.add(new BusinessHours( id.getNodeValue().toString(), nodedia.getNodeValue().toString(), nodeI.getNodeValue().toString(), nodeF.getNodeValue().toString()));
            }      
            BusinessHours incluir = new BusinessHours(sid, trabalha, inicio, fim);
            array.add(incluir);
	            try {
					criaXML(file,array);
				} catch (XMLStreamException	| TransformerException e) {
					JOptionPane.showMessageDialog(null, "Deu problema ao chamar o m�todo ");
				}
            }catch(ParserConfigurationException | SAXException | IOException | DOMException e) {JOptionPane.showMessageDialog(null, "M�todo: loadArray()","Alerta!",0);}
        return array;
	}
	
	//Esse m�todo vai criar o arquivo xml fisicamente no sistema. Ele tamb�m verifica a exist�ncia do tal arquivo e o exclu� caso exista.
	private void criaXML(String caminhoXML, ArrayList <BusinessHours> array4XML) throws XMLStreamException, FileNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
		XMLOutputFactory factory = XMLOutputFactory.newFactory();        
        FileOutputStream fos = new FileOutputStream(caminhoXML, false);
        XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
        File arquivo = new File(caminhoXML);
        if(arquivo.exists()){
            arquivo.delete();
        }      
        escreveXML(writer, array4XML);
        writer.close();
     }

	//M�todo respons�vel por escrever no XML criado. Esse m�todo recebe como par�metro um arraylist que cont�m todos elementos existentes no xml + os elementos que foram inclusos pelo usu�rio.
	public void escreveXML(XMLStreamWriter writer, ArrayList <BusinessHours> array4XML){
		try {
            writer.writeStartDocument();
	        writer.writeCharacters("\n");
	        writer.writeStartElement("datas");
	        writer.writeCharacters("\n");
	        for(BusinessHours valor : array4XML) {
	            writer.writeCharacters("\t");
	            writer.writeStartElement("data");
	            writer.writeAttribute("id", String.valueOf(valor.getData()));
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("dia");
	            writer.writeCharacters(valor.getDia());
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("hora_inicial");
	            writer.writeCharacters(valor.getHoraInicial());
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("hora_final");
	            writer.writeCharacters(valor.getHoraFinal());
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t");
	            writer.writeEndElement();
	            writer.writeCharacters("\n");
	        }
		        writer.writeEndElement();
		        writer.writeEndDocument();
		        writer.flush();
		        writer.close();
		        System.gc();
		        criarArquivoDeLog();
	    }catch (XMLStreamException e) {JOptionPane.showMessageDialog(null, "M�todo: escreveXML()","Alerta!",0);  }
		
	}

	//M�todo respons�vel por carregar um arraylist com todos os elementos que ser�o inclusos no arquivo xml.
	public ArrayList<BusinessHours> writeOnlyLnXML(String file, String sid,String trabalha, String inicio, String fim){
		ArrayList<BusinessHours> array = new ArrayList<BusinessHours>();
        try {
        	ArquivoXML = file;
            File fileXML = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(fileXML);            
            org.w3c.dom.Element raiz = doc.getDocumentElement();           
            NodeList nodeDataFeriado = raiz.getElementsByTagName("data");
            for(int i=0;i<=nodeDataFeriado.getLength()-1;i++){
            	Element dataFeriado = (Element) nodeDataFeriado.item(i);
            	Attr id =  dataFeriado.getAttributeNode("id");
            	NodeList listadia   = dataFeriado.getElementsByTagName("dia");
            	NodeList listahoraI = dataFeriado.getElementsByTagName("hora_inicial");
            	NodeList listahoraF = dataFeriado.getElementsByTagName("hora_final");
        	    Node nodedia = listadia.item(0).getFirstChild();
        	    Node nodeI 	 = listahoraI.item(0).getFirstChild();
        	    Node nodeF   = listahoraF.item(0).getFirstChild();
            	String sID =  id.toString();
            	sID = sID.toString();
            	sID = sID.replace("id=", "");
            	sID = sID.replace("\"", "");	
            	if(sid.equals(id.getNodeValue().toString())){        		
            	}else{
            	array.add(new BusinessHours( id.getNodeValue().toString(), nodedia.getNodeValue().toString(), nodeI.getNodeValue().toString(), nodeF.getNodeValue().toString()));
            	}
            }      
            BusinessHours incluir = new BusinessHours(sid, trabalha, inicio, fim);
            array.add(incluir);
	            try {
					criaXML(file,array);
				} catch (XMLStreamException	| TransformerException e) {
					JOptionPane.showMessageDialog(null, "Deu problema ao chamar o m�todo que somente altera","Erro!",0);
				}
            }catch(ParserConfigurationException | SAXException | IOException | DOMException e) {JOptionPane.showMessageDialog(null, "M�todo: loadArray()","Alerta!",0);}
        return array;
	}
	
	//M�todo respons�vel por logar a altera��o realizada.
    public void criarArquivoDeLog(){
		try {
			FileWriter fw = new FileWriter("X:\\Application4XML.log",true);
			BufferedWriter bw = new BufferedWriter(fw);  
			PrintWriter pw = new PrintWriter(bw); 
			pw.write(" -- Altera��o no arquivo XML "+ArquivoXML);
			fw.flush();
			bw.flush();
			pw.flush();
			pw.close(); 
			fw.close(); 
			bw.close();
		}catch(IOException e){JOptionPane.showMessageDialog(null, "Problemas ao criar o arquivo de log da aplica��o! (M�todo criarArquivoDeLog())","ERRO!",0);}    	
    }
    
}
