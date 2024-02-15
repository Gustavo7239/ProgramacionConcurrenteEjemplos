package PruebasHilos;

import java.util.Random;

public class Cliente {
    private String nombre;
    private int tiempoProceso;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.tiempoProceso = generarTiempoProceso();
    }

    private int generarTiempoProceso() {
        Random r = new Random();
        return r.nextInt(2000);
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoProceso() {
        return tiempoProceso;
    }
}
