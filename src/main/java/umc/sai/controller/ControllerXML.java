package umc.sai.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** <h1>ControllerArquivoXML</h1>
 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * <p>Essa classe � respons�vel por criar o arquivo config.xml (que ficar� localizado no diret�rio raiz da aplica��o).</p> 
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 * @version 8.0
 * @see ControllerConexaoDB
 */

public class ControllerXML {


	private String caminhoXML = "C:\\SAI\\config.xml";
    private String url 		  = "jdbc:postgresql://localhost:5432/sai";                   
    private String userdb 	  = "postgres";
    private String password   = "359460";   

    /**<p>O construtor dessa classe � respons�vel por verificar a exist�ncia do arquivo xml e cri�-lo caso precise.</p>*/
	public ControllerXML(){

		if(isValidXML()){
			  lerXML();
			}else{
			  criarXML();
			}
		
	}
	
	/**<p>O construtor est� sobrecarregado para atender tamb�m � cria��o de um novo arquivo xml com as configura��es recebidas como par�metro.</p>*/
	public ControllerXML(String surl,String suserdb,String spassword){
		url        = surl;                   
	    userdb 	   = suserdb;
	    password   = spassword;   
		criarXML();
	}

	/**<p>M�todo respons�vel por "ler" o arquivo xml para carregar as configura��es do mesmo na tela da aplica��o.</p>*/
	 private void lerXML(){
	    	try{ 	
				File arquivoXML = new File(caminhoXML);
		        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        Document doc = db.parse(arquivoXML);
		        Element raiz = doc.getDocumentElement();
		        NodeList nodeLurl = raiz.getElementsByTagName("url");
		        NodeList nodeLuser= raiz.getElementsByTagName("user");
		        NodeList nodeLpass= raiz.getElementsByTagName("password");

		        Node nodeurl  = nodeLurl.item(0).getFirstChild();
		        Node nodeuser = nodeLuser.item(0).getFirstChild();
		        Node nodepass = nodeLpass.item(0).getFirstChild();
     
 		        url = nodeurl.getTextContent();
 		        userdb = nodeuser.getTextContent();
 		        password = nodepass.getTextContent();

	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}	    	
	  }
	
	

	
	/**<p>Esse m�todo dever� retornar true caso encontre o arquivo xml no seu respectivo diret�rio.</p>*/
	private boolean isValidXML() {
		 File arquivo = new File(caminhoXML);
	        if(arquivo.exists()){
	           return true;
	        }else{
	        	System.out.println("N�o existe");
	        	return false;
	        }
	}
	
	/**<p>Esse m�todo vai criar o arquivo xml fisicamente no sistema.</p><p>Ele tamb�m verifica a exist�ncia do tal arquivo e o reescreve caso exista.</p>*/
	private void criarXML() {
		XMLOutputFactory factory = XMLOutputFactory.newFactory(); 
        FileOutputStream fos = null;
        XMLStreamWriter writer = null;
        
        try {
			fos = new FileOutputStream(caminhoXML, false);				//Deseja manter o conteudo do arquivo caso exista? = false
		} catch (FileNotFoundException e) {e.printStackTrace();}      
        
        try {
			writer = factory.createXMLStreamWriter(fos, "UTF-8");
		} catch (XMLStreamException e) {e.printStackTrace();}
        
        new File(caminhoXML);
     
        try {
			writer.writeStartDocument("UTF-8", "1.0");
		    writer.writeCharacters("\n");
		    writer.writeStartElement("config_db");
		    writer.writeCharacters("\n");
	        writer.writeCharacters("\t");
	        writer.writeStartElement("datainfo");
	        writer.writeAttribute("id","config_postgresql");
	        writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("url");
	        writer.writeCharacters(url);
	        writer.writeEndElement();
	        writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("user");
	        writer.writeCharacters(userdb);
	        writer.writeEndElement();
	        writer.writeCharacters("\n\t\t");
	        writer.writeStartElement("password");
	        writer.writeCharacters(password);
	        writer.writeEndElement();
	        writer.writeCharacters("\n\t");
	        writer.writeEndElement();
	        writer.writeCharacters("\n");
		    writer.writeEndElement();
		    writer.writeEndDocument();
		    writer.flush();
		    writer.close();
        } catch (XMLStreamException e) {e.printStackTrace();}
        System.gc();
	}	
	
	
	/**<p>Get da URL</p>*/
	public String getUrl() {
		return url;
	}
	
	/**<p>Get do usuario do banco</p>*/
	public String getUserdb() {
		return userdb;
	}
	/**<p>Get da senha do usuario do banco.</p>*/
	public String getPassword() {
		return password;
	}
	
}