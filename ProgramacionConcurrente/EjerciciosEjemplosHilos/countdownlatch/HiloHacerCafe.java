package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloHacerCafe extends Thread  {
	private CountDownLatch latch;
	
	public HiloHacerCafe(CountDownLatch latch) {
		super();
		this.latch = latch;
	}
	
	public HiloHacerCafe() {
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
		
		//Cuando ha terminado de hacer la tarea disminuye en una unidad el contador de
		//la cuenta atrás, cuyo valor incial fue creado con valor 3
		latch.countDown();
			}


	}


