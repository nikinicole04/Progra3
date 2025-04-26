public class Compra {
    private String nombrecliente;
    private int cantidadentradas;
    private String nombrepelicula;

    public Compra(String nombrecliente, int cantidadentradas, String nombrepelicula) {
        this.nombrecliente = nombrecliente;
        this.cantidadentradas = cantidadentradas;
        this.nombrepelicula = nombrepelicula;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public int getCantidadentradas() {
        return cantidadentradas;
    }

    public void setCantidadentradas(int cantidadentradas) {
        this.cantidadentradas = cantidadentradas;
    }

    public String getNombrepelicula() {
        return nombrepelicula;
    }

    public void setNombrepelicula(String nombrepelicula) {
        this.nombrepelicula = nombrepelicula;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "nombrecliente='" + nombrecliente + '\'' +
                ", cantidadentradas=" + cantidadentradas +
                ", nombrepelicula='" + nombrepelicula + '\'' +
                '}';
    }
}