package ejercicio1SocketTCPBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		
		Socket clienteSocket;
		ServerSocket serverSocket;
		InputStream is;
		OutputStream os;
		final int MAX=50;
		String mensaje = "HOLA SOY EL CLIENTE Y TE ENVÍO ESTE SALUDO";
		
		
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
			
			System.out.println("Cliente: Enviando mensaje al servidor");
			os.write(mensaje.getBytes());
			/***********************************************/
			
			
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
