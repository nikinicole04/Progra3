import java.util.*;

// Clase ColaBarcos que maneja la cola de objetos BarcosNombresCompletos
public class ColaBarcos {
    private Queue<BarcosNombresCompletos> cola;

    // Constructor de la clase ColaBarcos. Inicializa la cola y encola los barcos predeterminados.
    public ColaBarcos() {
        cola = new LinkedList<>();
        encolarBarcos(); // Metodo para encolar los barcos predeterminados
    }

    public ColaBarcos(boolean mOpt) {
        cola = new LinkedList<>();
    }

    // Metodo para encolar los barcos predeterminados.
    public void encolarBarcos() {
        // Encolamos un barco usando el constructor por defecto.
        cola.add(new BarcosNombresCompletos());

        // Encolamos 4 barcos más con datos específicos.
        cola.add(new BarcosNombresCompletos("MTR001", "Honda", 2015, "Velero"));
        cola.add(new BarcosNombresCompletos("MTR002", "Yamaha", 2020, "Yate"));
        cola.add(new BarcosNombresCompletos("MTR003", "Suzuki", 2018, "Lancha"));
        cola.add(new BarcosNombresCompletos("MTR004", "Honda", 2012, "Velero"));
    }

    // Metodo para agregar un barco a la cola.
    public void agregarBarco(BarcosNombresCompletos barco) {
        cola.add(barco);
    }

    // Metodo para eliminar un barco de la cola.
    public BarcosNombresCompletos eliminarBarco() throws Exception {
        // Verificamos si la cola está vacía antes de intentar desencolar.
        if (cola.isEmpty()) {
            throw new Exception("No hay barcos en la cola para eliminar.");
        }
        return cola.poll();
    }

    // Metodo para obtener el primer barco de la cola (sin eliminarlo).
    public BarcosNombresCompletos frente() throws Exception {
        // Verificamos si la cola está vacía antes de intentar acceder al primer elemento.
        if (cola.isEmpty()) {
            throw new Exception("No hay barcos en la cola.");
        }
        return cola.peek();
    }

    // Metodo para mostrar todos los barcos de la cola.
    public String mostrarCola() {
        // Verificamos si la cola está vacía.
        if (cola.isEmpty()) return "La cola está vacía.";

        // Usamos StringBuilder para construir el texto que representa la cola.
        StringBuilder sb = new StringBuilder();
        for (BarcosNombresCompletos barco : cola) {
            //sb.append(barco.toString()).append("\n");
            sb.append(barco.toString()).append("\n");
        }
        return sb.toString();
    }

    // Metodo para mostrar todos los barcos de la cola.
    public String mostrarColaCompleto() {
        // Verificamos si la cola está vacía.
        if (cola.isEmpty()) return "La cola está vacía.";

        // Usamos StringBuilder para construir el texto que representa la cola.
        StringBuilder sb = new StringBuilder();
        for (BarcosNombresCompletos barco : cola) {
            //sb.append(barco.toString()).append("\n");
            sb.append(barco.toStringCompleto()).append("\n");
        }
        return sb.toString();
    }

    // Metodo para calcular los costos de amarre de todos los barcos.
    public String calcularCostos() {
        // Verificamos si la cola está vacía.
        if (cola.isEmpty()) return "No hay barcos para calcular.";

        // Usamos StringBuilder para construir el texto con los resultados de los costos.
        StringBuilder sb = new StringBuilder();
        for (BarcosNombresCompletos barco : cola) {
            int anio = barco.getAnio();
            // Validamos si el año del barco es válido (entre 1950 y 2024).
            if (anio >= 1950 && anio <= 2024) {
                // Si es válido, agregamos la información completa del barco y el costo de amarre.
                sb.append(barco.toStringCompleto()).append("\n");
            } else {
                // Si el año es inválido, mostramos un error.
                sb.append("\nError: Año inválido para ").append(barco.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    // Metodo para copiar los barcos de una marca específica en una nueva cola.
    public ColaBarcos copiarPorMarca(String marcaBuscada) {
        // Creamos una nueva cola para los barcos que coincidan con la marca buscada.
        Queue<BarcosNombresCompletos> nuevaCola = new LinkedList<>();
        ColaBarcos mColaTemp= new ColaBarcos(true);
        // Iteramos sobre los barcos en la cola original.
        for (BarcosNombresCompletos barco : cola) {
            // Si la marca del barco coincide con la marca buscada (ignorando mayúsculas/minúsculas).
            if (barco.getMarca().equalsIgnoreCase(marcaBuscada)) {
                // Agregamos el barco a la nueva cola.
                mColaTemp.agregarBarco(barco);
            }
        }
        return mColaTemp;
    }

    // Metodo para mostrar los barcos de una cola específica.
    public String mostrarColaEspecifica(Queue<BarcosNombresCompletos> cola) {
        // Verificamos si la cola está vacía.
        if (cola.isEmpty()) return "No hay barcos con esa marca.";

        // Usamos StringBuilder para construir el texto con los barcos de la cola especificada.
        StringBuilder sb = new StringBuilder();
        for (BarcosNombresCompletos barco : cola) {
            sb.append(barco.toString()).append("\n");
        }
        return sb.toString();
    }
}
