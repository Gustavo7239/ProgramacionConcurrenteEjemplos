package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ColaConcurrente implements Runnable {
	private static Queue<Integer> cola = new ConcurrentLinkedDeque<Integer>();


	public void run() {
		cola.add(5);
		for (Integer i : cola) {
			System.out.print(i+":");
		}	
		
		System.out.println("Tamaño cola:" + cola.size());
	}

	public static void main(String[] args) {
		for (int i=0;i<10;i++)
				new Thread (new ColaConcurrente()).start();
		
	}
}
