package storePageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import model.NewRegistrationDetails;
import utility.ConfigProperties;

public class HomePage extends LoadableComponent<HomePage>{
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath = "//a[text()='Sign In']")
	@CacheLookup
	private WebElement signInLink;
	
	@FindBy (xpath = "//button[text()='Register']")
	@CacheLookup
	private WebElement registerButton;
	
	@FindBy (name = "customer_info[Customer][Email]")
	private WebElement email;
	
	@FindBy (name = "customer_info[Customer][Password]")
	private WebElement password;
	
	@FindBy (name = "customer_info[Customer][RePassword]")
	private WebElement rePassword;
	
	@FindBy (name = "customer_info[Customer][FirstName]")
	private WebElement firstName;
	
	@FindBy (name = "customer_info[Customer][LastName]")
	private WebElement lastName;
	
	@FindBy (id = "customer_info_Customer_Country")
	private WebElement selectCountry;
	
	@FindBy (id = "customer_info_Customer_State")
	private WebElement selectState;
	
	@FindBy (name = "customer_info[Customer][ZipCode]")
	private WebElement zipcode;
	
	@FindBy (name = "customer_info[Customer][City]")
	private WebElement city;
	
	@FindBy (name = "customer_info[Customer][Streetline1]")
	private WebElement addressline1;
	
	@FindBy (name = "customer_info[Customer][Streetline2]")
	private WebElement addressline2;
	
	@FindBy (name = "customer_info[Customer][Phone]")
	private WebElement phone;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement registerBtn;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement signOutLnk;
	
	
	
	NewRegistrationDetails newRegistrationDetails;
	
	public HomePage() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver64bit.exe");
		//driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,30,250);
		driver.manage().window().maximize();
			
	}
	
	public HomePage register() {
		// TODO Auto-generated method stub
		signInLink.click();
		registerButton.click();
		 newRegistrationDetails = new NewRegistrationDetails();
		newRegistrationDetails.setREG_E_MAIL(ConfigProperties.getProperties("REG_E_MAIL"));
		newRegistrationDetails.setREG_PASSWORD(ConfigProperties.getProperties("REG_PASSWORD"));
		newRegistrationDetails.setREG_RE_TYPE_PASSWORD(ConfigProperties.getProperties("REG_RE_TYPE_PASSWORD"));
		newRegistrationDetails.setREG_FIRST_NAME(ConfigProperties.getProperties("REG_FIRST_NAME"));
		newRegistrationDetails.setREG_LAST_NAME(ConfigProperties.getProperties("REG_LAST_NAME"));
		newRegistrationDetails.setREG_COUNTRY(ConfigProperties.getProperties("REG_COUNTRY"));
		newRegistrationDetails.setREG_STATE(ConfigProperties.getProperties("REG_STATE"));
		newRegistrationDetails.setREG_ZIP_CODE(ConfigProperties.getProperties("REG_ZIP_CODE"));
		newRegistrationDetails.setREG_CITY(ConfigProperties.getProperties("REG_CITY"));
		newRegistrationDetails.setREG_ADDRESS_LINE1(ConfigProperties.getProperties("REG_ADDRESS_LINE1"));
		newRegistrationDetails.setREG_ADDRESS_LINE2(ConfigProperties.getProperties("REG_ADDRESS_LINE2"));
		newRegistrationDetails.setREG_CONTACT_PHONE(ConfigProperties.getProperties("REG_CONTACT_PHONE"));
		if(fillRegisterForm(newRegistrationDetails)) {
			System.out.println("Success");
		}
		return this;
		
		
	}

public boolean fillRegisterForm(NewRegistrationDetails newRegistrationDetails){
	
	email.sendKeys(newRegistrationDetails.getREG_E_MAIL());
	password.sendKeys(newRegistrationDetails.getREG_PASSWORD());
	rePassword.sendKeys(newRegistrationDetails.getREG_RE_TYPE_PASSWORD());
	firstName.sendKeys(newRegistrationDetails.getREG_FIRST_NAME());
	lastName.sendKeys(newRegistrationDetails.getREG_LAST_NAME());
	selectCountry.sendKeys(newRegistrationDetails.getREG_COUNTRY());
	selectState.sendKeys(newRegistrationDetails.getREG_STATE());
	zipcode.sendKeys(newRegistrationDetails.getREG_ZIP_CODE());
	city.sendKeys(newRegistrationDetails.getREG_CITY());
	addressline1.sendKeys(newRegistrationDetails.getREG_ADDRESS_LINE1());
	addressline2.sendKeys(newRegistrationDetails.getREG_ADDRESS_LINE2());
	phone.sendKeys(newRegistrationDetails.getREG_CONTACT_PHONE());
	registerBtn.click();
	
	return true;
	}

public SignInPO signOut() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Out']"))).click();
	//signOutLnk.click();
	SignInPO signin = new SignInPO(driver);
		return signin;
	
	
}

@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),ConfigProperties.getProperties("HOME_PAGE_TITLE"));
		
	}

	@Override
	protected void load() {
		 ConfigProperties.loadProperties();
		 driver.get(ConfigProperties.getProperties("STORE_URL"));
		
		
	}

	



}
