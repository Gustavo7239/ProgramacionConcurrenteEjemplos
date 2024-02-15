package PruebasHilos;

import java.util.concurrent.Semaphore;

public class Procesador implements Runnable {
    private String nombre;
    private Servidor servidor;
    private Semaphore semaforo;

    public Procesador(String nombre, Servidor servidor, Semaphore semaforo) {
        this.nombre = nombre;
        this.servidor = servidor;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (servidor.colaClientes.isEmpty()) {
                    synchronized (servidor) {
                        servidor.wait();
                    }
                } else {
                    Cliente c = servidor.procesarCliente();
                    System.out.println("Atendiendo a un cliente");
                    semaforo.acquire();
                    Thread.sleep(c.getTiempoProceso());
                    System.out.println("Cliente " + c.getNombre() + " procesado con exito. Por: " + nombre);
                    semaforo.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
