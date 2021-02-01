package webpages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import webpages.shoppingWebsite.Homepage;

class ShoppingWebsiteTest {

	private static WebDriver driver;
	private static Logger LOGGER = Logger.getGlobal();

	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// timeouts
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test_ShoppingSite() throws InterruptedException {

		// Site Navigation
		driver.get("http://automationpractice.com/index.php");
		Homepage website = PageFactory.initElements(driver, Homepage.class);

		// Search for item
		website.search("T shirt");

		// Assertion
		assertEquals("Faded Short Sleeve T-shirts", website.searchResults.status());

		// Click on item
		website.searchResults.itemClicked();

//		// Bonus task
//		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).submit();
//		driver.findElement(By.cssSelector(".standard-checkout > span")).click();

	}

	@AfterAll
	public static void cleanAll() {
		driver.quit();
		LOGGER.info("done");
	}

}
