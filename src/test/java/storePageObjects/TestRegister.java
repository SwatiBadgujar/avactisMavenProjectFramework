package storePageObjects;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestRegister {
	HomePage myHomePage;
	PurchaseProductPO purchasePO;
	
	 @Test(dataProvider = "productdata",dataProviderClass=utility.MyDataProviders.class)
  public void registration(String Product_LinkText) throws InterruptedException {
	  myHomePage.register()
	  			.signOut()
	  	        .signIn()
	  	      .purchaseProduct(Product_LinkText);
	  	       
	  
  }
  /*@Test(dataProvider = "productdata",dataProviderClass=utility.MyDataProviders.class)
  public void spurchaseProduct(String Product_LinkText) throws InterruptedException {
	  //purchasePO =new PurchaseProductPO(driver);
	  purchasePO.purchaseProduct(Product_LinkText);
	  
  }*/
  @BeforeMethod
  public void beforeMethod() {
	  myHomePage = new HomePage();
	  myHomePage.get();
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
