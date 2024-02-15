package supermercado;

import java.util.Random;

public class Cliente {
	private String nombre;
	private int tiempoPago;
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
		tiempoPago = numeroRandom();
	}

	private int numeroRandom() {
		Random random = new Random();
		return random.nextInt(500);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempoPago() {
		return tiempoPago;
	}

	public void setTiempoPago(int tiempoPago) {
		this.tiempoPago = tiempoPago;
	}
}