import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel CODIGO;

    public Ventana() {

        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pila pilas = new Pila();


                String texto = txtCodigo.getText();
                for(int i = 0; i < texto.length(); i++) {
                    char letra = texto.charAt(i);
                    if (letra == '(' || letra == ')'
                            || letra == '{' || letra == '}'
                            || letra == '[') {
                        //
                    } else {
                        if (letra == ',') {
                            char salida = pilas.extraer().charAt(0);
                            if (salida != '(') {
                                JOptionPane.showMessageDialog(null, "Codigo incorrecto");
                                return;

                            }
                        } else {
                            if (letra == ',') {
                                char salida = pilas.extraer().charAt(0);
                                if (salida != '(') {
                                    JOptionPane.showMessageDialog(null, "Codigo incorrecto");
                                    return;
                                }

                            }
                        }
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
