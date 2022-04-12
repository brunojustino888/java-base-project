package umc.sai.controller;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

import umc.sai.model.Usuario;

/** <h1>Fonte</h1>
 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * <p>Essa classe se refere ao objeto que representa a Fonte que � utilizada pela aplica��o.</p> 
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 * @version 8.0
 * @see Usuario
 */

public class ControllerFonte {
	/**<p>Objetos da Classe Fonte:</p>
	 * <ul>
	 * <li>Font font</li>
	 * <li>File file</li>
	 * <li>FileInputStream fis</li>
	 * </ul>
	 * */
	
	private Font font;  
	private File file;
	private final String path= "C:\\SAI\\font\\FingerPaint-Regular.ttf"; 
	private FileInputStream fis;
	
	 /**<p>M�todo respons�vel por "carregar" a fonte normal que ser� usada pela aplica��o.<p>*/
    public Font getFontPlain(int tamanho){  
        font = null;  
        try{  
            file = new File(path);  
            fis = new FileInputStream(file);  
            font = Font.createFont(Font.TRUETYPE_FONT,fis );  
        }catch( Exception e ){e.printStackTrace();}  
        font = font.deriveFont(Font.BOLD,tamanho);  
        return font;  
    } 
    
    /**<p>M�todo respons�vel por "carregar" a fonte em negrito que ser� usada pela aplica��o.</p>*/
    public Font getFonteBold(int tamanho){  
        font = null;  
        try{  
            file = new File(path);  
            fis = new FileInputStream(file);  
            font = Font.createFont(Font.TRUETYPE_FONT , fis );  
        }catch( Exception e ){e.printStackTrace();}  
        font = font.deriveFont(Font.BOLD,tamanho);  
        return font;  
    } 

}
