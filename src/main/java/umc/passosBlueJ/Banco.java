package umc.passosBlueJ;

import javax.swing.JOptionPane;

public class Banco {

	static boolean s = false;
	static String sQuantidade;
	static int iQuantidade;
	static int iEscolha;
	
	
	public static void main(String[] args) {
		
		
		do {
		String sEscolha = JOptionPane.showInputDialog(null,"Select a number: \n1-Cadastrar Contas. \n2-Consultar Contas. \n3-Sair.","Pirate Bank",3);
		iEscolha = Integer.parseInt(sEscolha);
		
	
		if(iEscolha == 1){
			sQuantidade = JOptionPane.showInputDialog(null,"Quantas Contas-corrente pretende cadastrar?","Pirate Bank",3);
			iQuantidade = Integer.parseInt(sQuantidade);
			cadastrarConta(iQuantidade);//vai enviar o parametro da quantidade de contas a serem cadastradas
			
			}
		else if(iEscolha == 2){
			
			 for(int i=0;i<iQuantidade;i++){
				 Conta[] contas = new Conta[iQuantidade];
				   contas[i].mostrar();
				   }
				}
		
		
		}while(iEscolha!=3);
			
		
		
		
	}
	
	
	//metodo para receber a quantidade de contas a ser cadastradas
	public static void cadastrarConta(int ie){
		Conta[] contas = new Conta[ie];
		 
		
		
		   for(int i=0;i<ie;i++){
			   String a = JOptionPane.showInputDialog(null,i+"Saldo desta Conta:","Pirate Bank",3);
			   double dSs = Double.parseDouble(a);
			   String b = JOptionPane.showInputDialog(null,i+"N�mero da conta","Pirate Bank",3);
			   int iNn = Integer.parseInt(b);
			   contas[i] = new Conta(dSs,iNn,"John");
		   		}	
		   
		   for(int i=0;i<ie;i++){
		   contas[i].mostrar();
		   }
 	}
	
	
	
	

	
}
