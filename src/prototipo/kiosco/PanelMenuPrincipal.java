package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenuPrincipal extends JPanel {

    public PanelMenuPrincipal(NavegadorPantallas navegador) {
        setLayout(new BorderLayout(0, 24));
        EstilosUI.aplicarMargenGeneral(this);

        JLabel titulo = new JLabel("Menú Principal - Encargado", SwingConstants.CENTER);
        titulo.setFont(EstilosUI.fuenteTitulo());
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(4, 1, 0, 16));
        centro.setOpaque(false);

        JButton btnApertura = EstilosUI.crearBotonPrincipal("Aprobar/Rechazar apertura de cuenta corriente");
        btnApertura.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.APERTURA_CUENTA));

        JButton btnConsumo = EstilosUI.crearBotonPrincipal("Registrar consumo personal");
        btnConsumo.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.CONSUMO_PERSONAL));

        JButton btnCierre = EstilosUI.crearBotonPrincipal("Visualizar cierre de caja");
        btnCierre.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.CIERRE_CAJA));

        JButton btnConsulta = EstilosUI.crearBotonPrincipal("Consultar productos consumidos y vencidos");
        btnConsulta.addActionListener(e -> navegador.mostrarPantalla(VentanaPrincipalEncargado.CONSULTA_PRODUCTOS));

        centro.add(btnApertura);
        centro.add(btnConsumo);
        centro.add(btnCierre);
        centro.add(btnConsulta);

        add(centro, BorderLayout.CENTER);
    }
}
