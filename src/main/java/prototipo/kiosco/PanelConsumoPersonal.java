package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelConsumoPersonal extends JPanel {

    public PanelConsumoPersonal(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 16));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Registro de consumo personal");
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setOpaque(false);
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        JLabel aclaracion = new JLabel("Registro anónimo: ingresá el código del producto y la cantidad consumida.");
        aclaracion.setFont(EstilosUI.fuenteNormal());
        aclaracion.setAlignmentX(LEFT_ALIGNMENT);
        centro.add(aclaracion);
        centro.add(Box.createVerticalStrut(14));

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(215, 220, 230)),
            BorderFactory.createEmptyBorder(18, 18, 18, 18)));
        formulario.setOpaque(false);
        formulario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 260));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtitulo = new JLabel("Carga de consumo");
        subtitulo.setFont(EstilosUI.fuenteSubtitulo());
        subtitulo.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        formulario.add(subtitulo, gbc);

        gbc.gridwidth = 1;
        JTextField txtCodigoProducto = new JTextField(18);
        JTextField txtCantidad = new JTextField("1", 10);

        agregarFila(formulario, gbc, 1, "Código de producto:", txtCodigoProducto);
        agregarFila(formulario, gbc, 2, "Cantidad:", txtCantidad);

        centro.add(formulario);
        centro.add(Box.createVerticalGlue());
        add(centro, BorderLayout.CENTER);

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
