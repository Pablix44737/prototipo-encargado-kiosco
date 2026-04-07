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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelConsultaProductos extends JPanel {

    public PanelConsultaProductos(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 16));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Consulta de productos consumidos y vencidos");
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel filtroYTabla = new JPanel(new BorderLayout(0, 12));
        filtroYTabla.setOpaque(false);

        JPanel filtros = new JPanel(new GridBagLayout());
        filtros.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtDesde = new JTextField("01/04/2026", 10);
        JTextField txtHasta = new JTextField("07/04/2026", 10);
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Todos", "Consumidos", "Vencidos"});

        agregarFiltro(filtros, gbc, 0, "Desde:", txtDesde);
        agregarFiltro(filtros, gbc, 1, "Hasta:", txtHasta);
        agregarFiltro(filtros, gbc, 2, "Tipo:", cmbTipo);

        JButton btnFiltrar = EstilosUI.crearBotonPrincipal("Filtrar (simulado)");
        btnFiltrar.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Filtro aplicado en modo simulación.", "Acción simulada", JOptionPane.INFORMATION_MESSAGE));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        filtros.add(btnFiltrar, gbc);

        filtroYTabla.add(filtros, BorderLayout.NORTH);

        String[] columnas = {"Fecha", "Producto", "Tipo", "Cantidad", "Estado"};
        Object[][] datos = {
            {"01/04/2026", "Yogur bebible", "Consumido", 4, "Ok"},
            {"02/04/2026", "Galletitas saladas", "Consumido", 7, "Ok"},
            {"04/04/2026", "Barra cereal", "Vencido", 3, "Retirado"},
            {"06/04/2026", "Leche chocolatada", "Vencido", 2, "Pendiente"},
            {"07/04/2026", "Agua saborizada", "Consumido", 5, "Ok"}
        };

        JTable tabla = new JTable(new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false);

        filtroYTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(filtroYTabla, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        acciones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.MENU_PRINCIPAL));
        acciones.add(btnVolver);

        add(acciones, BorderLayout.SOUTH);
    }

    private void agregarFiltro(JPanel panel, GridBagConstraints gbc, int x, String etiqueta, java.awt.Component campo) {
        gbc.gridheight = 1;
        gbc.gridx = x;
        gbc.gridy = 0;
        gbc.weightx = 0;

        JLabel label = new JLabel(etiqueta);
        label.setFont(EstilosUI.fuenteSubtitulo());
        panel.add(label, gbc);

        gbc.gridy = 1;
        gbc.weightx = 1;
        panel.add(campo, gbc);
    }
}
