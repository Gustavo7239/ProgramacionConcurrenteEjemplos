package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloHacerCafeJoin extends Thread  {
	
	public HiloHacerCafeJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void run() {
		try {
			System.out.println("haciendo el cafe");
			//pongo a dormir un tiempo aleatorio entre 2 y 4 segundos
			Thread.sleep((long) (Math.random() * (4000 - 2000)) + 2000);
		}
		
		catch (InterruptedException e) {
			e.printStackTrace () ;
		}
		System.out.println ("Cafe hecho");
		
			}

	}


