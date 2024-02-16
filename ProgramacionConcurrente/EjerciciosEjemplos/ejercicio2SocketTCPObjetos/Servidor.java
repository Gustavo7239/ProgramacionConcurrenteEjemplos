package ejercicio2SocketTCPObjetos;

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

public class Servidor {

	public static void main(String[] args) {
		
		Socket socket;
		ServerSocket serverSocket;
		
		InputStream is;
		OutputStream os;

		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		Persona p;		
		Persona p1;
		
		
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
			
			ois = new ObjectInputStream(is);
			oos = new ObjectOutputStream(os);
			
			
			
			/*Crear un objeto de la clase persona para enviar al cliente*/
			p=new Persona(30, "pepe");
			
			
			/*Envia al cliente el objeto persona creado*/
			System.out.println("Servidor: Enviando el objeto al cliente");
			oos.writeObject(p);	
			
			/*Recibe de nuevo el objeto modificado su edad*/
			
			try {
				p1= (Persona)ois.readObject();
				
				if (p1!=null) {
					System.out.println("persona con la edad cambiada");
					System.out.println(p1.toString());

				}
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			
			
			System.out.println("Servidor: Cerrando el socket");
			socket.close();
			
			System.out.println("Servidor: FIN");
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
