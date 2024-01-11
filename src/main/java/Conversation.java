import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Conversation {
	
	private static String firstPrompt = "lets have a conversation, dont let the conversation die, if you sense its about to die ask me a question to keep it going, start with the most random topic and make your responses no more than a paragraph long";
	
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://chataigpt.org/?utm_content=cmp-true");
        
        // Accept the terms and conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all")));
        acceptButton.click();
        
        // Type in the conversation starting prompt
        WebElement textarea = driver.findElement(By.className("wpaicg-chat-shortcode-typing"));
        textarea.sendKeys(firstPrompt);
        
        // Click the submit prompt button
        Thread.sleep(3);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('wpaicg-chat-shortcode-send')[0].scrollIntoView();");
        js.executeScript("window.scrollBy(0, -200);");
        Thread.sleep(3);
        WebElement submitButton = driver.findElement(By.className("wpaicg-chat-shortcode-send"));
        submitButton.click();
        
        //driver.quit();
    }
}
