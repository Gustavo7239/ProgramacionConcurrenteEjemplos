package cyclicBarrier;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

public class Amigos {
	public static void main(String[] args) {
		Escucha escucha = new Escucha();
		CyclicBarrier cita = new CyclicBarrier(3, escucha);
		
		Amigo pedro = new Amigo("Pedro", cita);
		Amigo angel = new Amigo("Angel", cita);
		Amigo bruno = new Amigo("Bruno", cita);

		pedro.start();
		angel.start();
		bruno.start();
	}
	
}