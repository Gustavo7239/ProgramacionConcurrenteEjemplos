package temaHilos;

public class RuneableRatonContAlimentos implements Runnable{

	private String nombre;
	private int tiempoComer;
	private int alimentosConsumidos;
	
	
	public RuneableRatonContAlimentos(String nombre, int tiempoComer) {
		super();
		this.nombre = nombre;
		this.tiempoComer = tiempoComer;
		alimentosConsumidos = 0;
	}
	
	
	public void comer() {
		

		try {
			System.out.println(nombre + " Ha empezado de comer");
			Thread.sleep(tiempoComer*1000);
			alimentosConsumidos++;
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
			System.out.println("Alimentos consumidos: "+alimentosConsumidos);
			
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
		
	  	RuneableRatonContAlimentos raton1 = new RuneableRatonContAlimentos("casitos", 2);
	  	
	  	new Thread (raton1).start();
	  	new Thread (raton1).start();
	  	new Thread (raton1).start();
	  	new Thread (raton1).start();
	  	//Thread hiloRaton1 = new Thread(raton1);
	}


	

}
