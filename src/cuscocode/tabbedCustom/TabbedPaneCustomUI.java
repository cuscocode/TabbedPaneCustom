package cuscocode.tabbedCustom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author RAVEN
 */
public class TabbedPaneCustomUI extends BasicTabbedPaneUI {

    private final TabbedPaneCustom tab;

    public TabbedPaneCustomUI(TabbedPaneCustom tab) {
        this.tab = tab;
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        tab.setFont(tab.getFont().deriveFont(14f));
        tab.setOpaque(false);
        tab.setBackground(new Color(240, 240, 240)); // Fondo gris claro para todo el área del contenido
    }

    @Override
    protected Insets getTabInsets(int tabPlacement, int tabIndex) {
        return new Insets(5, 15, 5, 15); // Reducimos el padding de las pestañas para que sean menos altas
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Bordes redondeados en las pestañas
        g2.setColor(isSelected ? tab.getSelectedTabBorderColor() : tab.getUnselectedTabBorderColor());
        g2.drawRoundRect(x, y, width, height, 20, 20);

        g2.dispose();
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // No pintamos el indicador de foco
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Protegemos contra errores de índice
        int tabCount = tabPane.getTabCount();
        if (selectedIndex >= 0 && selectedIndex < tabCount) {
            for (int i = tabCount - 1; i >= 0; i--) {
                if (i != selectedIndex) {
                    paintTabBackground(g2, i, false);
                }
            }
            paintTabBackground(g2, selectedIndex, true);
        }
        
        g2.dispose();
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    protected void paintTabBackground(Graphics2D g2, int index, boolean selected) {
        Rectangle rec = getTabBounds(tabPane, index);
        Color color = getTabColor(selected);
        g2.setColor(color);
        Shape shape = createTabShape(rec);
        g2.fill(shape);
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        // Eliminar el borde del contenido
    }

    private Shape createTabShape(Rectangle rec) {
        int x = rec.x;
        int y = rec.y;
        int width = rec.width;
        int height = rec.height;
        int arc = 20; // Radio para los bordes redondeados
        return new RoundRectangle2D.Double(x, y, width, height, arc, arc);
    }

    private Color getTabColor(boolean selected) {
        return selected ? tab.getSelectedTabColor() : tab.getUnselectedTabColor();
    }
}