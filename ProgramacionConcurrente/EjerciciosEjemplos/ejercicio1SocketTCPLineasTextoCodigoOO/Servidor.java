package ejercicio1SocketTCPLineasTextoCodigoOO;

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
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private Socket socketCliente;
	private ServerSocket serverSocket;
	private InputStream is;
	private OutputStream os;
	private BufferedReader br;
	private PrintWriter pw;
	private int numPuerto; /*Por donde escucha el servidor*/
	private final static int MIN_NUM_PUERTO = 1023;


	public Servidor() {
		super();
		try {
			serverSocket = new ServerSocket();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public Servidor(int numPuerto) {
		super();
		if (numPuerto>=MIN_NUM_PUERTO) {
			this.numPuerto = numPuerto;
	
			try {
				serverSocket = new ServerSocket(numPuerto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void enlazar(int numPuerto) {
		
		try {
			if (serverSocket!=null)
					serverSocket.bind(new InetSocketAddress("localhost", numPuerto));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	/**
	 *  Abre la conexión con un cliente
	 */
	public void start() {
			 
		try {
			
			if (serverSocket!=null) {
					System.out.println("Servidor: Esperando Conexiones");
					socketCliente= serverSocket.accept();			
					System.out.println("Servidor: Conexión Establecida");
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		 }
	
	/**
	 *  Cierra la conexión con el cliente
	 */
	public void close() {
			 
		try {
			
			if (serverSocket!=null) {
					serverSocket.close();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		 }
	
	/**
	 *  Abre los flujos de comunicación con dicho cliente
	 */
	public void abrirCanalesDatos() {
		
		System.out.println("Servidor: Creando los streams");
		/*Crear los flujos de datos para la comunicacion*/
		try {
			if (socketCliente!=null){
				is= socketCliente.getInputStream();		
				os= socketCliente.getOutputStream();		
		
				/*Permite leer y escribir Líneas de texto*/
		
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os,true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  Cerrar los flujos de comunicación con dicho cliente
	 */
	public void cerrarCanalesDatos() {
		
		System.out.println("Servidor: Cerrando los streams");
		/*Crear los flujos de datos para la comunicacion*/
		try {
			if (is!=null && os!=null && br!=null && pw!=null ){
				is.close();
				os.close();						
				br.close();
				pw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void enviarMensajeTexto(String mensaje) {
		
		System.out.println("Servidor: Enviando Mensaje");
		
		if (pw!=null && mensaje!=null)
			pw.write(mensaje);
		
		
		
	}
	
	public String recibirMensajeTexto() {
		String resultado=null;
		System.out.println("Servidor: Recibiendo Mensaje");
		if (br!=null)
			try {
				resultado= br.readLine();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		
		return resultado;
		
		
		
	}
	
	

	public static void main(String[] args) {
		
		int numPuerto= 2060;
		String mensaje;
				
		Servidor s= new Servidor(numPuerto);
		boolean LISTENING= true;
		
		if (s!=null) {
		 
			
			while (LISTENING) {
				s.start();
				s.abrirCanalesDatos();

				s.enviarMensajeTexto("Hola soy el servidor");
							
				s.cerrarCanalesDatos();
			
		}
			System.out.println("Servidor: FIN");
			s.close();
			
		
	}

 }
}
