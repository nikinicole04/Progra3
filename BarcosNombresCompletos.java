public class BarcosNombresCompletos {

    private String matricula;
    private String marca;
    private int anio;
    private String tipo; // "Velero", "Yate" o "Lancha"

    //Constructor por parametros
    public BarcosNombresCompletos(String matricula, String marca, int anio, String tipo) {
        this.matricula = matricula;
        this.marca = marca;
        this.anio = anio;
        this.tipo = tipo;
    }

    //Constructor por defecto
    public BarcosNombresCompletos() {
        this.matricula = ("MTR000");
        this.marca = ("Desconocida");
        this.anio = 2010;
        this.tipo = ("Yate");
}
//Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    // Metodo toString que muestra información básica
    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Marca: " + marca + ", Anio: " + anio + ", Tipo: " + tipo;
    }

    // Metodo para mostrar una descripción más completa, incluyendo el costo de amarre
    public String toStringCompleto() {
        int antiguedad = 2024 - anio; // Suponiendo que el año actual es 2024
        double costoAmarre = 0;

        // Calculamos el costo de amarre según el tipo de barco
        if (tipo=="Velero") {
            costoAmarre = antiguedad * 200;
        } else if (tipo=="Yate") {
            costoAmarre = antiguedad * 300;
        } else if (tipo=="Lancha") {
            costoAmarre = antiguedad * 100;
        }

        //return "Matricula: " + matricula + ", Marca: " + marca + ", Anio: " + anio + ", Tipo: " + tipo +
          //      ", Antiguedad: " + antiguedad + " años, Costo de Amarre: $" + costoAmarre;
        return this.toString()+ ", Costo de Amarre: $" + costoAmarre;
    }
}