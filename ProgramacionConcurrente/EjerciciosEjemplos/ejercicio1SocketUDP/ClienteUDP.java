package ejercicio1SocketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteUDP {

	public static void main(String[] args) {
		
		int puertoEscuchaServidor= 3200;
		DatagramSocket clienteSocket;
		DatagramPacket paqueteEnviado;
		String ipServidor= "127.0.0.1";
		final int TAM_MAX= 2000;
		byte [] mensajeEnviado = new byte[TAM_MAX];
		String cadena;
		Scanner teclado = new Scanner(System.in);
		
		try {
			System.out.println("Cliente: Creando el socket para comunicarme con el servidor");
			clienteSocket = new DatagramSocket();
		
			
			//pedimos que se introduzca por pantalla el mensaje a enviar al servidor
			System.out.println("Introduce el mensaje a enviar al servidor");
			cadena= teclado.nextLine();
			
			//Convertimos el String a vector de bytes
			mensajeEnviado = cadena.getBytes();
			
                 	
            //creamos el datagrama para enviarlo
			paqueteEnviado = new DatagramPacket(mensajeEnviado,
													mensajeEnviado.length,
													InetAddress.getByName(ipServidor),
													puertoEscuchaServidor );
				
			//enviamos el datagrama
			clienteSocket.send(paqueteEnviado);
				
			//cerramos el socket
			clienteSocket.close();
				
	
		} catch (SocketException e) {
		
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
