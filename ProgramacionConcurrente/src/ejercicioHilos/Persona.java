package ejercicioHilos;

import java.util.Random;

public class Persona implements Runnable{
	private String nombre;
	
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void trabajar() {
		while(true) {
			try {
				System.out.println(nombre+": Voy a trabajar. -------- ["+nombre.toUpperCase().charAt(0)+"]");
				Thread.sleep(randomNum()*1000);
				System.out.println(nombre+": Voy a descansar. xxxxxxxxxxx");
				Thread.sleep(randomNum()*1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		trabajar();
	}
	
	public static int randomNum() {
		return new Random().nextInt(10)+1;
	}
}
