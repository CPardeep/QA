package webpages.shoppingWebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {
	public static final String URL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=t+shirt&submit_search=";

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	private WebElement clickItem;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	private WebElement itemTitle;

	public SearchResultsPage(WebDriver driver) {
	
	}

	public void itemClicked() {
		clickItem.click();
	}
	
	public String status() {
		return itemTitle.getText();
	}
}
