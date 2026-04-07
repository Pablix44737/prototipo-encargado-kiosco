package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

        String[] columnas = {"Concepto", "Cantidad", "Monto"};
        Object[][] datos = {
            {"Ventas en efectivo", 128, "$ 482.350"},
            {"Ventas con débito", 74, "$ 261.900"},
            {"Ventas con crédito", 39, "$ 184.750"},
            {"Gastos menores", 6, "$ 17.200"},
            {"Total neto", "-", "$ 911.800"}
        };

        JTable tabla = new JTable(new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

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
}
