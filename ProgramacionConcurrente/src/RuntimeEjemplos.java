import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RuntimeEjemplos {

	public static void main(String[] args) {
		
		ejecutaComando("cmd /c dor");
		
	}
	
	
	
	/*
	 * ejecutaComando("cmd /c dir");
	 */
	private static void ejecutaComando(String comando) {
		try {
			
			Process process;
			process = Runtime.getRuntime().exec(comando);
			representaEnTerminal(process);
			int exitVal = 0;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			String buff = null;
			while((buff = br.readLine()) != null) {
				System.out.println("Linea leida: "+ buff);
			}
			
			while((buff = brError.readLine()) != null) {
				System.out.println("ERROR: "+ buff);
			}
			
			exitVal = process.waitFor();
			System.out.println("Valor de salida: "+ exitVal);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}




	/*
	 * representaEnTerminalRuntime();
	 */
	private static void representaEnTerminalRuntime() {
		
		try {
			Process process;
			
			process = Runtime.getRuntime().exec("java -cp bin miPaquete.Hola2");
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String buff = null;
			while((buff = br.readLine()) != null) {
				System.out.println("Linea leida: "+ buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	

	
	/*
	 * representaEnTerminal(pb.start());
	 */
	private static void representaEnTerminal(Process process) {
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String buff = null;
		
		try {
			while((buff = br.readLine()) != null) {
				System.out.println("Linea leida: "+ buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void ejecutarClaseHolaDesdePaquete() {
		String Programa = "java.exe";
		String Nombre = "miPaquete.Hola2";
		String classpath = "C:\\Users\\Gustavo\\eclipse-workspace\\ProgramacionConcurrente\\bin";
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(new File(classpath));
		pb.command(Programa,Nombre);
		
		//pb.redirectError(new File("Errores.txt"));
		//pb.redirectOutput(new File("Salida.txt"));
		
		try {
			representaEnTerminal(pb.start());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private static void ejecutarClaseHola() {
		String Programa = "java.exe";
		String Nombre = "Hola";
		String classpath = "C:\\Users\\Gustavo\\eclipse-workspace\\ProgramacionConcurrente\\bin";
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(Programa,"-cp",classpath,Nombre);
		
		pb.redirectError(new File("Errores.txt"));
		pb.redirectOutput(new File("Salida.txt"));
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	/*
	 * processBuilderConAtributos("notepad.exe","datos.txt","C:\\Users\\Gustavo\\Desktop\\");
	 */
	private static void processBuilderConAtributos(String programa, String nombre, String ruta) {
		ProcessBuilder pb = new ProcessBuilder();
		
		pb.command(programa, nombre).directory(new File(ruta));
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/*
	 * processBuilderConDirectorioEstablecido("notepad.exe","datos.txt","C:\\Users\\Gustavo\\Desktop\\");
	 */
	private static void processBuilderConDirectorioEstablecido(String programa, String nombre, String ruta) {
		ProcessBuilder pb = new ProcessBuilder(programa, nombre);
		pb.directory(new File(ruta));
		
		System.out.println("Directorio: "+pb.directory());
		
		try {
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/*
	 * System.out.println("Valor de retorno:"+ processBuilderRetorna("notepad.exe", "datos.txt"));
	 */
	private static int processBuilderRetorna(String aplicacion, String nombre) {
		int valorRetorno = 0;
		Process p;
		
		try {
			
			p = new ProcessBuilder(aplicacion,nombre).start();
			valorRetorno = p.waitFor();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return valorRetorno;
	}


	/*
	 * List<String> comandos= new ArrayList();
		comandos.add("notepad.exe");
		procescBuilderConListaDeComandos(comandos);
	 */
	private static void procescBuilderConListaDeComandos(List<String> comandos) {
		ProcessBuilder pb = new ProcessBuilder(comandos);
		try {
			
			pb.start();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * processBuilderBasic("notepad.exe", "C:\\datos.exe");
	 */
	private static void processBuilderBasic(String aplicacion, String nombre) {
		ProcessBuilder pb = new ProcessBuilder(aplicacion, nombre);
		try {
			
			pb.start();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//TAMBIEN SE PUEDE USAR SIMPLEMENTE: new ProcessBuilder(aplicacion, nombre).start();
	}


	/**
	 * runtimeBasic("notepad.exe", "C:\\notas.txt");
	 */
	public static void runtimeBasic(String herramienta, String nombre) {
		Runtime run = Runtime.getRuntime();
		String array[] = new String[2];
		
		try {
			array[0] = herramienta;
			array[1] = nombre;
			run.exec(array);
			
			System.out.println("Abierto el archivo "+nombre);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
