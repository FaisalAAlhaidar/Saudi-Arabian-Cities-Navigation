import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Arrays;

public class WaypointRender extends WaypointPainter<MyWaypoint> {
    private int[] currentSolution = null;

    @Override
    protected void doPaint(Graphics2D graphics2D, JXMapViewer map, int width, int height) {
        graphics2D = (Graphics2D) graphics2D.create();
        Rectangle rect = map.getViewportBounds();
        graphics2D.translate(-rect.x, -rect.y);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (MyWaypoint wp : getWaypoints()) {
            Point2D p = map.getTileFactory().geoToPixel(wp.getPosition(), map.getZoom());
            Rectangle rec = map.getViewportBounds();
            int x = (int) (p.getX() - rec.getX());
            int y = (int) (p.getY() - rec.getY());
            JButton cmd = wp.getButton();
            cmd.setBorderPainted(false);
            cmd.setLocation(x - cmd.getWidth() / 2 + 4, y - cmd.getHeight() / 2 + 4);
        }
        drawCurrentSolution(graphics2D, map);
    }

    private void drawCurrentSolution(Graphics2D graphics2D, JXMapViewer jxMapViewer) {
        if (currentSolution == null)
            return;
        int lastCity = currentSolution[0];
        Point2D pt, pt2;
        for (int i = 1; i < currentSolution.length; i++) {
            pt = jxMapViewer.getTileFactory().geoToPixel(new GeoPosition(Main.DICTIONARY.CityCoordinates.get(Main.DICTIONARY.rev.get(currentSolution[i])).getX(), Main.DICTIONARY.CityCoordinates.get(Main.DICTIONARY.rev.get(currentSolution[i])).getY()), jxMapViewer.getZoom());
            pt2 = jxMapViewer.getTileFactory().geoToPixel(new GeoPosition(Main.DICTIONARY.CityCoordinates.get(Main.DICTIONARY.rev.get(lastCity)).getX(), Main.DICTIONARY.CityCoordinates.get(Main.DICTIONARY.rev.get(lastCity)).getY()), jxMapViewer.getZoom());
            graphics2D.draw(new Line2D.Double(pt2.getX() + 4, pt2.getY() + 4, pt.getX() + 4, pt.getY() + 4));
            lastCity = currentSolution[i];
        }
    }

    public int[] getSolution() {
        if (currentSolution == null)
            return null;
        return Arrays.copyOf(currentSolution, currentSolution.length);
    }

    public void setSolution(int[] currentSolution) {
        if (currentSolution == null)
            this.currentSolution = null;
        else
            this.currentSolution = Arrays.copyOf(currentSolution, currentSolution.length);
    }
}
