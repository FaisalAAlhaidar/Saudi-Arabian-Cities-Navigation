import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyWaypoint extends DefaultWaypoint {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MyWaypoint(String name, GeoPosition coord) {
        super(coord);
        this.name = name;
        UIManager.put("ToolTip.font", new FontUIResource("SansSerif", Font.PLAIN, 18));
        initButton();
    }

    public MyWaypoint() {
    }

    private String name;
    private JButton button;

    @Override
    public String toString() {
        return name;
    }
    private void initButton() {
        button = new ButtonWaypoint();
        button.setSize(15, 15);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        button.setToolTipText(getName());
    }
}
