package webpages.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddUsersPage {
	
	public static final String URL = "http://thedemosite.co.uk/addauser.php";

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "FormsButton2")
	private WebElement submit;

	public DemoAddUsersPage(WebDriver driver) {
		
	}

	public void addUser(String username_input, String password_input) {
		username.sendKeys(username_input);
		password.sendKeys(password_input);
		submit.click();
	}

	
}
