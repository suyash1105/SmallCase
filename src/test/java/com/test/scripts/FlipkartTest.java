package com.test.scripts;

import org.testng.annotations.Test;
import com.pages.*;
import com.test.utils.TestUtils;

public class FlipkartTest extends TestBase{
	
	@Test
	public void testMethod() throws InterruptedException
	{
		initialize("Flipkart");
		FlipkartPage flipkartElements=new FlipkartPage(driver);
		flipkartElements.closeLoginButton();
		flipkartElements.enterInSearchTextBox1("TP-link N300 WiFi Wireless Router TL-WR845N");
		flipkartElements.clickFirstItem1();
		TestUtils.switchToChildWindowHandle();
		String s1=flipkartElements.getFirstItemPrice();
		s1=s1.substring(1, s1.length());
		s1=s1.replaceFirst(",", "");
		System.out.println("Price of product on Flipkart: "+s1);
		flipkartElements.clickAddToCart1();
		flipkartElements.clickIncreaseQuantity1();
		String flipkartPrice=flipkartElements.getPriceInCart();
		flipkartPrice=flipkartPrice.substring(1, flipkartPrice.length());
		flipkartPrice=flipkartPrice.replaceFirst(",","");
		System.out.println("Price after increasing quantity of the item: "+flipkartPrice);
		TestUtils.closeBrowser();		
		
	}

}
