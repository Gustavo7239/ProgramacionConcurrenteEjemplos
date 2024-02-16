package ejercicio1SocketTCPBytes;

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
		final int MAX=50;
		byte [] mensaje = new byte[MAX];
		
		
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
			
			is.read(mensaje);
			System.out.println("Servidor: Mensaje leido del cliente");
			
			System.out.println("Servidor: El mensaje leido es:"+ new String(mensaje));
			
			System.out.println("Servidor: Cerrando el socket");
			socket.close();
			
			System.out.println("Servidor: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
