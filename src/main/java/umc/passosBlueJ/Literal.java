package umc.passosBlueJ;

/*
 * criar uma classe chamada literal , esta classe deverar conter um metodo denominado palidrome
 * deverar receber como paramentro uma palavra que devera verdadeiro caso a palavra for palidrome,
 * caso ao contrario falso. escreva um metodo denominado conta letra que deverar receber como 
 * um paramentro uma palavra e uma letra o metodo devera retonar a quantidade de vezes que a letra aparece na palavra
 * crie um metodo chamado repeti��o de palavra por exemplo ana come banana aparece 3 vezes
 */

public class Literal {

	    public static void main(String args[]){
	        
	        //1- tamanho da String
	        String snome = "ANA COME BANANA";
	        System.out.println(snome.length());
	        
	        //2 - trocar a string 1 pela String 2
	        snome=snome.replace("BANANA","MELANCIA");
	        System.out.println(snome);
	        
	        //3- capturar um caracter da String em uma determinada posicao
	        System.out.println(snome.charAt(0));
	        
	        //4- comparar conteudo de String - ignorando case sensitive
	        if(snome.equalsIgnoreCase("ana come melancia"))
	            System.out.println("V");
	        else    
	            System.out.println("F");
	        
	        //5- comparar conteudo de String - considerando case sensitive
	        if(snome.equals("ana come melancia"))
	            System.out.println("V");
	        else    
	            System.out.println("F");
	          
	        //6 - captura os caracteres de um determinado intervalo
	        System.out.println(snome.substring(1,3));    

	        String sNome ="RICARDO";
	        for(int i=0;i<=sNome.length();i++)
	        {
	            System.out.println(sNome.substring(0,i));
	        }
	        
	            
	    }
	    
	}
	
