import javax.swing.*;
import java.awt.*;

public class ShapeIcon implements Icon {
    private Shape shape;
    private Color color;
    private boolean antiAliasing = true;

    public ShapeIcon(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public int getIconWidth() {
        Rectangle bounds = shape.getBounds();
        return bounds.width;
    }

    @Override
    public int getIconHeight() {
        Rectangle bounds = shape.getBounds();
        return bounds.height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        if (antiAliasing)
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle bounds = shape.getBounds();
        g2d.translate(x - bounds.x, y - bounds.y);
        g2d.setColor(color);
        g2d.fill(shape);

        g2d.dispose();
    }
}