package com.test.scripts;
import org.testng.annotations.Test;
import com.pages.AmazonPage;
import com.pages.FlipkartPage;
import com.pages.TestBase;
import com.test.utils.TestUtils;

public class AmazonTest extends TestBase {
	
	
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
		String flipkartPrice=flipkartElements.getPriceInCart();
		flipkartPrice=flipkartPrice.substring(1, flipkartPrice.length());
		flipkartPrice=flipkartPrice.replaceFirst(",","");
		System.out.println("Price of Product on Flipkart in Cart: "+flipkartPrice);		
		flipkartElements.navigateTo("https://www.amazon.in/");
		AmazonPage amazonElements=new AmazonPage(driver);
		amazonElements.enterInSearchBox("TP-link N300 WiFi Wireless Router TL-WR845N");
		amazonElements.clickProduct();
		TestUtils.switchToChildWindowHandle();
		String s2=amazonElements.getItemPrice1Amazon();
		s2=s2.substring(1, s2.length());
		s2=s2.replaceFirst(",", "");
		System.out.println("Price of Product on Amazon: "+s2);
		amazonElements.clickAddToCart1Amazon();
		amazonElements.clickOnCartAmazon();
		String amazonPrice=amazonElements.getPriceAfterAddingToCart1Amazon();
		amazonPrice=amazonPrice.replaceFirst(",","");
		amazonPrice=amazonPrice.substring(0,amazonPrice.indexOf("."));
		System.out.println("Price of Product on Amazon in Cart: "+amazonPrice);
		int priceAmazon=Integer.valueOf(amazonPrice);
		int priceFlipkart=Integer.valueOf(flipkartPrice);
		if (priceAmazon>priceFlipkart)
		{
			System.out.println("Product is Cheaper on Flipkart");
		}
		else if(priceAmazon<priceFlipkart)
		{
			System.out.println("Product is Cheaper on Amazon");
		}
		else
		{
			System.out.println("Product is having same price on both the websites");
		}
		TestUtils.closeBrowser();		
		
	}

}
