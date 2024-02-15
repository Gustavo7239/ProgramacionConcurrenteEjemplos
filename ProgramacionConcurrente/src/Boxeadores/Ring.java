package Boxeadores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Ring {
	private final int NUMERO_BOXEADORES = 2;
	private int NumeroGolpes;
	private ConcurrentLinkedQueue<Golpe> golpes;
	private List<String> score = new ArrayList<String>();
	Semaphore semaforo = new Semaphore(1); 
	
	
	private final String boxeador1 = "Juan";
	private final String boxeador2 = "Pepe";
	
	public Ring(int numeroGolpes) {
		super();
		NumeroGolpes = numeroGolpes;
	}
	
	public void empezar() {
		golpes = new ConcurrentLinkedQueue<Golpe>();
		
		for(int i=0; i<NumeroGolpes; i++) {
			golpes.offer(new Golpe());
		}
		
		Boxeador box1 = new Boxeador(boxeador1 , this, semaforo);
		Boxeador box2 = new Boxeador(boxeador2 , this, semaforo);
		
		box2.start();
		box1.start();
		
		
		try {
			box1.join();
			box2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		verPuntuacion();
	}
	
	public void punto(String nombre) {
		score.add(nombre);
	}
	
	public synchronized Golpe golpear() {
		Golpe g = null;
		synchronized (this) {
			g = golpes.poll();
		}
		return g;
	}

	public Queue<Golpe> getGolpes() {
		return golpes;
	}

	public void setGolpes(ConcurrentLinkedQueue<Golpe> golpes) {
		this.golpes = golpes;
	}
	
	private void verPuntuacion() {
		int puntuacioBoxeador1 = 0;
		int puntuacioBoxeador2 = 0;
		
		for(String nombre: score) {
			if(nombre.equals(boxeador1)) puntuacioBoxeador1++;
			if(nombre.equals(boxeador2)) puntuacioBoxeador2++;
		}
		
		System.out.println("FIN DE LA PARTIDA");
		if(puntuacioBoxeador1>puntuacioBoxeador2)
			System.out.println("Ha ganado el jugador: " + boxeador1 + " con "+puntuacioBoxeador1+" golpes.");
		else if(puntuacioBoxeador2>puntuacioBoxeador1)
			System.out.println("Ha ganado el jugador: " + boxeador2 + " con "+puntuacioBoxeador2+" golpes.");
		else 
			System.out.println("Empate");
	}
	
}
