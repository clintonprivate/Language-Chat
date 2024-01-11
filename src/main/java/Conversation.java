import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Conversation {
	
	private static String firstPrompt = "lets have a conversation, dont let the conversation die, if you sense its about to die ask me a question to keep it going, start with the most random topic and make your responses no more than a paragraph long";
	
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://chat.openai.com");
        
        // Accept the terms and conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all")));
        acceptButton.click();
        
        // Type in the conversation starting prompt
        WebElement textarea = driver.findElement(By.className("wpaicg-chat-shortcode-typing"));
        textarea.sendKeys(firstPrompt);
        
        // Submit the prompt
        Thread.sleep(5000);
        textarea.sendKeys(Keys.ENTER);
        
        // 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("wpaicg-bot-thinking")));
        Thread.sleep(10000);
        List<WebElement> messages = driver.findElements(By.className("wpaicg-chat-message"));
        System.out.println(messages.get(messages.size()-1).getAttribute("innerHTML"));
        
        //driver.quit();
    }
}
