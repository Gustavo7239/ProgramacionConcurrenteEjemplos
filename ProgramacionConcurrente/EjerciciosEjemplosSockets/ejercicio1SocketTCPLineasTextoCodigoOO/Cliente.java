package ejercicio1SocketTCPLineasTextoCodigoOO;

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
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	
	
	private Socket clienteSocket;
	private ServerSocket serverSocket;
	private InputStream is;
	private OutputStream os;
	private BufferedReader br;
	private PrintWriter pw;
	private int puertoServidor;
	private String ipServidor;
	private final static int MIN_NUM_PUERTO = 1023;
	
		
	
	public Cliente(int puertoServidor, String ipServidor) {
		if (puertoServidor>=MIN_NUM_PUERTO)
			this.puertoServidor = puertoServidor;
			
		this.ipServidor = ipServidor;
		
		
	}
	
	/**
	 *  Abre una conexion
	 */
	public void start() {
			 
		try {
			
				System.out.println("Cliente: Creando el socket");
				clienteSocket = new Socket();
				
				if (clienteSocket!=null) {
					System.out.println("Cliente: Realizando la conexión al socket");
					clienteSocket.connect(new InetSocketAddress(ipServidor, puertoServidor));
				}

		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		 }
	
	
	/**
	 *  Abre los flujos de comunicación con el servidor
	 */
	public void abrirCanalesDatos() {
		
		System.out.println("Cliente: Creando los streams");
		/*Crear los flujos de datos para la comunicacion*/
		try {
				is= clienteSocket.getInputStream();
				os= clienteSocket.getOutputStream();
			
				/*Permite leer y escribir Líneas de texto*/
				
				br = new BufferedReader(new InputStreamReader(is));				
				pw = new PrintWriter(os,true);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  Cerrar los flujos de comunicación con el servidor
	 */
	public void cerrarCanalesDatos() {
		
		System.out.println("Cliente: Cerrando los streams");
		/*Cerrar los flujos de datos para la comunicacion*/
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
	
	
	/**
	 *  Cierra  la conexion
	 */
	public void close() {
			 
		try {
			
				System.out.println("Cliente: Cerrando el socket");
				if (clienteSocket!=null)
					clienteSocket.close();
				
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		 }
	
	
	
	
	public void enviarMensajeTexto(String mensaje) {
		
		System.out.println("Cliente: Enviando Mensaje");
		if (pw!=null && mensaje!=null)
			pw.write(mensaje);

	}
	
	public String recibirMensajeTexto() {
		String resultado=null;
		System.out.println("Cliente: Recibiendo Mensaje");
		
		if (br!=null)
			try {
				resultado= br.readLine();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		
		return resultado;
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {

		
		Cliente c;
			
		c = new Cliente(2060, "localhost");
		c.start();
		c.abrirCanalesDatos();

		
		String mensaje = c.recibirMensajeTexto();
		System.out.println("Cliente: mensaje recibido del servidor: " + mensaje);
		
		
		c.cerrarCanalesDatos();
		c.close();
		
		System.out.println("Cliente: FIN");
		

	}

}
