package umc.passosBlueJ;

import java.util.*;
public class TestaMotorista {

    public static void main (String[] args){
    
     ArrayList<Motorista> oSindicato = new ArrayList<Motorista>();
     
     Motorista clara = new Motorista();
        
     clara.snome      = "Bruno";
     clara.icarteira  = 34657;
     clara.ccategoria = 'B';
     clara.dirigir();
     
     oSindicato.add(clara);
     System.out.println((oSindicato.get(0)).icarteira);
     
     System.out.println(clara.snome);
    
    }

}