import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Grammar {
	
	private FirefoxDriver driver;

	public Grammar() {
		// Go to the ChatGPT website
		FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        driver = new FirefoxDriver(options);
        driver.get("https://languagetool.org/spellchecking-german/");
        
        // Accept the terms and conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-banner-accept-all")));
		acceptButton.click();
	}
	
	public String checkGrammar(String sentence) {
		String grammaticalMistakes = "";
		WebElement textarea = driver.findElement(By.className("welcome-editor__textarea"));
		textarea.clear();
		textarea.sendKeys(sentence);
		
		// Loop through error-list-item__preview printing their innerText
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("error-list-item__preview")));
		List<WebElement> elements = driver.findElements(By.className("error-list-item__preview"));
        for (WebElement element : elements) {
        	String userMistake = element.findElement(By.tagName("b")).getText();
        	element.click();
        	String correction = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-list-item__fix"))).getText();
        	String explanation = driver.findElement(By.className("error-list-item__description")).getText();
        	grammaticalMistakes += userMistake + " -> " + correction + " (" + explanation + ")\n";
        }
		
        return grammaticalMistakes;
	}
}
