package SocketsEjemplo2Buffer;


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
			
			System.out.println("[Cliente]: Creando el Socket.");
			clienteSocket = new Socket();
			
			System.out.println("[Cliente]: Realizando conexion al Socket.");
			String ip = "localhost"; int puerto = 5555;
			clienteSocket.connect(new InetSocketAddress(ip,puerto));
			
			System.out.println("[Cliente]: Creando los Streams.");
			is = clienteSocket.getInputStream();
			os = clienteSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(clienteSocket.getOutputStream()));
			
			System.out.println("[Cliente]: Enviando una linea de texto al servidor.");
			String mensaje = "Hola que tal estas, yo soy el cliente.";
			bw.write(mensaje);
			bw.newLine();
			bw.flush();
			
			System.out.println("[Cliente]: Cadena leida enviada por el servidor.");
			System.out.println("[Cliente]: La cadena leida es: " + br.readLine());
			
			System.out.println("[Cliente]: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("[Cliente]: Fin.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

