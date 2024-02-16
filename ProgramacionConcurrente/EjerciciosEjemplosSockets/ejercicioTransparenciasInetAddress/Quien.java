package ejercicioTransparenciasInetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Quien {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String nombreDominio;
		InetAddress direccion;
		
		System.out.println("Introduce el nombre de una máquina");
		nombreDominio = teclado.next();
		
		try {
			direccion = InetAddress.getByName(nombreDominio);
			System.out.println("IP: "+ direccion.getHostAddress());
			System.out.println("nombre: "+ direccion.getHostName());
			
		} catch (UnknownHostException e) {
			System.out.println("La máquina es desconocida");
		}
		
		
		


	}

}
