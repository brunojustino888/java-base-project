package umc.threads;

import java.util.Random;

public class ProdutorConsumidor implements Runnable {

	private Ponte ponte;
	Random r = new Random();
	public ProdutorConsumidor(Ponte ponte){
		this.ponte = ponte;
		
	}
	
	
	
	
	@Override
	public void run() {
		int total = 0;
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(r.nextInt(3000));
				total += ponte.get();
				System.err.println("\tTotal: "+total+".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
