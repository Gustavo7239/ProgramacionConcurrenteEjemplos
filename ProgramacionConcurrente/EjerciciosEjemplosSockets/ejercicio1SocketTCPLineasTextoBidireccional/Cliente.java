package ejercicio1SocketTCPLineasTextoBidireccional;

/*
 * https://stackoverflow.com/questions/43026723/bufferedreader-and-bufferedwriter-with-socket
 * 
 */

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

public class Cliente {

	public static void main(String[] args) {

		
		Socket clienteSocket;
		ServerSocket serverSocket;
		InputStream is;
		OutputStream os;
		DataOutputStream salida;
	    DataInputStream entrada;
	    String mensajeRecibido;
	    
	    
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
			
			/*Permite leer y escribir Líneas de texto*/
			entrada = new DataInputStream(is);
			salida = new DataOutputStream(os);
			
			System.out.println("Cliente: Enviando una línea de texto al servidor");
			String mensaje= "Hola que tal estas, yo soy el cliente";
			salida.writeUTF(mensaje);
			
			System.out.println("Cliente: Recibiendo un mensaje del servidor");
			mensajeRecibido = entrada.readUTF();
			System.out.println("Cliente: EL mensaje recibido es "+ mensajeRecibido);
		 				
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
