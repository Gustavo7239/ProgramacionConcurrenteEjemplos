/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

public static void main(String[] args) {
        int numeroHilos = 10;
        final CyclicBarrier barreraCiclica = new CyclicBarrier(numeroHilos + 1);

        // Creamos los 10 hilos
        for (int i = 0; i < numeroHilos; i++) {

            Hilo h = new Hilo(barreraCiclica, i);
            h.start();

            // Hacemos una pausa
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // Cuando sale del bucle los hilos están creados pero frenados
        try {
            barreraCiclica.await(); // Fuerza el cyclicBarrier 11, y hace que se ejecuten los hilos
            System.out.println("Al estar todos preparados, levanto la barrera de inicio. Todos los hilos han arrancado"
            		+ " y los ejecuto");
            Thread.sleep(500);


        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Fin
        System.out.println("Finalizando programa");

    }

}
