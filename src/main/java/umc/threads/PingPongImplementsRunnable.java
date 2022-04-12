package umc.threads;

//Essa classe serve para exemplificar o uso de um objeto que implementa a classe Runnable. 
//O m�todo run ser� chamado ao instanciar o objeto runnable. Ele dever� mostrar na tela a palavra ping a cada 1,5 segundos.
//Ele ser� passado como par�metro para ser executado por uma thread.

public class PingPongImplementsRunnable implements Runnable {

	String palavra;
	long tempo;
	public PingPongImplementsRunnable(String palavra, long tempo){
		this.palavra = palavra;
		this.tempo = tempo;
	}
	
	
	public void run(){
		
		try {
			for (int i =0; i<6;i++){
				System.out.println(palavra);
				Thread.sleep(tempo);				}
		}catch (InterruptedException e) {
			return;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		PingPongImplementsRunnable e = new PingPongImplementsRunnable("ping",1500);
		PingPongImplementsRunnable e2 = new PingPongImplementsRunnable("PONG",2000);
		
		new Thread(e, "ping").start();
		new Thread(e2,"pong").start();
		System.out.println("Ver thread");

	}

}
