package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAperturaCuenta extends JPanel {

    public PanelAperturaCuenta(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 16));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Apertura de cuenta corriente");
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtCliente = new JTextField("María González", 25);
        JTextField txtTelefono = new JTextField("3764411155", 25);
        JTextField txtDni = new JTextField("30456789", 25);
        JTextField txtLimite = new JTextField("60000", 25);

        agregarFila(formulario, gbc, 0, "Nombre cliente:", txtCliente);
        agregarFila(formulario, gbc, 1, "Teléfono:", txtTelefono);
        agregarFila(formulario, gbc, 2, "DNI cliente:", txtDni);
        agregarFila(formulario, gbc, 3, "Monto límite:", txtLimite);

        add(formulario, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        acciones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.MENU_PRINCIPAL));

        JButton btnRechazar = EstilosUI.crearBotonPrincipal("Rechazar");
        btnRechazar.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Solicitud rechazada (simulación).", "Acción simulada", JOptionPane.INFORMATION_MESSAGE));

        JButton btnAprobar = EstilosUI.crearBotonPrincipal("Aprobar");
        btnAprobar.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Solicitud aprobada (simulación).", "Acción simulada", JOptionPane.INFORMATION_MESSAGE));

        acciones.add(btnVolver);
        acciones.add(btnRechazar);
        acciones.add(btnAprobar);
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
