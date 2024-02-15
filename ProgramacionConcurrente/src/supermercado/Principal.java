package supermercado;

public class Principal {
	public static void main(String[] args) {
		Mercado supermercado = new Mercado();
		final int NUMERO_CLIENTES = 50;
		
		for(int i=1;i<=NUMERO_CLIENTES;i++) {
			supermercado.agregarCliente(new Cliente("Cliente "+i));
		}
		
		supermercado.iniciar();
		
		
		supermercado.agregarCliente(new Cliente("Cliente "+20));
	}
}
