package seleniumTest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {

	private static WebDriver driver;
	private static WebElement target;

	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}

	@Test
	public void test_GoogleKitten() throws InterruptedException {
		driver.get("http://www.google.com");
		target = driver.findElement(By.name("q"));
		target.sendKeys("Kittens");
		target.submit();
		
		assertEquals("Kittens - Google Search", driver.getTitle());
		
		driver.findElement(By.linkText("Images")).click();
		
		driver.findElement(By.xpath("//div[2]/a/div/img")).click();
		
		assertEquals("Kittens - Google Search", driver.getTitle());
		
		Thread.sleep(5000);
	}

	@AfterAll
	public static void cleanAll() {
		driver.quit();
		System.out.println("done");
	}

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

}
