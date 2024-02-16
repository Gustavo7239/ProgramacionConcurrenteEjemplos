package ejercicio1SocketTCPLineasTextoUnidireccion;

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
		BufferedReader br;
		BufferedWriter bw;
			
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
			
			/*Permite leer y escribir Líneas de texto*/
			
			br = new BufferedReader(new InputStreamReader(is));
			//bw = new BufferedWriter(new OutputStreamWriter(os));
			bw = new BufferedWriter(new OutputStreamWriter(clienteSocket.getOutputStream()));
			
			System.out.println("Cliente: Enviando una línea de texto al servidor");
			String mensaje= "Hola que tal estas, yo soy el cliente";
			bw.write(mensaje);
		//	bw.newLine();
		 	bw.flush();
		 				
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
