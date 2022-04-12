package umc.threads;

public class PonteSincronizada implements Ponte{
	
	private int valor = -1;
	private boolean ocupada = false;
	
	@Override
	public synchronized void set(int valor) throws InterruptedException {
		while(ocupada){
			System.out.println("Ponte Ocupada. Produtor Aguarda.");
			wait();
		}
		System.out.print("Pruduziu: "+ valor);
		this.valor = valor;
		ocupada =true;
		notifyAll();
	}

	@Override
	public synchronized int get() throws InterruptedException {
		while(!ocupada){
			System.err.println("Ponte Vazia. Consumidor Aguarda.");
			wait();
		}
		System.err.print("Consumiu: "+ valor);
		ocupada = false;
		notifyAll();
		return valor;
		
	}

}
