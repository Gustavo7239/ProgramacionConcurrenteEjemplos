package temaHilos;

public class HiloRaton extends Thread{

	private String nombre;
	private int tiempoComer;
	
	
	public HiloRaton(String nombre, int tiempoComer) {
		super();
		this.nombre = nombre;
		this.tiempoComer = tiempoComer;
	}
	
	
	public void comer() {
		

		try {
			System.out.println(nombre + " Ha empezado de comer");
			Thread.sleep(tiempoComer*1000);
			System.out.println(nombre + " Ha terminado de comer");					
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
	}
	public void run() {
		comer();
	}


	public static void main(String[] args) {
		
	  	HiloRaton raton1 = new HiloRaton("casitos", 4);
	  	HiloRaton raton2 = new HiloRaton("ammoroso", 2);
	  	HiloRaton raton3 = new HiloRaton("cake", 3);
	  	HiloRaton raton4 = new HiloRaton("dulce", 1);
	  	
	  	raton1.start();
	  	raton2.start();
	  	raton3.start();
	  	raton4.start();

	}

}
