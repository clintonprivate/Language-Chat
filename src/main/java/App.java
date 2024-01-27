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
		
		// Set the window color
        Color backgroundColor = new Color(240, 188, 60);
        f.getContentPane().setBackground(backgroundColor);
		
		// Create first message box
		MessageBubble firstMessage = new MessageBubble("Please wait...");
		f.add(firstMessage);
		
		// User answer space
		MessageInputBar messageInputBar = new MessageInputBar();
		f.add(messageInputBar);
		
        // Adjust window settings
		f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		// Begin the conversation
		Conversation conversation = new Conversation();
		String introduction = conversation.introduction;
		//firstMessage.setText(introduction);
		//conversation.startConversation();
	}
}
