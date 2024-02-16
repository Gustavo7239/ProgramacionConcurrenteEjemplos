package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloHacerZumoJoin extends Thread  {

	public HiloHacerZumoJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		try {
			System.out.println("Haciendo el zumo");
			//pongo a dormir un tiempo aleatorio entre 1 y 3 segundos
			Thread.sleep((long) (Math.random() * (3000 - 1000)) + 1000);
		}
		
		catch (InterruptedException e) {
			e.printStackTrace () ;
		}
		System.out.println ("Zumo hecho");
		
	}
		

}

