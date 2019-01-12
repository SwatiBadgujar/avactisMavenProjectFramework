package storePageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigProperties;

public class SignInPO extends LoadableComponent<SignInPO> {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (id = "account_sign_in_form_email_id")
	private WebElement signIn_email;
	
	@FindBy (id = "account_sign_in_form_passwd_id")
	private WebElement signIn_password;
	
	@FindBy (xpath = "//input[@value='Sign In']")
	private WebElement signIn_btn;
	
	public SignInPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isLoaded();
		
	}
	
	public PurchaseProductPO signIn() {
		 ConfigProperties.loadProperties();
		 signIn_email.sendKeys(ConfigProperties.getProperties("REG_E_MAIL"));
		 signIn_password.sendKeys(ConfigProperties.getProperties("REG_PASSWORD"));
		 signIn_btn.click();
		 PurchaseProductPO purchaseProd = new PurchaseProductPO(driver);
		 return purchaseProd;
		 
	}
	
	

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(),ConfigProperties.getProperties("HOME_PAGE_TITLE"));
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
