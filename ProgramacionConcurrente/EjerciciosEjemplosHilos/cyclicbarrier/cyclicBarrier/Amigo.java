package cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Amigo extends Thread {
	private final String name;
	private final CyclicBarrier barrier;

	public Amigo(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
}
	
	public void run() {
		while (true) {
			try {
				sleep((int) (3000 * Math.random()));
				System.out.println(name + " esperando ...");
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
