package Peluqueria;

public class HiloThread extends Thread{
	
	public void run() {
		for(int i=0; i<=5 ;i++) {
			System.out.println("Hilo "+Thread.currentThread().getId()+": "+i);
			try {
				
				Thread.sleep(1000);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("El hilo s ha interrumpido.");
			}
		}
	}
	
	public static void main(String[] args) {
		HiloThread hilo1 = new HiloThread();
		HiloThread hilo2 = new HiloThread();
	}
	
	
}
