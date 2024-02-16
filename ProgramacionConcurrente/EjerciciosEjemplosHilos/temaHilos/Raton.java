package temaHilos;

public class Raton {

	private String nombre;
	private int tiempoComer;
	
	
	public Raton(String nombre, int tiempoComer) {
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


	public static void main(String[] args) {
		
	  	Raton raton1 = new Raton("casitos", 4);
	  	Raton raton2 = new Raton("ammoroso", 2);
	  	Raton raton3 = new Raton("cake", 3);
	  	Raton raton4 = new Raton("dulce", 1);
	  	
	  	raton1.comer();
	  	raton2.comer();
	  	raton3.comer();
	  	raton4.comer();

	}

}
