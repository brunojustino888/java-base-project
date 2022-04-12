package umc.passosBlueJ;

class Passos {

public static void main (String[] args) {


    boolean bVerdade = true; 
    bVerdade = !((5>10)||(8<10));    
	System.out.println(bVerdade);
	
	double dSalario = 1000;
	dSalario = dSalario + 0.15*dSalario;
	System.out.println(dSalario);
}
}