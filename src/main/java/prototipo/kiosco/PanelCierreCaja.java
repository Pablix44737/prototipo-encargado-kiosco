package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelCierreCaja extends JPanel {

    public PanelCierreCaja(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 16));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Visualización de cierre de caja");
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel contenedorDetalle = new JPanel();
        contenedorDetalle.setOpaque(false);
        contenedorDetalle.setLayout(new BoxLayout(contenedorDetalle, BoxLayout.Y_AXIS));

        JPanel panelTablas = new JPanel(new GridLayout(1, 2, 16, 0));
        panelTablas.setOpaque(false);

        String[] columnas = {"Medio de pago", "Operaciones", "Monto"};

        Object[][] ingresos = {
            {"Efectivo", 128, "$ 482.350"},
            {"Transferencia", 67, "$ 255.900"},
            {"Total ingresos", "-", "$ 738.250"}
        };

        Object[][] egresos = {
            {"Efectivo", 9, "$ 21.700"},
            {"Transferencia", 5, "$ 9.950"},
            {"Total egresos", "-", "$ 31.650"}
        };

        panelTablas.add(crearPanelDetalle("Detalle de ingresos", columnas, ingresos));
        panelTablas.add(crearPanelDetalle("Detalle de egresos", columnas, egresos));

        JLabel lblTotalNeto = new JLabel("Monto total neto en caja: $ 706.600");
        lblTotalNeto.setFont(EstilosUI.fuenteTitulo());
        lblTotalNeto.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));

        contenedorDetalle.add(panelTablas);
        contenedorDetalle.add(lblTotalNeto);

        add(contenedorDetalle, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        acciones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.MENU_PRINCIPAL));

        JButton btnConfirmar = EstilosUI.crearBotonPrincipal("Confirmar cierre");
        btnConfirmar.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Cierre de caja confirmado (simulación).", "Acción simulada", JOptionPane.INFORMATION_MESSAGE));

        acciones.add(btnVolver);
        acciones.add(btnConfirmar);
        add(acciones, BorderLayout.SOUTH);
    }

    private JPanel crearPanelDetalle(String titulo, String[] columnas, Object[][] datos) {
        JPanel panel = new JPanel(new BorderLayout(0, 8));
        panel.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(EstilosUI.fuenteSubtitulo());
        panel.add(lblTitulo, BorderLayout.NORTH);

        JTable tabla = new JTable(new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false);

        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }
}
