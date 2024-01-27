import javax.swing.*;
import javax.swing.text.Caret;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MessageInputBar extends JPanel {

    private JTextField label;

    public MessageInputBar() {
        setLayout(new BorderLayout());

        label = new JTextField();
        label.setForeground(Color.black);
        label.setBounds(0, 0, 1230 - 20 * 2, 1);
        label.setOpaque(false);
        label.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        label.setBorder(null);
        Font font = new Font("Arial", Font.PLAIN, 16);
		label.setFont(font);

        setBounds(20, 590, 1230, label.getPreferredSize().height + 20);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setOpaque(false);
        add(label, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color to blue
        g.setColor(Color.white);

        // Create a rounded rectangle with the same size as the panel
        Graphics2D g2d = (Graphics2D) g.create();
        int borderRadius = 50;
        int arcWidth = borderRadius;
        int arcHeight = borderRadius;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        g2d.dispose();
    }
}
