package cuscocode.tabbedCustom;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTabbedPane;
import java.beans.BeanProperty;

/**
 *
 * @author CUSCOCODE
 */
public class TabbedPaneCustom extends JTabbedPane implements Serializable {

    private static final long serialVersionUID = 1L;

    private Color selectedTabColor = new Color(31, 186, 184); // Color por defecto para la pestaña seleccionada
    private Color unselectedTabColor = Color.WHITE; // Color por defecto para las pestañas no seleccionadas
    private Color selectedTabBorderColor = new Color(31, 186, 184); // Color del borde de la pestaña seleccionada
    private Color unselectedTabBorderColor = new Color(31, 186, 184); // Color del borde de las pestañas no seleccionadas
    private Color contentBorderColor = Color.GRAY; // Color del borde del contenido

    public TabbedPaneCustom() {
        setUI(new TabbedPaneCustomUI(this));
        setOpaque(false);
    }

    @BeanProperty(description = "Color of the selected tab")
    public Color getSelectedTabColor() {
        return selectedTabColor;
    }

    public void setSelectedTabColor(Color selectedTabColor) {
        this.selectedTabColor = selectedTabColor;
        repaint();
    }

    @BeanProperty(description = "Color of the unselected tabs")
    public Color getUnselectedTabColor() {
        return unselectedTabColor;
    }

    public void setUnselectedTabColor(Color unselectedTabColor) {
        this.unselectedTabColor = unselectedTabColor;
        repaint();
    }

    @BeanProperty(description = "Border color of the selected tab")
    public Color getSelectedTabBorderColor() {
        return selectedTabBorderColor;
    }

    public void setSelectedTabBorderColor(Color selectedTabBorderColor) {
        this.selectedTabBorderColor = selectedTabBorderColor;
        repaint();
    }

    @BeanProperty(description = "Border color of the unselected tabs")
    public Color getUnselectedTabBorderColor() {
        return unselectedTabBorderColor;
    }

    public void setUnselectedTabBorderColor(Color unselectedTabBorderColor) {
        this.unselectedTabBorderColor = unselectedTabBorderColor;
        repaint();
    }

    @BeanProperty(description = "Border color of the content area")
    public Color getContentBorderColor() {
        return contentBorderColor;
    }

    public void setContentBorderColor(Color contentBorderColor) {
        this.contentBorderColor = contentBorderColor;
        repaint();
    }
}