package ejercicio1SocketTCPDatosPrimitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		Socket socket;
		ServerSocket serverSocket;
		InputStream is;
		OutputStream os;
		DataOutputStream dos;
		DataInputStream dis;

		
		try {
			System.out.println("Servidor: Creando el socket");
			serverSocket = new ServerSocket();
			
			System.out.println("Servidor: Realizando el enlace al socket");
			serverSocket.bind(new InetSocketAddress("localhost", 5555));
			
			System.out.println("Servidor: A la espera de recibir conexiones del cliente");
			socket= serverSocket.accept();
			
			System.out.println("Servidor: He recibido una conexión del cliente");
			
			System.out.println("Servidor: Creo los streams para comunicarme con el cliente");
			is= socket.getInputStream();
			os= socket.getOutputStream();		
			
			/*Permite leer y escribir tipos primitivos*/
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			
			System.out.println("Servidor: Entero leido del cliente");		
			System.out.println("Servidor: El entero leido es: " + dis.readInt());
			
			System.out.println("Servidor: Entero leido del cliente");		
			System.out.println("Servidor: El entero leido es: " + dis.readInt());
			
			System.out.println("Servidor: Entero leido del cliente");		
			System.out.println("Servidor: El entero leido es: " + dis.readInt());
			
			System.out.println("Servidor: Entero leido del cliente");		
			System.out.println("Servidor: El entero leido es: " + dis.readInt());
			
			System.out.println("Servidor: Entero leido del cliente");		
			System.out.println("Servidor: El entero leido es: " + dis.readInt());
							
			
			System.out.println("Servidor: Cerrando el socket");
			socket.close();
			
			System.out.println("Servidor: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
