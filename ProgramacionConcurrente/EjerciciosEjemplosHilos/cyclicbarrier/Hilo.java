package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {

    CyclicBarrier barreraCiclica;
    int i;

    public Hilo(CyclicBarrier barreraInicio,int i) {
        this.barreraCiclica = barreraInicio;
        this.i = i;
    }

    @Override
    public void run() {

        try {

            System.out.println("Iniciamos el hilo " + i);
            // Detenemos el hilo
            // Que se iniciará cuando se generen 10 hilos
            barreraCiclica.await(); 
            
            System.out.println("hilo " + i + " ejecutandose");

        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
