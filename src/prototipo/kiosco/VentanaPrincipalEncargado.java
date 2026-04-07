package prototipo.kiosco;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Ventana principal del prototipo. Usa CardLayout para la navegación simple.
 */
public class VentanaPrincipalEncargado extends JFrame implements NavegadorPantallas {

    public static final String MENU_PRINCIPAL = "menu_principal";
    public static final String APERTURA_CUENTA = "apertura_cuenta";
    public static final String CONSUMO_PERSONAL = "consumo_personal";
    public static final String CIERRE_CAJA = "cierre_caja";
    public static final String CONSULTA_PRODUCTOS = "consulta_productos";

    private final CardLayout cardLayout;
    private final JPanel contenedorPantallas;

    public VentanaPrincipalEncargado() {
        super("Prototipo Encargado - Kiosco San Antonio");
        this.cardLayout = new CardLayout();
        this.contenedorPantallas = new JPanel(cardLayout);

        inicializarVentana();
        inicializarPantallas();
    }

    private void inicializarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 640);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(contenedorPantallas, BorderLayout.CENTER);
    }

    private void inicializarPantallas() {
        contenedorPantallas.add(new PanelMenuPrincipal(this), MENU_PRINCIPAL);
        contenedorPantallas.add(new PanelAperturaCuenta(this), APERTURA_CUENTA);
        contenedorPantallas.add(new PanelConsumoPersonal(this), CONSUMO_PERSONAL);
        contenedorPantallas.add(new PanelCierreCaja(this), CIERRE_CAJA);
        contenedorPantallas.add(new PanelConsultaProductos(this), CONSULTA_PRODUCTOS);

        mostrarPantalla(MENU_PRINCIPAL);
    }

    @Override
    public void mostrarPantalla(String nombrePantalla) {
        cardLayout.show(contenedorPantallas, nombrePantalla);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipalEncargado().setVisible(true));
    }
}
