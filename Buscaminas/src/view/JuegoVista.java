package view;

import model.casilla;
import java.util.Scanner;

public class JuegoVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrartablero(casilla[][] tablero) {
        System.out.print("  ");
        for (int col = 0; col < tablero[0].length; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int fila = 0; fila < tablero.length; fila++) {
            System.out.print((char)('A' + fila) + " ");
            for (int col = 0; col < tablero[fila].length; col++) {
                casilla casilla = tablero[fila][col];
                if (casilla.isDescubierta()) {
                    if (casilla.isMina()) System.out.print("X ");
                    else System.out.print(casilla.getMinasAlrededor() + " ");
                } else if (casilla.isMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("• ");
                }
            }
            System.out.println();
        }
    }

    public String pedirCoordenada() {
        System.out.print("Ingrese coordenada (ej: A5): ");
        return scanner.nextLine().toUpperCase();
    }

    public boolean preguntarMarcar() {
        System.out.print("¿Desea marcar la casilla como mina? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }
}
