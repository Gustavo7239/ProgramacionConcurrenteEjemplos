package exchanger;

import java.util.concurrent.Exchanger;

public class Actividad1 implements Runnable{
	
    private  Exchanger<String> exchanger; 

    
    public Actividad1(Exchanger<String> exchanger) {

        this.exchanger = exchanger;
    }
    

    
    
    public void run() {

        try {
                     
        	String mensajeRecibido = exchanger.exchange("Mensaje enviado por Actividad1");

        	System.out.println("Mensaje recibido en Actividad 1 "+ mensajeRecibido) ;
        	
        	
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
