package colas;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public Productor(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                blockingQueue.put(i);
                System.out.println("Productor colocó: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

