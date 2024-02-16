package poolHilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

	public static void main(String[] args) {
		
		ExecutorService e= Executors.newFixedThreadPool(2);
		
		//crear tareas para asignarlas al pool
		
		  for (int i=1; i<=8; i++)
	        e.execute(new NumerosAleatorios());
		  
		  e.shutdown();
		
		

	}

}
