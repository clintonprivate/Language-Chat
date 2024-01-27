import javax.swing.*;
import javax.swing.text.Caret;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MessageBubble extends JPanel {

    private JTextArea label;

    public MessageBubble(String text) {
        setLayout(new BorderLayout());

        label = new JTextArea(text);
        label.setForeground(Color.white);
        label.setLineWrap(true);
        label.setBounds(0, 0, 615 - 20 * 2, 1);
        label.setOpaque(false);
        label.setEditable(false);
        label.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        Font font = new Font("Segoe UI Emoji", Font.PLAIN, 18);
		label.setFont(font);

        setBounds(20, 20, 615, label.getPreferredSize().height + 16);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setOpaque(false);
        add(label, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color to blue
        Color bubbleColor = new Color(2, 130, 194);
        g.setColor(bubbleColor);

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
