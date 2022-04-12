package umc.threads;

import java.util.Random;

public class Produtor implements Runnable {

	private Ponte ponte;
	Random r = new Random();
	public Produtor(Ponte ponte){
		this.ponte = ponte;
		
	}
	
	
	
	
	@Override
	public void run() {
		int total = 0;
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(r.nextInt(3000));
				ponte.set(i);
				total +=i;
				System.out.println("\tTotal: "+total+".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
