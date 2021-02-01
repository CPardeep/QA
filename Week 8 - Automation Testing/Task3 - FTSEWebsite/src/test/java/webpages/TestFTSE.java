package webpages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webpages.FTSEWebsite.HomePage;;

class TestFTSE {

	private static WebDriver driver;
	private static Logger LOGGER = Logger.getGlobal();
	private WebElement top3Risers;

	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// timeouts
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void test_FTSE() throws InterruptedException {

		// Setup
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click on risers
		website.clickRisers();
		
		//wait on element 
		top3Risers = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(website.risersPage.getRisers()));	
		
		//Check results for risers
		for(WebElement x : top3Risers) {
			LOGGER.info(x.getText());
		}

	}

	@AfterAll
	public static void cleanAll() {
		driver.quit();
		LOGGER.info("done");
	}

}
