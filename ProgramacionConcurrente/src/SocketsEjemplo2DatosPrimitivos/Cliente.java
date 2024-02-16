package SocketsEjemplo2DatosPrimitivos;

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
		
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			
			System.out.println("[Cliente]: Creando el Socket.");
			clienteSocket = new Socket();
			
			System.out.println("[Cliente]: Realizando conexion al Socket.");
			String ip = "localhost"; int puerto = 5555;
			clienteSocket.connect(new InetSocketAddress(ip,puerto));
			
			System.out.println("[Cliente]: Creando los Streams.");
			is = clienteSocket.getInputStream();
			os = clienteSocket.getOutputStream();
			
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			
			System.out.println("[Cliente]: Enviando mensaje al servidor.");
			dos.writeInt(1);
			dos.writeInt(2);
			dos.writeInt(3);
			dos.writeInt(4);
			dos.writeInt(5); 
			
			System.out.println("[Cliente]: Enviando mensaje al servidor.");
			dos.writeInt(1);
			dos.writeInt(2);
			dos.writeInt(3);
			dos.writeInt(4);
			dos.writeInt(5); 
			
			System.out.println("[Cliente]: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("[Cliente]: Fin.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
