package storePageObjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import utility.ConfigProperties;

public class PurchaseProductPO extends LoadableComponent<PurchaseProductPO> {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath = "//div[@class='header-navigation']//a[@href='http://localhost/Avactis/product-list.php?Computers-pg1-cid8.html']")
	private WebElement compLnk;
	
	@FindBy (xpath = "//div[@class='header-navigation']//a[@href='http://localhost/Avactis/product-list.php?Notebooks-pg1-cid20.html']")
	private WebElement notebooksLnk;
	

	@FindBy (xpath = "//a//div//h3[text()='Asus Eee PC Touch']")
	private WebElement productConf;
	
	
	
	public PurchaseProductPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isLoaded();
	}
	
	
	
	public void purchaseProduct(String Product_LinkText) throws InterruptedException {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(compLnk).build().perform();
		notebooksLnk.click();
		Thread.sleep(5000);
		String a="//a//div//h3[text()='";
		String b="']";
		System.out.println(a+Product_LinkText+b);
		
		 driver.findElement(By.xpath(a+Product_LinkText+b)).click();
		
		
	}

	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		//MyDataProviders.getDataFromXLS();
		
	}

}
