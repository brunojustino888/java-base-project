package interfaceXmlEnergiza;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

//Essa Classe � respons�vel por alterar os arquivos Bypass.xml 
public class AlterarXMLBypass {

	//O construtor receber� os valores; 0 ou 1 de acordo com as sele��es nos checkBox's da interface 
	public AlterarXMLBypass(String PB, String BO, String SE, String MG, String NF){
		RetencaoEstado referencia = new RetencaoEstado(PB, BO, SE, MG, NF);
		preparaXML(referencia);
	}

	    //M�todo respons�vel por preparar(carregar as vari�veis) a classe que ser� transformada em XML.
		public void preparaXML(RetencaoEstado referencia){
			XMLOutputFactory factory = XMLOutputFactory.newFactory();        
	        FileOutputStream fos;
			try {
				fos = new FileOutputStream("X:\\Bypass.xml", false);
				XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
		        File arquivo = new File("X:\\Bypass.xml");
		        if(arquivo.exists()){arquivo.delete();}      
		        escreveXML(writer, referencia);
		        writer.close();
				} catch (FileNotFoundException | XMLStreamException e) {}
		}
		
		//M�todo respons�vel por escrever no XML as altera��es realizadas na Interface.
		public void escreveXML(XMLStreamWriter writer, RetencaoEstado referencia){
			try {
	            writer.writeStartDocument();
		        writer.writeCharacters("\n\n");
		        writer.writeComment("Legenda:\n0 - Inativo\n1 - Ativo\nExemplo: <SE>1</SE> - Bypass do site Sergipe ativo\n<MG>0</MG> - Bypass do site Minas inativo");
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
		        criarArquivoDeLog();
			}catch (XMLStreamException e) {JOptionPane.showMessageDialog(null, "M�todo: escreveXML()","Alerta!",0);  }	
		}

	    //M�todo respons�vel por logar a altera��o realizada.
	    public void criarArquivoDeLog(){
			try {
				FileWriter fw = new FileWriter("X:\\Application4XML.log",true);
				BufferedWriter bw = new BufferedWriter(fw);  
				PrintWriter pw = new PrintWriter(bw); 
				pw.write(" -- Altera��o no arquivo XML BYPASS ");
				fw.flush();
				bw.flush();
				pw.flush();
				pw.close(); 
				fw.close(); 
				bw.close();
			}catch(IOException e){JOptionPane.showMessageDialog(null, "Problemas ao criar o arquivo de log da aplica��o! (M�todo criarArquivoDeLog())","ERRO!",0);}    	
	    }

}