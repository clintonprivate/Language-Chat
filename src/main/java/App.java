/*
 * We will use the website languagetool.org to check for grammar errors when chatting with the AI.
 */

import java.awt.*;
import javax.swing.*;

public class App {
	public static void main(String[] args) {  
		// Create the window
		JFrame f = new JFrame();
		f.setTitle("Language Chat");
		f.setSize(500,400);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
		// Personal question text
		JLabel personalQuestion = new JLabel("Was ist eine deiner stolzesten Errungenschaften oder Momente in deinem Leben bisher?");
		personalQuestion.setBounds(20, 0, 1000, 50);
		Font font = new Font("Arial", Font.BOLD, 20);
		personalQuestion.setFont(font);
		personalQuestion.setForeground(Color.blue);
		f.add(personalQuestion);
		
		// User answer space
		JTextArea answerSpace = new JTextArea();
		answerSpace.setBounds(20, 50, 1000, 500);
		Font font2 = new Font("Arial", Font.BOLD, 18);
		answerSpace.setFont(font2);
		answerSpace.setLineWrap(true);
		answerSpace.setWrapStyleWord(true);
		f.add(answerSpace);
		
        // Adjust window settings
		f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		// Start conversation
		Conversation conversation = new Conversation();
		conversation.startConversation();
	}
}
