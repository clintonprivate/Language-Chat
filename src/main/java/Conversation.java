import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Conversation {
	
	private static String aiName = "Flynn";
	private static HelperMethods helperMethods = new HelperMethods();
	private static Grammar grammar = new Grammar();
	private static String firstPrompt = "Lets have a conversation, dont let the conversation die, if you sense its about to die ask me a question to keep it going, make your responses no more than a paragraph long, start by asking me what topic i would like to talk about today and pretend that your name is " + aiName + ", also use a lot of emojis to keep the conversation fun";
	static String introduction = "Worüber wollen wir reden? 🗣️✨";
	private static String prompt = firstPrompt;
	private static WebDriver driver;
	
	public Conversation() {
		// Show a loading text first so that the user is not confused while waiting.
		System.out.println("Loading...\n");
		
		// Go to the ChatGPT website
		FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        driver = new FirefoxDriver(options);
        driver.get("https://chataigpt.org/?utm_content=cmp-true");
        
        // Accept the terms and conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all")));
        acceptButton.click();
	}
	
	public static void startConversation() {
		// Let ChatGPT know that you want to have a conversation before introducing the AI
		askChatGPT(firstPrompt, driver);
		System.out.println("AI: " + introduction + "\n");
		
		while (true) {
			// Allow the user to talk to the AI
			Scanner scanner = new Scanner(System.in);
        	System.out.print("You: ");
            String userResponse = scanner.nextLine();
            String grammaticalErrors = grammar.checkGrammar(userResponse);
            System.out.println(grammaticalErrors);
            prompt = helperMethods.translateText(userResponse, "english");
        	
            // Let the AI respond back
            String aiResponse = helperMethods.translateText(askChatGPT(prompt, driver), "german");
            System.out.println("AI: " + aiResponse + "\n");
        }
	}
	
	private static String generateRandomString() {
		String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
	}
	
	private static String askChatGPT(String prompt, WebDriver driver) {
		// Type in the prompt
        WebElement textarea = driver.findElement(By.className("wpaicg-chat-shortcode-typing"));
        textarea.sendKeys(prompt);

        // Click the submit prompt button
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('wpaicg-chat-shortcode-send')[0].scrollIntoView();");
        js.executeScript("window.scrollBy(0, -200);");
        WebElement submitButton = driver.findElement(By.className("wpaicg-chat-shortcode-send"));
        submitButton.click();
        
        // Wait and then return the response
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("wpaicg-bot-thinking")));
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        List<WebElement> messages = driver.findElements(By.className("wpaicg-chat-message"));
        String response = messages.get(messages.size()-1).getAttribute("innerHTML");
        return response;
	}
}
