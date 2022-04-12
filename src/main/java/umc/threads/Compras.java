package umc.threads;

public class Compras implements Runnable {

	ContaConjunta conta = new ContaConjunta();
	
	
	public static void main(String[] args) {
		
		Compras c = new Compras();
		new Thread(c,"Pai").start();
		new Thread(c,"M�e").start();
		new Thread(c,"Filho1").start();
		new Thread(c,"Filho2").start();
	}	
	
	
	@Override
	public void run() {
		String pessoa = Thread.currentThread().getName();
		for (int i=0; i<5;i++) {
			conta.sacar(20, pessoa);
			if(conta.getSaldo()<0){
				System.out.println("Conta Estourada.");
			}
		}
	}

	

	
}
