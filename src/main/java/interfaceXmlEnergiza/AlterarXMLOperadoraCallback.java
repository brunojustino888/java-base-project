package interfaceXmlEnergiza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class AlterarXMLOperadoraCallback {

	public AlterarXMLOperadoraCallback(String PB83,String BO83,String SE79,String MG31,String MG32,String MG33,String NF21,String NF22,String NF24){
		OperadoraCallback referencia = new OperadoraCallback(PB83, BO83, SE79, MG31, MG32, MG33, NF21, NF22, NF24);
		preparaXML(referencia);
	}
	
	
	
	    //M�todo respons�vel por preparar a classe que ser� transformada em XML.
		public void preparaXML(OperadoraCallback referencia){
			
			XMLOutputFactory factory = XMLOutputFactory.newFactory();        
	        FileOutputStream fos;
			try {
				fos = new FileOutputStream("X:\\OperadoraCallback.xml", false);
				XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
		        File arquivo = new File("X:\\OperadoraCallback.xml");
		        if(arquivo.exists()){arquivo.delete();}      
		        escreveXML(writer, referencia);
		        writer.close();
				
				} catch (FileNotFoundException | XMLStreamException e) {
				e.printStackTrace();
				}
			
	        
	        
		}
		
		public void escreveXML(XMLStreamWriter writer,OperadoraCallback referencia){
			
			try {
			
	            writer.writeStartDocument();
		        writer.writeCharacters("\n\n");
		        writer.writeComment("Legenda:\nInforme por qual operadora ser� gerado o Callback\nExemplo: <MG>023</MG> -  Callback utilizando a Operadora Intelig ");
		        writer.writeCharacters("\n\n");
		        writer.writeStartElement("energisa");
		        writer.writeCharacters("\n\t");
	            writer.writeStartElement("config");
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("PB83");
	            writer.writeCharacters(String.valueOf(referencia.getPB83()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("BO83");
	            writer.writeCharacters(String.valueOf(referencia.getBO83()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("SE79");
	            writer.writeCharacters(String.valueOf(referencia.getSE79()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("MG31");
	            writer.writeCharacters(String.valueOf(referencia.getMG31()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("MG32");
	            writer.writeCharacters(String.valueOf(referencia.getMG32()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("MG33");
	            writer.writeCharacters(String.valueOf(referencia.getMG33()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("NF21");
	            writer.writeCharacters(String.valueOf(referencia.getNF21()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("NF22");
	            writer.writeCharacters(String.valueOf(referencia.getNF22()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("NF24");
	            writer.writeCharacters(String.valueOf(referencia.getNF24()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t");
	            writer.writeEndElement();
	            writer.writeCharacters("\n");
	            writer.writeEndDocument();
				writer.flush();
		        writer.close();
		        System.gc();
		        
        } catch (XMLStreamException e) {JOptionPane.showMessageDialog(null, "M�todo: escreveXML()","Alerta!",0);  }	}

		
		
}
