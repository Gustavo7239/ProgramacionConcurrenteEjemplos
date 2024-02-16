package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class PrincipalPreparandoDesayuno {

	public static void main(String[] args) {
		
		//creamos una cuenta atrás con los 3 subprocesos encargados de hacer
		//desayuno
		CountDownLatch latch = new CountDownLatch(3);
		
		Thread hiloCafe = new HiloHacerCafe(latch);
		Thread hiloZumo = new HiloHacerZumo(latch);
		Thread hiloTostadas = new HiloHacerTostadas(latch);
		
		System.out.println("Preparando el desayuno......");
		
		hiloCafe.start();
		hiloZumo.start();
		hiloTostadas.start();
		
		//El proceso principal espera hasta que el contador de la cuent atrás 
		//esté 0 para seguir ejecutandose, es decir, que hasta que no terminen
		//de ejecutarse los tres hilos no seguirá la ejecución el principal
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Desayuno preparado");

	}

}
