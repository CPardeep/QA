package webpages.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {
	public static final String URL = "http://thedemosite.co.uk/login.php";

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "FormsButton2")
	private WebElement submit;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status;
	

	public DemoLoginPage(WebDriver driver) {
		
	}

	public void login(String username_input, String password_input) {
		username.sendKeys(username_input);
		password.sendKeys(password_input);
		submit.click();
	}
	
	public String getStatus() {
		return status.getText();
	}

}
