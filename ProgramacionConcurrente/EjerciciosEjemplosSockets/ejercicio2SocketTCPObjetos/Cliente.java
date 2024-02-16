package ejercicio2SocketTCPObjetos;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		Persona p;
		
			
		try {
			System.out.println("Cliente: Creando el socket");
			clienteSocket = new Socket();
			
			System.out.println("Cliente: Realizando la conexión al socket");
			clienteSocket.connect(new InetSocketAddress("localhost", 5555));						
			
			
			System.out.println("Cliente: Creo los streams para comunicarme con el servidor");
			is= clienteSocket.getInputStream();
			os= clienteSocket.getOutputStream();
		
			oos = new ObjectOutputStream(os);		
			ois = new ObjectInputStream(is);
		
			/*Cliente recibe el objeto que le ha enviado el servidor*/

			System.out.println("Cliente: Recibiendo el objeto del servidor");
			try {
				
				/*Imprimimos por pantalla el objeto recibido*/
				p = (Persona) ois.readObject();
				if (p!=null) {
					System.out.println(p.toString());
					
					/*Cambiamos la edad de la persona y se lo enviamos al servidr*/
					p.setEdad(32);
					oos.writeObject(p);		
					
					
				}
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			System.out.println("cliente: Cerrando el socket");
			clienteSocket.close();
			
			System.out.println("Cliente: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
