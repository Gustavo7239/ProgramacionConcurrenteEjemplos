package supermercado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Mercado {
	private Queue<Cliente> ColaClientes = new LinkedList<Cliente>();
	private final int NUM_CAJAS = 5;
	private ArrayList<Thread> cajas = new ArrayList<Thread>();
	private Semaphore semaforo = new Semaphore(1);
	Object lock = new Object();
	
	public void iniciar() {
		abrirCajas();
		
		for(Thread caja : cajas) {
			caja.start();		
		}
		
		for (Thread caja : cajas) {
	        try {
	            caja.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void abrirCajas() {
		for(int i=1;i<=NUM_CAJAS;i++) {
			cajas.add(new Thread(new Caja("Caja "+i, this, semaforo)));
		}
	}
	
	public void agregarCliente(Cliente cliente) {
			ColaClientes.offer(cliente);
	}
	
	public synchronized Cliente obtenerCliente() {
		Cliente c = null;
		try {
			semaforo.acquire();
			Thread.sleep(10);
			c = ColaClientes.poll();
			semaforo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public synchronized boolean colaVacia() {
		return ColaClientes.isEmpty();
	}
}

