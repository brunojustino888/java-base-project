package umc.passosBlueJ;


public class Equacao {
 
     private double dA,dB,dC,delta;  

     public void setA(double dpa){
       dA = dpa;
    }
    
    public void setB(double dpb) {
       dB = dpb;
    }
    
    public void setC(double dpc) {
     dC = dpc;
    }
       
    
    
    public void calcularD(){
      delta = Math.pow(dB,2) - 4 *dA * dC; 
    }

    
    
    public void raizes() {
    
        double dxi, dxii;
        calcularD();
        
        if(delta >= 0) {
            
            dxi  = (-dB + Math.sqrt(delta))/(2*dA);
            dxii = (-dB + Math.sqrt(delta))/(2*dA);
            System.out.println("As ra�zes de s�o: X1=" + dxi + " e X2="+dxii);
            
        }
        else {
         System.out.println("N�o existem ra�zes reais.");            
        }
        
    }
 //joyce_matias13@yahoo.com.br   
}
