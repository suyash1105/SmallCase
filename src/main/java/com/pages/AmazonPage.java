package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utils.TestUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonPage extends TestBase {
    
	public WebDriver driver;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchTextBoxAmazon;

    @FindBy(xpath = "//*[@id='a-page']//span[contains(text(),'TP-link N300 WiFi Wireless Router TL-WR845N ')]")
    WebElement product;

    @FindBy(xpath = "//span[@id=\"priceblock_ourprice\"]")
    WebElement getPriceOfItem;

    @FindBy(xpath = "//input[@id=\"add-to-cart-button\"]")
    WebElement addToCartAmazon;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    WebElement goToCart;

    @FindBy(xpath = "//span[@id=\"sc-subtotal-amount-buybox\"]")
    WebElement getPriceAfterAddingToCart;

    public AmazonPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterInSearchBox(String s) 
    {
        this.searchTextBoxAmazon.sendKeys(s);
        this.searchTextBoxAmazon.sendKeys(Keys.ENTER);
    }

    public void clickProduct() 
    {
        product.click();
    }

    public String getItemPrice1Amazon() 
    {
    	TestUtils.applyImplicitWait();
        String s = getPriceOfItem.getText();
        return s;
    }

    public void clickAddToCart1Amazon() 
    {
        addToCartAmazon.click();
    }

    public void clickOnCartAmazon() 
    {
        goToCart.click();
    }

    public String getPriceAfterAddingToCart1Amazon() {
        String s = getPriceAfterAddingToCart.getText().trim();
        return s;
    }



}
