import javax.swing.*;
import java.awt.*;

public class MessageBubble extends JTextArea {
	private static final int DEFAULT_WIDTH = 615;
    private static final int DEFAULT_HEIGHT = 20;
    private static final double MAX_CHARACTERS_PER_LINE = 70;
	
	public MessageBubble(String text, String sender) {
		// Set the text to desired message
		super(text);
		
		// Set the font of the bubble
        Font font = new Font("Arial", Font.BOLD, 15);
		setFont(font);
		setForeground(Color.white);
		
		// Set the color of the bubble based on it's sender
		Color bubbleColor = null;
		if (sender.equals("ai")) {
			bubbleColor = new Color(2, 130, 194);
		}
		else if (sender.equals("user")) {
			bubbleColor = new Color(2, 194, 56);
		}
		setBackground(bubbleColor);
		
		// Set the position and size of the bubble depending on it's sender
		if (sender.equals("ai")) {
			setBounds(20, 20, DEFAULT_WIDTH, this.getPreferredSize().height);
		}
		else if (sender.equals("user")) {
			setBounds(20, 20, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}
		
		// Set the remaining settings of a message bubble
		this.setLineWrap(true);
    }
	
	@Override
    public void setText(String text) {
        super.setText(text);
        adjustHeight();
    }

    private void adjustHeight() {
    	String text = this.getText();
    	double characterLength = text.length();
    	double amountOfLines = Math.ceil(characterLength/MAX_CHARACTERS_PER_LINE);
    	double newHeight = DEFAULT_HEIGHT * amountOfLines;
    	setPreferredSize(new Dimension(DEFAULT_WIDTH, (int) newHeight));
    	setBounds(this.getBounds().x, this.getBounds().y, DEFAULT_WIDTH, (int) newHeight);
    }
	
}