package webpages.shoppingWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webpages.shoppingWebsite.pages.SearchResultsPage;

public class Homepage {
	public static final String URL = "http://automationpractice.com/index.php";

	@FindBy(id = "search_query_top")
	private WebElement search;

	@FindBy(name = "submit_search")
	private WebElement searchbutton;
	
	public SearchResultsPage searchResults;

	public Homepage(WebDriver driver) {
		driver.get(URL);
		this.searchResults = PageFactory.initElements(driver,SearchResultsPage.class);
	}

	public void search(String keyword) {
		search.sendKeys(keyword);
		searchbutton.click();
	}

}
