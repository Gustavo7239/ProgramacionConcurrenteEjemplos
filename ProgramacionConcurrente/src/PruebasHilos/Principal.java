package PruebasHilos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        int n = 1;

        for (int i = 0; i < 10; i++) {
            Cliente c1 = new Cliente("ClientePrueba" + i);
            servidor.agregarCliente(c1);
        }

        servidor.iniciar();

        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Agregar nuevo cliente?");
            String valor = teclado.nextLine();

            if (valor.equals("si")) {
                Cliente c = new Cliente("Cliente " + n);
                servidor.agregarCliente(c);
                n++;
            }
        }
    }
}
