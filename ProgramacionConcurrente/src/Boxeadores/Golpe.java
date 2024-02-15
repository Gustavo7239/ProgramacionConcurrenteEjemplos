package Boxeadores;

import java.util.Random;

public class Golpe {
	private final int duracionGolpe;

	public Golpe() {
		super();
		this.duracionGolpe = new Random().nextInt(51);
	}

	public int getDuracionGolpe() {
		return duracionGolpe;
	}
	
}
