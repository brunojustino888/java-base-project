package umc.primeirosemestre;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class FontesMetodo {

	
    public Font getFonte( int tamanho ){  
        Font font = null;  
        try{  
            File file = new File("D:\\SAI - Sistema de Aprendizagem Infantil\\Images - Fonts\\maiden.ttf");  
            FileInputStream fis = new FileInputStream( file );  
            font = Font.createFont( Font.TRUETYPE_FONT , fis );  
        }catch( Exception e ){  
            System.out.println( e.getMessage() );  
        }  
        font = font.deriveFont( Font.PLAIN , tamanho );  
        return font;  
    } 
	
}
