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
import webpages.demosite.DemoHomepage;

class TestTheDemoSite {

	private static WebDriver driver;
	private static Logger LOGGER = Logger.getGlobal();

	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// timeouts
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void test_DemoSite() throws InterruptedException {

		// Site Navigation
		driver.get("http://thedemosite.co.uk");
		DemoHomepage website = PageFactory.initElements(driver, DemoHomepage.class);

		// Adding a new user
		website.navAddUser();
		website.addUserPage.addUser("admin", "admin");
		
		// Logging in with user details
		website.navLogin();
		website.loginPage.login("admin", "admin");
		
		// Assertion 
		assertEquals("**Successful Login**", website.loginPage.getStatus());

	}

	@AfterAll
	public static void cleanAll() {
		driver.quit();
		LOGGER.info("Testing Done");
	}

}
