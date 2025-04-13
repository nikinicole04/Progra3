import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboMarca;
    private JTextField txtAnio;
    private JButton btnEncolar;
    private JButton btnDesencolar;
    private JTextArea txtListado;
    private JLabel lblPago;
    private ColaAutos autos=new ColaAutos();
    public Ventana() {
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String marca=cboMarca.getSelectedItem().toString();
                    String anioTexto = txtAnio.getText().trim();

                    if (anioTexto.isEmpty()){
                        throw new IllegalArgumentException("Debes ingresar un año");
                    }
                    int anio;
                    try {
                        anio = Integer.parseInt(anioTexto);
                    } catch (NumberFormatException ex) {
                        // Se usa IllegalArgumentException porque es una excepción mas precisa porque indica que un argumento
                        // proporcionado a un metodo no es válido
                        throw new IllegalArgumentException("El año debe ser un número válido");
                    }
                    if (anio > 2025) {
                        throw new IllegalArgumentException("El año no puede ser mayor a 2025");
                    }
                    autos.encolar(new Auto(marca,anio));
                    txtListado.setText(autos.listatodos());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Auto atendido=autos.desencolar();
                    int anio = atendido.getAnio();
                    int pago = 50 + (2025 - anio) * 50;
                    lblPago.setText("Último auto atendido: \n"  + atendido.toString() + "\t Pago: \n$" + pago);
                    txtListado.setText(autos.listatodos());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        //frame.pack();
        frame.setVisible(true);
    }
}
