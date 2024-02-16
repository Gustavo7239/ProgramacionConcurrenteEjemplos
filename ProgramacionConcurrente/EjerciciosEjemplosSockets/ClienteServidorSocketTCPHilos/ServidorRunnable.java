package ClienteServidorSocketTCPHilos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServidorRunnable implements Runnable{
	
	private Socket socket;

	public ServidorRunnable(Socket socket) {
		super();
		this.socket = socket;
	}

	
	public void run() {
		if (socket!=null) {
		
			System.out.println("Servidor: Creo los streams para comunicarme con el cliente");
			try {
				InputStream is =socket.getInputStream();
				//OutputStream os = socket.getOutputStream();		
			
				/*Permite leer y escribir Líneas de texto*/
			
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
				
				//leemos el mensaje que ha enviado el cliente
				if (br!=null)
					System.out.println("Servidor: La cadena leida es: " + br.readLine());
				
				br.close();
				is.close();
				socket.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			

	   	
		
	}
	
	
	
	
	
	
	

}
