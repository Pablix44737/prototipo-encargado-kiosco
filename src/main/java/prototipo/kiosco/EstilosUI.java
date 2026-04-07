package prototipo.kiosco;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

/**
 * Utilidades visuales simples para mantener consistencia.
 */
public final class EstilosUI {

    public static final Color COLOR_FONDO = new Color(245, 247, 250);
    public static final Color COLOR_PRIMARIO = new Color(33, 97, 140);

    private EstilosUI() {
    }

    public static Font fuenteTitulo() {
        return new Font("SansSerif", Font.BOLD, 24);
    }

    public static Font fuenteSubtitulo() {
        return new Font("SansSerif", Font.BOLD, 16);
    }

    public static Font fuenteNormal() {
        return new Font("SansSerif", Font.PLAIN, 14);
    }

    public static void aplicarMargenGeneral(JComponent component) {
        component.setBorder(new EmptyBorder(20, 20, 20, 20));
        component.setBackground(COLOR_FONDO);
    }

    public static JButton crearBotonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(fuenteSubtitulo());
        boton.setFocusPainted(false);
        boton.setBackground(COLOR_PRIMARIO);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));
        return boton;
    }
}
