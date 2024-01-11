import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class Conversation {
	
	private static String firstPrompt = "Lets have a conversation, don't let the conversation die, if you sense its about to die ask me a question to keep it going, start with the most random topic and make your responses no more than a paragraph long";
	
	public static void startConversation() {
		// Create FirefoxOptions and set the profile
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("selenium");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("-headless");

        // Go to the ChatGPT website
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://chat.openai.com");
        
        // Start the conversation by asking the first prompt.
        System.out.println("AI: " + askChatGPT(firstPrompt, driver) + "\n");
        
        // Allow the user to respond and continue the conversation
        while (true) {
        	Scanner scanner = new Scanner(System.in);
        	System.out.print("You: ");
            String userResponse = scanner.nextLine();
            System.out.println("\nAI: " + askChatGPT(userResponse, driver) + "\n");
        }
	}
	
	private static String askChatGPT(String prompt, WebDriver driver) {
		// Submit the prompt
        WebElement textarea = driver.findElement(By.id("prompt-textarea"));
        textarea.sendKeys(prompt + Keys.ENTER);
        
        // Grab and return ChatGPT's response
        try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
        List<WebElement> messages = driver.findElements(By.className("markdown"));
        String response = messages.get(messages.size() - 1).getAttribute("innerText");
		return response;
	}
}
