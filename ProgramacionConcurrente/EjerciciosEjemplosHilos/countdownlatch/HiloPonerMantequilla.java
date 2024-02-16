package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloPonerMantequilla extends Thread  {
	private CountDownLatch latch;
	
	public HiloPonerMantequilla(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("Poniendo la mantequilla a  las tostadas");
			//pongo a dormir un tiempo aleatorio entre 1 y 3 segundos
			Thread.sleep((long) (Math.random() * (3000 - 1000)) + 1000);
		}
		
		catch (InterruptedException e) {
			e.printStackTrace () ;
		}
		System.out.println ("Tostadas preparadas con mantequilla");
		
		latch.countDown();
	}
		

}

