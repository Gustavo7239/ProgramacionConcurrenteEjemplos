package supermercado;

import java.util.concurrent.Semaphore;

public class Caja implements Runnable{
	private String nombre;
	private Mercado mercado;
	private Semaphore semaforo;
	
	public Caja(String nombre, Mercado mercado, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.mercado = mercado;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		while(!mercado.colaVacia()){
			Cliente c = mercado.obtenerCliente();
			try {
				
				System.out.println("[INFO]: El cliente: "+c.getNombre()+" a entrado a :"+nombre+" <<-");
				semaforo.acquire();
				
				Thread.sleep(c.getTiempoPago());
				
				System.out.println("[INFO]: El cliente: "+c.getNombre()+" a salido de :"+nombre+" ->>");
				semaforo.release();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
