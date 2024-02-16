package exchanger;

import java.util.concurrent.Exchanger;

public class Intercambiador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exchanger<String> exchanger = new Exchanger<String>();
		
		new Thread (new Actividad1(exchanger)).start() ;
		
		new Thread (new Actividad2(exchanger)).start() ;

	}

}
