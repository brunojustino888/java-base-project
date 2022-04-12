package umc.primeirosemestre;

public class Matematica {
	
     //@return o maior dos dois n�meros
     int maior(int um, int dois) {
	
    	 if(um>dois) {
    	  return um;	
    	 } else {
    		 return dois;
    	         }
	 }
     
     //@return exibe o resultado da soma
     double soma(double umd, double doisd){
    	 double s = umd + doisd ;
    	 return s;
     }
     
     
     //@return exibe o resultado da soma de parametros "infinitos"
     double soma2(double ... nome){
    	 double resultado = 0 ;
    	 
    	 for (double bbg: nome) {
    		 resultado  += bbg;
    	 }
    	 
    	 return resultado;
     }
     
     
 } 

