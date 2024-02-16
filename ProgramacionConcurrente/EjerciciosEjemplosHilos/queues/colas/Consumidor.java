package colas;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public Consumidor(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Integer elemento = blockingQueue.take();
                System.out.println("Consumidor obtuvo: " + elemento);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}