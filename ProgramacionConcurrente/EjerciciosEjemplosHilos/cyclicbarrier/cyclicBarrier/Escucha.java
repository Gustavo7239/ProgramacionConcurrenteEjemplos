package cyclicBarrier;

import java.sql.Date;
import java.time.LocalDateTime;

public class Escucha implements Runnable {
	
	
	public void run() {
		System.out.println(LocalDateTime.now().toString());
		}

}
