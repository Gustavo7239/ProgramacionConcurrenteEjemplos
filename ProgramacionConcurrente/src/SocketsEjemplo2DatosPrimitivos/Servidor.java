package SocketsEjemplo2DatosPrimitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try{
			System.out.println("[Servidor]: Creado el socket.");
			serverSocket = new ServerSocket(); //Inicializamos el Socket
			
			System.out.println("[Servidor]: Realizando el enlzace al socket.");
			String ip = "localhost"; int puerto = 5555;
			serverSocket.bind(new InetSocketAddress(ip,puerto));
			
			while(true) {
				System.out.println("[Servidor]: Servidor a la espera de recibir conexiones del cliente.");
				socket = serverSocket.accept();
				
				System.out.println("[Servidor]: Se ha recibido una conexion del cliente.");
				
				System.out.println("[Servidor]: Creando los Streams para la comunicacion con el cliente.");
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				//Leer y escribir tipos primitivos
				dis = new DataInputStream(is);
				dos = new DataOutputStream(os);
				
				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());
				
				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());

				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());

				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());

				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());

				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());

				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: El entero leido es: "+dis.readInt());
				
				System.out.println("[Servidor]: Cerrando el socket.");
				socket.close();
				
				System.out.println("[Servidor]: Fin.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
