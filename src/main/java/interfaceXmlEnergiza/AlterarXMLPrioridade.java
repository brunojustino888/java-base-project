package interfaceXmlEnergiza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class AlterarXMLPrioridade {

	//O construtor receber� os valores; 0 ou 1 de acordo com as sele��es nos checkBox's da interface 
	public AlterarXMLPrioridade(String PB, String BO, String SE, String MG, String NF){
		RetencaoEstado referencia = new RetencaoEstado(PB, BO, SE, MG, NF);
		preparaXML(referencia);
	}

	    //M�todo respons�vel por preparar a classe que ser� transformada em XML.
		public void preparaXML(RetencaoEstado referencia){
			XMLOutputFactory factory = XMLOutputFactory.newFactory();        
	        FileOutputStream fos;
			try {
				fos = new FileOutputStream("X:\\Prioridade_Sites.xml", false);
				XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
		        File arquivo = new File("X:\\Prioridade_Sites.xml");
		        if(arquivo.exists()){arquivo.delete();}      
		        escreveXML(writer, referencia);
		        writer.close();
				
				} catch (FileNotFoundException | XMLStreamException e) {}
		}
		
		//M�todo respons�vel por escrever no XML.
		public void escreveXML(XMLStreamWriter writer, RetencaoEstado referencia){
			try {
	            writer.writeStartDocument();
		        writer.writeCharacters("\n\n");
		        writer.writeComment("Legenda:\n0 - Inativo\n1 - Ativo\nExemplo:\n<SE>1</SE> - As chamadas realizadas para o site Sergipe ter�o maior prioridade sobre as demais.\n<MG>0</MG> - As chamadas realizadas para o site Minas ter�o prioridade normal.\n");
		        writer.writeCharacters("\n\n");
		        writer.writeStartElement("energisa");
		        writer.writeCharacters("\n\t");
	            writer.writeStartElement("config");
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("PB");
	            writer.writeCharacters(String.valueOf(referencia.getPB()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("BO");
	            writer.writeCharacters(String.valueOf(referencia.getBO()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("SE");
	            writer.writeCharacters(String.valueOf(referencia.getSE()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("MG");
	            writer.writeCharacters(String.valueOf(referencia.getMG()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t\t");
	            writer.writeStartElement("NF");
	            writer.writeCharacters(String.valueOf(referencia.getNF()));
	            writer.writeEndElement();
	            writer.writeCharacters("\n\t");
	            writer.writeEndElement();
	            writer.writeCharacters("\n");
	            writer.writeEndDocument();
				writer.flush();
		        writer.close();
		        System.gc();
			}catch (XMLStreamException e) {JOptionPane.showMessageDialog(null, "M�todo: escreveXML()","Alerta!",0);  }	
		}

		
		
}
