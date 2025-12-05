package controller;

import model.tablero;
import model.casilla;
import view.JuegoVista;
import exceptions.CasillaYaDescubiertaException;

public class JuegoController {
    private tablero tablero;
    private JuegoVista vista;

    public JuegoController(tablero tablero, JuegoVista vista) {
        this.tablero = tablero;
        this.vista = vista;
    }

    public void jugar() {
        boolean jugando = true;
        while (jugando) {
            vista.mostrartablero(tablero.getTablero());
            String coord = vista.pedirCoordenada();
            try {
                int fila = coord.charAt(0) - 'A';
                int col = Integer.parseInt(coord.substring(1));

                casilla casilla = tablero.getTablero()[fila][col];
                if (casilla.isDescubierta()) throw new CasillaYaDescubiertaException("Casilla ya descubierta!");
                if (vista.preguntarMarcar()) {
                    casilla.setMarcada(!casilla.isMarcada());
                } else {
                    casilla.setDescubierta(true);
                    if (casilla.isMina()) {
                        System.out.println("¡BOOM! Perdiste.");
                        vista.mostrartablero(tablero.getTablero());
                        break;
                    } else if (casilla.getMinasAlrededor() == 0) {
                        descubrirVacias(fila, col);
                    }
                }

                if (verificarVictoria()) {
                    System.out.println("¡Felicidades! ¡Ganaste!");
                    vista.mostrartablero(tablero.getTablero());
                    break;
                }

            } catch (CasillaYaDescubiertaException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Coordenada inválida.");
            }
        }
    }

    private void descubrirVacias(int fila, int col) {
        if (fila < 0 || col < 0 || fila >= 10 || col >= 10) return;
        casilla c = tablero.getTablero()[fila][col];
        if (c.isDescubierta() || c.isMina()) return;
        c.setDescubierta(true);
        if (c.getMinasAlrededor() == 0) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) descubrirVacias(fila + dx, col + dy);
                }
            }
        }
    }

    private boolean verificarVictoria() {
        for (casilla[] fila : tablero.getTablero()) {
            for (casilla c : fila) {
                if (!c.isMina() && !c.isDescubierta()) return false;
            }
        }
        return true;
    }
}
