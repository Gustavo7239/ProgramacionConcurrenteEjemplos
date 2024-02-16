package ClienteServidorSocketTCPHilos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		Socket socket=null;
		ServerSocket serverSocket;
		boolean listening = true;
		int puertoEscuchaServidor= 5555;
		String dirIpServidor= "localhost";
		
	
		try {
			System.out.println("Servidor: Creando el socket");
			serverSocket = new ServerSocket();
			
			System.out.println("Servidor: Realizando el enlace al socket");
			serverSocket.bind(new InetSocketAddress(dirIpServidor, puertoEscuchaServidor));
			
			while (listening) {
			
				System.out.println("Servidor: A la espera de recibir conexiones del cliente");
				socket= serverSocket.accept();
			
				System.out.println("Servidor: He recibido una conexión del cliente");
				
				//Crear un hilo encargado de enviar y recibir datos del cliente
				
				/*********************************************/	
				ServidorRunnable sr = new ServidorRunnable(socket);
				Thread hilo = new Thread(sr);
				hilo.start();
							
			}
			System.out.println("Servidor: Cerrando el socket");
			serverSocket.close();
			
			System.out.println("Servidor: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
