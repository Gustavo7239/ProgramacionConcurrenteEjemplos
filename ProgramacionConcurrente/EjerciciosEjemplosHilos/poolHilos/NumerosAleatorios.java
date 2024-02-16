package poolHilos;

import java.util.Random;

public class NumerosAleatorios  implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String resultado="";
		Random r= new Random();
		
		for(int i=0; i<20;i++) {
			if (i!=0)
				resultado+= ",";
			resultado+=  r.nextInt(50);
			System.out.println("----------- "+
	                   Thread.currentThread().getName()+
	                   " es: " + resultado);
			try {
			//	Thread.yield();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		System.out.println("Los numeros generados por "+
		                   Thread.currentThread().getName()+
		                   " es: " + resultado);
				
	}
	
	
	

}
