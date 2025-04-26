import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cmbPelicula;
    private JButton btnComprar;
    private JTextArea txtMostrar;
    private JTextField txtNombre;
    private JTextField txtEntradas;
    private JTextArea txtDisponibilidad;
    private JTextField txtSillas;
    private JComboBox cmbSalas;
    private Cine comprar=new Cine();

    public Ventana() {

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pelicula=cmbPelicula.getSelectedItem().toString();
                    String nombrecliente = txtNombre.getText().trim();
                    String entradastexto =txtEntradas.getText().trim();
                    if(nombrecliente.isEmpty()){
                        throw new IllegalArgumentException("Debes ingresar un nombre");
                    }
                    int cantidadentradas;
                    try {
                        cantidadentradas=Integer.parseInt(entradastexto);
                    } catch (NumberFormatException ex){
                        throw new IllegalArgumentException("El usuario debe ingresar el número de entradas");
                    }
                    if (cantidadentradas<1||cantidadentradas>4){
                        throw new IllegalArgumentException("El cliente solo puede comprar 4 entradas");
                    }
                    if (comprar.contarSillas(pelicula) >= cantidadentradas){
                        comprar.encolar(new Compra(nombrecliente, cantidadentradas, pelicula));
                        txtMostrar.setText(comprar.mostrarCompras());
                        txtDisponibilidad.setText("XMEN:"+comprar.contarSillas("XMEN")+ "sillas"+ "\n"+
                                "BATMAN:"+comprar.contarSillas("BATMAN")+ "sillas"+ "\n"+
                                        "MARIO:"+comprar.contarSillas("MARIO")+ "sillas");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacio");
                    }
                } catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

