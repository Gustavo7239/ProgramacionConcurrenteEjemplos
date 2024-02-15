package PruebasHilos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Servidor {
    Queue<Cliente> colaClientes = new LinkedList<Cliente>();
    Semaphore semaforo = new Semaphore(1);
    private final int NUM_PROCESADORES = 4;
    List<Thread> procesadores = new ArrayList<Thread>();

    public void iniciar() {
        for (int i = 1; i <= NUM_PROCESADORES; i++) {
            procesadores.add(new Thread(new Procesador("P" + i, this, semaforo)));
        }

        for (Thread hilo : procesadores) {
            hilo.start();
        }
    }

    public synchronized void agregarCliente(Cliente cliente) {
        colaClientes.offer(cliente);
        notifyAll();
    }

    public synchronized Cliente procesarCliente() {
        return colaClientes.poll();
    }
}
