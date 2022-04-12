package umc.passosBlueJ;

import javax.swing.*;

public class Equacao2grau {

	private double da,db,dc,ddelta;
	
	public Equacao2grau(double dpa, double dpb, double dpc){
		
		da = dpa;
		db = dpb;
		dc = dpc;
		
	}
	
	
	public void calculardelta() {
		
		ddelta = Math.pow(db,2) - (4*da*dc);
		
	}
	
	    public void raizes() {
    
        double dxi, dxii;
        
        calculardelta();
        
        if(ddelta>= 0) {
            
            dxi  = (-db + Math.sqrt(ddelta))/(2*da);
            dxii = (-db - Math.sqrt(ddelta))/(2*da);
            JOptionPane.showMessageDialog(null,"As ra�zes de s�o: X1=" + dxi + " e X2="+dxii,"XXX",2);
            
        }
        else {
         JOptionPane.showMessageDialog(null,"N�o existem ra�zes reais.","XXX",2);
        }
    }
}
