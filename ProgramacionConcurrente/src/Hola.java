import java.io.IOException;

public class Hola {

	public static void main(String[] args) {
		System.out.println("Hola");
	
		
		try {
			new ProcessBuilder().command("notepad.exe", "hola.txt").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
