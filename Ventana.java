import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;           // Panel principal del formulario
    private JTextField txtTexto;        // Campo para ingresar el texto
    private JButton btnpush;            // Botón para agregar a la pila
    private JButton btnpop;             // Botón para eliminar de la pila
    private JTextArea txtMostrar;       // Área donde se muestra la pila
    private JLabel lblTexto;            // campo de texto
    private JButton btnCima;            // Botón para mostrar la cima

    private Pila data = new Pila();     // Instancia de nuestra pila personalizada

    //  Constructor
    public Ventana() {
        // Acción para el botón "Push"
        btnpush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = txtTexto.getText().trim(); // Obtenemos el texto

                if (!texto.isEmpty()) {
                    try {
                        data.push(texto); // Intentamos agregar a la pila
                        txtTexto.setText(""); // Limpiamos el campo de texto
                        txtMostrar.setText(data.toString()); // Actualizamos la visualización
                    } catch (Exception ex) {
                        // Si se excede el límite, mostramos mensaje de error
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
                    // Si el texto está vacío, avisamos al usuario
                    JOptionPane.showMessageDialog(null, "Por favor, escribe un texto para agregar.");
                }
            }
        });

        // Acción para el botón "Pop"
        btnpop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String eliminado = data.pop(); // Quitamos el último elemento
                    JOptionPane.showMessageDialog(null, "Se eliminó: " + eliminado);
                    txtMostrar.setText(data.toString()); // Mostramos pila actualizada
                } catch (Exception ex) {
                    // Si la pila está vacía
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // Acción para el botón "Cima"
        btnCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cima = data.cima(); // Mostramos el último elemento sin quitarlo
                    JOptionPane.showMessageDialog(null, "En la cima está: " + cima);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    // Metodo main para ejecutar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Pila");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta al contenido
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true); // La muestra
    }
}
