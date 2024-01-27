import java.awt.Color;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;

@SuppressWarnings("serial")
public class RoundedBorder extends AbstractBorder {
	private final Color color;
    private final int radius;

    public RoundedBorder(Color color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius);
        g2d.setColor(color);
        g2d.draw(roundRect);

        g2d.dispose();
    }
}
