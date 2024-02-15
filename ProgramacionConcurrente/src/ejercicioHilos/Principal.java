package ejercicioHilos;

public class Principal {
	public static void main(String[] args) {
		Persona p1 = new Persona("Juan");
		Persona p2 = new Persona("Pedro");
		Persona p3 = new Persona("Paco");
		Persona p4 = new Persona("Alberto");
		Persona p5 = new Persona("Luis");
		Persona p6 = new Persona("Francisco");
		
		new Thread (p1).start();
		new Thread (p2).start();
		new Thread (p3).start();
		new Thread (p4).start();
		new Thread (p5).start();
		new Thread (p6).start();
	}
}
