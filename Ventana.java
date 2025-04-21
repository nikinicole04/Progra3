import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtBarcos;
    private JButton btnCargar;
    private JButton btnCostos;
    private JButton btnMarca;
    private JTextField txtMarca;
    private JTextArea txtCopiaBarcos;
    private ColaBarcos mColaBarcos;

    public Ventana() {
        mColaBarcos = new ColaBarcos();

        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBarcos.setText(mColaBarcos.mostrarCola());
            }
        });
        btnCostos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //txtBarcos.setText(mColaBarcos.mostrarColaCompleto());
                JOptionPane.showMessageDialog(null, mColaBarcos.mostrarColaCompleto());
            }
        });
        btnMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColaBarcos mColaBarcosTemp;
                mColaBarcosTemp=mColaBarcos.copiarPorMarca(txtMarca.getText());
                txtCopiaBarcos.setText(mColaBarcos.mostrarCola());
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


