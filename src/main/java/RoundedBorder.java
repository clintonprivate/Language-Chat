import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;

@SuppressWarnings("serial")
public class RoundedBorder extends AbstractBorder {

	private final Color borderColor;
    private final int radius;

    public RoundedBorder(int radius, Color borderColor) {
        this.borderColor = borderColor;
        this.radius = radius;
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Fill the rounded rectangle with the fill color
        g.setColor(borderColor);
        g.fillRoundRect(x, y, width - 1, height - 1, radius, radius);

        // Draw the rounded rectangle border with the border color
        g.setColor(borderColor);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = radius;
        return insets;
    }

}
