package webpages.demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webpages.demosite.pages.DemoAddUsersPage;
import webpages.demosite.pages.DemoLoginPage;

public class DemoHomepage {
	
	public static final String URL = "http://thedemosite.co.uk";
	
	@FindBy(linkText = "3. Add a User")
	private WebElement navAddUserPage;
	
	@FindBy(linkText = "4. Login")
	private WebElement navLoginPage;
	
	public DemoAddUsersPage addUserPage;
	
	public DemoLoginPage loginPage;
	
	public DemoHomepage(WebDriver driver) {
		driver.get(URL);
		this.addUserPage = PageFactory.initElements(driver,DemoAddUsersPage.class);
		this.loginPage = PageFactory.initElements(driver,  DemoLoginPage.class);
	}
	
	public void navAddUser() {
		navAddUserPage.click();
	}
	
	public void navLogin() {
		navLoginPage.click();
	}

}
