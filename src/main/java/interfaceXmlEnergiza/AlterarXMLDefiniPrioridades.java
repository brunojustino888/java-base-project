package interfaceXmlEnergiza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class AlterarXMLDefiniPrioridades {

	
	public AlterarXMLDefiniPrioridades(String PB, String BO, String SE, String MG, String NF){
		RetencaoEstado referencia = new RetencaoEstado(PB, BO, SE, MG, NF);
		preparaXML(referencia);
	}
	
	
			//M�todo respons�vel por preparar a classe que ser� transformada em XML.
			public void preparaXML(RetencaoEstado referencia){
				XMLOutputFactory factory = XMLOutputFactory.newFactory();        
		        FileOutputStream fos;
				try {
					fos = new FileOutputStream("X:\\Prioridade_Opcao.xml", false);
					XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
			        File arquivo = new File("X:\\Prioridade_Opcao.xml");
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
			        writer.writeComment("Legenda:\n* Defina a prioridade de atendimento para os sites de acordo com as informa��es.\n######################################################\nOp��es:\nDesativar		    -  numero 0	Ex: <PB>0</PB>\nFalta de energia 	-  numero 1	Ex:	<BO>1</BO>\nConsulta Debito 	-  numero 2	Ex:	<SE>2</SE>\nBaixa Renda 		-  numero 4	Ex:	<MG>4</MG>\nReclama��es 		-  numero 6	Ex:	<NF>6</>\nCancelamento 		-  numero 7	Ex:	<PB>7</PB>\nAtendimento 		-  numero 9	Ex:	<PB>9</PB>\n######################################################\n");
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
