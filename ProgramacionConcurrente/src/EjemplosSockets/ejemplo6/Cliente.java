package EjemplosSockets.ejemplo6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

public static void main(String[] args) {

		
		Socket clienteSocket;
		ServerSocket serverSocket;
		InputStream is;
		OutputStream os;
		PrintWriter pw;
		String mensaje;
		String mensajeMayusculas;
		Scanner teclado = new Scanner(System.in);
		BufferedReader br;
			
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
			
			/*Permite leer y escribir Líneas de texto*/		
			pw = new PrintWriter(os,true);
			br = new BufferedReader(new InputStreamReader(is));
			

			System.out.println("introduce una línea de texto");
			mensaje = teclado.nextLine();
						
			System.out.println("Cliente: Enviando una línea de texto al servidor");
			pw.println(mensaje);
			pw.flush();
			
			System.out.println("Cliente: Recibiendo una línea de texto del servidor");
			mensajeMayusculas = br.readLine();
			
			System.out.println("mensaje recibido del servidor "+ mensajeMayusculas);
					
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}


