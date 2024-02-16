package exchanger;

import java.util.concurrent.Exchanger;

public class Actividad2 implements Runnable {
	 private  Exchanger<String> exchanger; 

	    
	    public Actividad2(Exchanger<String> exchanger) {

	        this.exchanger = exchanger;
	    }
	    

	    
	    
	    public void run() {

	        try {
	                     
	        	String mensajeRecibido = exchanger.exchange("Mensaje enviado por Actividad2");

	        	System.out.println("Mensaje recibido en Actividad 2 "+ mensajeRecibido) ;
	        	
	        	
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }

	    }


}
