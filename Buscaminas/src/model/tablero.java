package model;

import java.util.Random;

public class tablero {
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int MINAS = 10;
    private casilla[][] tablero;

    public tablero() {
        tablero = new casilla[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new casilla();
            }
        }
        colocarMinas();
        calcularMinasAlrededor();
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < MINAS) {
            int fila = rand.nextInt(FILAS);
            int col = rand.nextInt(COLUMNAS);
            if (!tablero[fila][col].isMina()) {
                tablero[fila][col].setMina(true);
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAlrededor() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!tablero[i][j].isMina()) {
                    int minas = 0;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nx = i + dx, ny = j + dy;
                            if (nx >= 0 && ny >= 0 && nx < FILAS && ny < COLUMNAS && tablero[nx][ny].isMina()) {
                                minas++;
                            }
                        }
                    }
                    tablero[i][j].setMinasAlrededor(minas);
                }
            }
        }
    }

    public casilla[][] getTablero() {
        return tablero;
    }
}
