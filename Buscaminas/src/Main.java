import model.tablero;
import view.JuegoVista;
import controller.JuegoController;

public class Main {
    public static void main(String[] args) {
        tablero tablero = new tablero();
        JuegoVista vista = new JuegoVista();
        JuegoController controller = new JuegoController(tablero, vista);
        controller.jugar();
    }
}
