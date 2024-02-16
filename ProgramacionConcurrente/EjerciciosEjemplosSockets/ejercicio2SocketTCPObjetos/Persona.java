package ejercicio2SocketTCPObjetos;

import java.io.Serializable;

public class Persona implements Serializable {
	private int edad;
	@Override
	
	
	public String toString() {
		return "Persona [edad=" + edad + ", nombre=" + nombre + "]";
	}



	private String nombre;
	
	
	
	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Persona(int edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}
	
	

}
