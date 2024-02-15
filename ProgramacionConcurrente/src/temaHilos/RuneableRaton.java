package temaHilos;

public class RuneableRaton implements Runnable{

	private String nombre;
	private int tiempoComer;
	
	
	public RuneableRaton(String nombre, int tiempoComer) {
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
	
	public void dormir() {
		

		try {
			System.out.println(nombre + " Ha empezado de dormir");
			Thread.sleep(tiempoComer*1000);
			System.out.println(nombre + " Ha terminado de dormir");					
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void run() {
		comer();
		dormir();
	}

	public static void main(String[] args) {
		
	  	RuneableRaton raton1 = new RuneableRaton("casitos", 4);
	  	RuneableRaton raton2 = new RuneableRaton("ammoroso", 2);
	  	RuneableRaton raton3 = new RuneableRaton("cake", 3);
	  	RuneableRaton raton4 = new RuneableRaton("dulce", 1);
	  	
	  	new Thread (raton1).start();
	  	new Thread (raton2).start();
	  	new Thread (raton3).start();
	  	new Thread (raton4).start();
	  	//Thread hiloRaton1 = new Thread(raton1);
	}


	

}
