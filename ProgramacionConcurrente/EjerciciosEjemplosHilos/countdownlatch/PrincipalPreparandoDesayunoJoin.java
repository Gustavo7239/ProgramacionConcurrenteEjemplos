package countdownlatch;

import java.util.concurrent.CountDownLatch;
public class PrincipalPreparandoDesayunoJoin {
	public static void main(String[] args) {
	
		Thread hiloCafe = new HiloHacerCafeJoin();
		Thread hiloZumo = new HiloHacerZumoJoin();
		Thread hiloTostadas = new HiloHacerTostadasJoin();
		
		System.out.println("Preparando el desayuno......");
		
		hiloCafe.start();
		hiloZumo.start();
		hiloTostadas.start();
	
		try {
			hiloCafe.join();
			hiloZumo.join();
			hiloTostadas.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Desayuno preparado");
	}

}
