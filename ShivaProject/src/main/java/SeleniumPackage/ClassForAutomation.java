/**
 * 
 */
package SeleniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author shiva
 *
 */
public class ClassForAutomation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\WebDrivers\\Chrome\\Version108\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.americanexpress.com");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			WebElement addToCard = driver.findElement(By.xpath("//button[contains(@class,'axp-offers') and @title='Add to Card'][1]")); 
			 
			WebElement viewAllButton = driver.findElement(By.xpath("//div/a[contains(@class,'btn-block')]/span[text()='View All']"));
//			System.out.println("Total Number of Add to Card Buttons are, " + allAddToCardButtons.size());
			
			if(viewAllButton.isDisplayed()) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", viewAllButton);
				Thread.sleep(3000);
				//viewAllButton.click();
			}
			List<WebElement> allAddToCardButtons = driver.findElements(By.xpath("//button[contains(@class,'axp-offers') and @title='Add to Card']"));
			//System.out.println("Total Number of Add to Card Buttons are, " + allAddToCardButtons.size());
			for(int i=0;i<=allAddToCardButtons.size();i++) {
//				List<WebElement> allAddToCardButtons = driver.findElements(By.xpath("//button[contains(@class,'axp-offers') and @title='Add to Card']"));
//				allAddToCardButtons.get(i).click();
				if(allAddToCardButtons.get(i).isEnabled()) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", allAddToCardButtons.get(i));
				Thread.sleep(2000);
				}
			}
			
			
			
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
