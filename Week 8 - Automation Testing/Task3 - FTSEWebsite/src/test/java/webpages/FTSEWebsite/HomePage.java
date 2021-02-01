package webpages.FTSEWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webpages.FTSEWebsite.pages.RisersPage;

public class HomePage {

	public static final String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";

	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[2]")
	private WebElement risers;
	
	@FindBy(xpath = "//*[@id=\"content_div_40583\"]/ul/li[3]")
	private WebElement fallers;
	
	public RisersPage risersPage;

	public HomePage(WebDriver driver) {
		driver.get(URL);
		this.risersPage = PageFactory.initElements(driver, RisersPage.class);
	}

	public Boolean clickRisers() {
		risers.click();
		return true;
	}
	
	public void clickFallers() {
		fallers.click();
	}

}
