package webpages.FTSEWebsite.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RisersPage {
	public static final String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers";

	@FindBys({
		@FindBy(xpath = "//*[@id=\"ls-row-INF-L\"]"),
		@FindBy(xpath = "//*[@id=\"ls-row-JMAT-L\"]"),
		@FindBy(xpath = "//*[@id=\"ls-row-PSON-L\"]")
	})
	private List<WebElement> top3Risers;

	public RisersPage(WebDriver driver) {
		driver.get(URL);
	}
	
	public WebElement getRisers() {
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		for(WebElement x : top3Risers) {
		    list.add(x);
		}
		return (WebElement) list;
	}


}
