package umc.threads;

//Essa classe serve para exemplificar o uso de um objeto que extend threads. 
//O m�todo run ser� chamado ao instanciar o objeto thread. Ele dever� mostrar na tela a palavra ping a cada 1,5 segundos.

public class PingPongExtends extends Thread {

	String palavra;
	long tempo;
	
	public PingPongExtends(String palavra, long tempo){
		this.palavra = palavra;
		this.tempo = tempo;
	}
	
	
	public void run(){
		
		try {
			for (int i =0; i<60;i++){
				System.out.println(palavra);
				Thread.sleep(tempo);				}
		}catch (InterruptedException e) {
			return;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new PingPongExtends("ping",1500).start();
		new PingPongExtends("PONG",2000).start();
		System.out.println("Ver thread");

	}

}
