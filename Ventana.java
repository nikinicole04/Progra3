import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtTexto;
    private JButton btnpush;
    private JButton btnpop;
    private JTextArea txtMostrar;
    private JLabel lblTexto;
    private JButton btnCima;

    private Pila data = new Pila();

    public Ventana() {
        // Inicialización de los componentes por esta vez decidí hacer la gráfica manualmente
        principal = new JPanel();
        txtTexto = new JTextField(20);
        btnpush = new JButton("Push");
        btnpop = new JButton("Pop");
        txtMostrar = new JTextArea(10, 30);
        lblTexto = new JLabel("Texto a agregar:");
        btnCima = new JButton("Ver Cima");

        // Agregar los componentes al panel se hace manualmente
        principal.add(lblTexto);
        principal.add(txtTexto);
        principal.add(btnpush);
        principal.add(btnpop);
        principal.add(txtMostrar);
        principal.add(btnCima);

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
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
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

    // Metodo para obtener el panel con los componentes
    public JPanel getPanel() {
        return principal;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Pila");
        frame.setContentPane(new Ventana().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true); // Muestra la ventana
    }
}
