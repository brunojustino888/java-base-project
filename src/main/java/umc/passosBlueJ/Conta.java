package umc.passosBlueJ;

import javax.swing.JOptionPane;

public class Conta {

	private String sNome;
	private int iNumerocc;
	private double dSaldo;
	
	
	public Conta(double dS,int iN,String sN) {
		
		dSaldo = dS; 
		iNumerocc = iN;
		sNome = sN;
	}
	
	

	public void mostrar(){
		
		JOptionPane.showMessageDialog(null,"Nome = "+ sNome+".\nN�mero da Conta = "+iNumerocc + ".\nSaldo = " + dSaldo+".","Banco do Pirata",2);	
	}
	
}
