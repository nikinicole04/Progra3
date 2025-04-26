import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    private Queue<Compra> compras;
    public Cine(){
        compras=new LinkedList<Compra>();
    }
    public void encolar (Compra compra){
        compras.add(compra);
    }

    public String mostrarCompras() {
        StringBuilder sb = new StringBuilder();
        for (Compra c : compras) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
    public int contarSillas(String nombrepelicula) {
        int acumulador = 0;
        for (Compra c: compras) {
            if (c.getNombrepelicula().equals(nombrepelicula)) {
              acumulador = acumulador + c.getCantidadentradas();
            }
        }
        return 22 - acumulador;
    }
}
