package ejercicio1SocketTCPDatosPrimitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
		DataOutputStream dos;
		DataInputStream dis;
		
			
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
			
			/*Permite leer y escribir tipos primitivos*/
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			System.out.println("Cliente: Enviando mensaje al servidor");
			/*le envio al servidor 5 valores enteros*/
			dos.writeInt(1);
			dos.writeInt(2);
			dos.writeInt(3);
			dos.writeInt(4);
			dos.writeInt(5);
								
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
