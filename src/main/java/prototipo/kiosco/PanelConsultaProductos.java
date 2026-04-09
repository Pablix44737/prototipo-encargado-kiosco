package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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

        String[] columnas = {
            "Nombre Producto",
            "Cantidad Consumida",
            "Cantidad Vencida",
            "Total por Producto",
            "Monto Total por Consumo ($)",
            "Monto Total por Vencidos ($)"
        };
        Object[][] datosBase = {
            {"Leche Entera 1L", 120, 15, 1.50},
            {"Yogur Frutilla 200g", 250, 30, 1.25},
            {"Pan Lactal Blanco", 180, 5, 2.50},
            {"Queso Cremoso 500g", 90, 2, 6.00}
        };

        Object[][] datos = new Object[datosBase.length][columnas.length];
        double totalConsumo = 0;
        double totalVencidos = 0;
        for (int i = 0; i < datosBase.length; i++) {
            String producto = (String) datosBase[i][0];
            int cantidadConsumida = (int) datosBase[i][1];
            int cantidadVencida = (int) datosBase[i][2];
            double precioUnitario = (double) datosBase[i][3];

            int totalPorProducto = cantidadConsumida + cantidadVencida;
            double montoConsumo = cantidadConsumida * precioUnitario;
            double montoVencidos = cantidadVencida * precioUnitario;

            totalConsumo += montoConsumo;
            totalVencidos += montoVencidos;

            datos[i][0] = producto;
            datos[i][1] = cantidadConsumida;
            datos[i][2] = cantidadVencida;
            datos[i][3] = totalPorProducto;
            datos[i][4] = formatearMonto(montoConsumo);
            datos[i][5] = formatearMonto(montoVencidos);
        }

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

        double totalPerdida = totalConsumo + totalVencidos;

        JPanel resumen = new JPanel(new GridBagLayout());
        resumen.setOpaque(false);
        GridBagConstraints gbcResumen = new GridBagConstraints();
        gbcResumen.insets = new Insets(2, 8, 2, 8);
        gbcResumen.gridx = 0;
        gbcResumen.gridy = 0;
        gbcResumen.anchor = GridBagConstraints.EAST;

        JLabel lblConsumo = new JLabel("Monto Total por Consumo: $" + formatearMonto(totalConsumo));
        lblConsumo.setFont(EstilosUI.fuenteSubtitulo());
        resumen.add(lblConsumo, gbcResumen);

        gbcResumen.gridy = 1;
        JLabel lblVencidos = new JLabel("Monto Total por Vencidos: $" + formatearMonto(totalVencidos));
        lblVencidos.setFont(EstilosUI.fuenteSubtitulo());
        resumen.add(lblVencidos, gbcResumen);

        gbcResumen.gridy = 2;
        JLabel lblPerdida = new JLabel("Total Pérdida: $" + formatearMonto(totalPerdida));
        lblPerdida.setFont(EstilosUI.fuenteSubtitulo());
        lblPerdida.setForeground(new Color(178, 34, 34));
        resumen.add(lblPerdida, gbcResumen);

        gbcResumen.gridy = 3;
        JLabel lblFechaEmision = new JLabel("Fecha de Emisión: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        lblFechaEmision.setFont(EstilosUI.fuenteNormal());
        resumen.add(lblFechaEmision, gbcResumen);

        gbcResumen.gridy = 4;
        JLabel lblRangoFecha = new JLabel("Rango de Fecha: " + txtDesde.getText() + " - " + txtHasta.getText());
        lblRangoFecha.setFont(EstilosUI.fuenteNormal());
        resumen.add(lblRangoFecha, gbcResumen);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        acciones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.MENU_PRINCIPAL));
        acciones.add(btnVolver);

        JPanel pie = new JPanel(new BorderLayout(0, 8));
        pie.setOpaque(false);
        pie.add(resumen, BorderLayout.CENTER);
        pie.add(acciones, BorderLayout.SOUTH);
        add(pie, BorderLayout.SOUTH);
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

    private static String formatearMonto(double monto) {
        return String.format(Locale.US, "%.2f", monto);
    }
}
