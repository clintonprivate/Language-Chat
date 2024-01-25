/*
 * We will use the website languagetool.org to check for grammar errors when chatting with the AI.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class App {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {  
		// Create the window
		JFrame f = new JFrame();
		f.setTitle("Language Chat");
		f.setSize(500,400);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// User answer space
		JTextArea answerSpace = new JTextArea();
		answerSpace.setBounds(20, 590, 1230, 40);
		Font font2 = new Font("Arial", Font.BOLD, 18);
		answerSpace.setFont(font2);
		answerSpace.setLineWrap(true);
		answerSpace.setWrapStyleWord(true);
		answerSpace.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Enter key pressed!");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
		f.add(answerSpace);
		
		// Create first message box
		MessageBubble firstMessage = new MessageBubble("Please wait...", "ai");
		f.add(firstMessage);
		
        // Adjust window settings
		f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		// Begin the conversation
		Conversation conversation = new Conversation();
		String introduction = conversation.introduction;
		firstMessage.setText(introduction);
		//conversation.startConversation();
	}
}
