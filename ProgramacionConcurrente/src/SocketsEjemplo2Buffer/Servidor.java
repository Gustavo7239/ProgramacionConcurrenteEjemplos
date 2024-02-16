package SocketsEjemplo2Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
		BufferedWriter bw;
		
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
				br = new BufferedReader(new InputStreamReader(is));
				bw = new BufferedWriter(new OutputStreamWriter(os));
				
				System.out.println("[Servidor]: Entero leido del cliente.");
				System.out.println("[Servidor]: La cadena leida es: " + br.readLine());
				
				String mensaje = "Hola que tal estas, yo soy el servidor";
				bw.write(mensaje);
				bw.newLine();
				bw.flush();
				
				System.out.println("[Servidor]: Cerrando el socket.");
				socket.close();
				
				System.out.println("[Servidor]: Fin.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

