package colas;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
        // Creamos una LinkedBlockingQueue con una capacidad máxima de 5
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);

        // Iniciamos el productor y el consumidor
        Productor productor = new Productor(blockingQueue);
        Consumidor consumidor = new Consumidor(blockingQueue);

        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);

        hiloProductor.start();
        hiloConsumidor.start();
    }
}