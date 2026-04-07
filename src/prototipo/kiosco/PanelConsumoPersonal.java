package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConsumoPersonal extends JPanel {

    public PanelConsumoPersonal(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 16));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Registro de consumo personal");
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JComboBox<String> cmbEmpleado = new JComboBox<>(new String[]{"Juan Pérez", "Ana Rodríguez", "Carlos Suárez"});
        JComboBox<String> cmbProducto = new JComboBox<>(new String[]{"Gaseosa 500ml", "Alfajor triple", "Snack papas", "Agua mineral 1.5L"});
        JTextField txtCantidad = new JTextField("1", 10);
        JTextField txtFecha = new JTextField("07/04/2026", 12);

        agregarFila(formulario, gbc, 0, "Empleado:", cmbEmpleado);
        agregarFila(formulario, gbc, 1, "Producto:", cmbProducto);
        agregarFila(formulario, gbc, 2, "Cantidad:", txtCantidad);
        agregarFila(formulario, gbc, 3, "Fecha:", txtFecha);

        add(formulario, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        acciones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.MENU_PRINCIPAL));

        JButton btnRegistrar = EstilosUI.crearBotonPrincipal("Registrar consumo");
        btnRegistrar.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Consumo registrado correctamente (simulación).", "Acción simulada", JOptionPane.INFORMATION_MESSAGE));

        acciones.add(btnVolver);
        acciones.add(btnRegistrar);
        add(acciones, BorderLayout.SOUTH);
    }

    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, java.awt.Component campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        JLabel label = new JLabel(etiqueta);
        label.setFont(EstilosUI.fuenteSubtitulo());
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(campo, gbc);
    }
}
