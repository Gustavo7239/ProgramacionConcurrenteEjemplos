package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HiloHacerTostadas extends Thread  {
	private CountDownLatch latch;
	
	public HiloHacerTostadas(CountDownLatch latch) {
		super();
		this.latch = latch;
	}
	
	public HiloHacerTostadas() {
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
		
		Thread hiloTostadas = new HiloHacerTostadas(latch);
		
		System.out.println ("Tostadas hechas");
		
		//Cuando ha terminado de hacer la tarea disminuye en una unidad el contador de
		//la cuenta atrás, cuyo valor incial fue creado con valor 3
		latch.countDown();
	}
		

}

