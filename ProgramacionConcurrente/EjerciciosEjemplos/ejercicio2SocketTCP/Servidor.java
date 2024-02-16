package ejercicio2SocketTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		Socket socket;
		ServerSocket serverSocket;
		InputStream is;
		OutputStream os;
		BufferedReader br;
		String mensaje;
		String mensajeMayusculas;
		PrintWriter pw;

		
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
			
			/*Permite leer y escribir Líneas de texto*/			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os,true);
					
			System.out.println("Servidor: Recibe una Cadena del cliente");
			mensaje =br.readLine();
			
			System.out.println("Servidor: Convierte la cadena a mayusculas");
			mensajeMayusculas = mensaje.toUpperCase();		
			
			System.out.println("Servidor: Envía la cadena al cliente");
			pw.write(mensajeMayusculas);
			pw.flush();
										
			
			System.out.println("Servidor: Cerrando el socket");
			socket.close();
			
			System.out.println("Servidor: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
