package ejercicio1SocketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int puertoEscucha= 3200;
		boolean ESCUCHANDO=true;
		DatagramSocket serverSocket;
		DatagramPacket paqueteRecibido;
		final int TAM_MAX= 2000;
		byte[] mensajeRecibidoBytes = new byte[TAM_MAX];
		String mensajeRecibidoString;
		String dirIpServidor= "192.168.105.75";
		
		try {
			System.out.println("Servidor: Creando socket UDP");
			
			//El servidor escucha por la ip local 127.0.0.1
			serverSocket = new DatagramSocket(puertoEscucha);
			
			//Si quisieramos que escuchara en una ip determinada
			//serverSocket = new DatagramSocket(puertoEscucha,InetAddress.getByName(dirIpServidor));
			
		//bucle que recibe datagramas de los clientes
			while(ESCUCHANDO) {
				 paqueteRecibido = new DatagramPacket(mensajeRecibidoBytes, TAM_MAX);
				 System.out.println("Servidor: recibiendo el datagrama del cliente");
				 serverSocket.receive(paqueteRecibido);
				 
				 //Obtener el mensaje del paquete recibido
				 mensajeRecibidoString = new String(paqueteRecibido.getData());
				 System.out.println(mensajeRecibidoString);
		
				 
			
			}
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
