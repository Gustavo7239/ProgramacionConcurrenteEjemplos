package Boxeadores;

import java.util.concurrent.Semaphore;

public class Boxeador extends Thread{
	private final String nombre;
	private Ring ring;
	private Semaphore semaforo;
	
	public Boxeador(String nombre, Ring ring, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.ring = ring;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		while(!ring.getGolpes().isEmpty()) {
			
			try {
				System.out.println(nombre+" dara un golpe...");
				semaforo.acquire();
				Thread.sleep(ring.golpear().getDuracionGolpe()*10);
				System.out.println(nombre+" dio un golpe.");
				ring.punto(nombre);
				semaforo.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
