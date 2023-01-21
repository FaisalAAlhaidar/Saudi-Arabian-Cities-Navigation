import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ButtonWaypoint extends JButton {

    public ButtonWaypoint() {
        setContentAreaFilled(false);
        Shape circle = new Ellipse2D.Double(0, 0, 8, 8);
        ShapeIcon icon = new ShapeIcon(circle, Color.BLACK);
        setIcon(icon);
        setSize(new Dimension(24, 24));
    }
}
