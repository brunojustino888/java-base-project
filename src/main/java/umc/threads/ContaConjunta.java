package umc.threads;

public class ContaConjunta {

	private int saldo = 100;
	
	public int getSaldo(){
		return saldo;
	}
	
	public synchronized void sacar(int valorasacar, String nome){
		if(saldo>=valorasacar){
			int saldoinicial = saldo;
			System.out.println(nome +" quer sacar.");
			try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
			saldo -=valorasacar;
			System.err.println("O saldo inicial era de: R$"+saldoinicial+" reais.\n"+nome +" sacou R$"+valorasacar+",00 da conta.\nSobrou R$"+saldo+" na conta.\n-*-\n");
		}else{
			System.out.println("Saldo Insuficiente.");
		}
	}
	


}
