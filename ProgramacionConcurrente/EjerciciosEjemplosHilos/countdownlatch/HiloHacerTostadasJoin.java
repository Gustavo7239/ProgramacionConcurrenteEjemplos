package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloHacerTostadasJoin extends Thread  {
	
	public HiloHacerTostadasJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			System.out.println("Haciendo las tostadas");
			//pongo a dormir un tiempo aleatorio entre 4 y 6 segundos
			Thread.sleep((long) (Math.random() * (6000 - 4000)) + 4000);
		}
		
		catch (InterruptedException e) {
			e.printStackTrace () ;
		}
		System.out.println ("Tostadas hechas");
		
	}
		

}

