package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utils.TestUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FlipkartPage extends TestBase{
    public WebDriver driver;
    

    @FindBy(xpath = "//following::div[@tabindex='-1']//child::div[1]/button[1]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name ='q' and @type='text']")
    WebElement searchTextBox;

    @FindBy(xpath = "//*[@data-id='RTREK2VG4GBDUKFN']/div[1]/a[1]")
    WebElement firstItem;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]")
    WebElement getFirstItemPrice;	

    @FindBy(xpath = "//div[@id=\"container\"]//child::li[1]//button[text()='ADD TO CART']")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/button[2]")
    WebElement increaseQuantity;
  

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]")
    WebElement getPriceAfterIncreasingQuantity;

    public FlipkartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void closeLoginButton()
    {
    	loginButton.click();
    }

    public void enterInSearchTextBox1(String s)
    {
        this.searchTextBox.sendKeys(s);
        this.searchTextBox.sendKeys(Keys.ENTER);
    }

    public void clickFirstItem1() {
    	TestUtils.applyImplicitWait();
        firstItem.click();
    }

    public String getFirstItemPrice(){
        String s = getFirstItemPrice.getText();
        return s;
    }

    public void clickAddToCart1(){
        addToCart.click();
    }

    public void clickIncreaseQuantity1(){
    	TestUtils.applyImplicitWait();
        increaseQuantity.click();
    }

    public String getPriceInCart(){
    	driver.navigate().refresh();
    	TestUtils.applyImplicitWait();
        String s1 = getPriceAfterIncreasingQuantity.getText();
        return s1;
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    
}
