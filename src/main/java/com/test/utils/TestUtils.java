package com.test.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.TestBase;

public class TestUtils extends TestBase {
	
	
	public static void applyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
	
	public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
	public Set getWindowHandles() {
        Set<String> s = driver.getWindowHandles();
        return s;
    }

    public static void switchToChildWindowHandle() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1= windowHandles.iterator();
        String child_window = "";
        while(I1.hasNext())
        {
            child_window=I1.next();
        }
        driver.switchTo().window(child_window);
    }

    public void waitForVisibility(String strXpath){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
    } 
    
    public String getParentWindowHandle(){
        String parent=driver.getWindowHandle();
        return parent;
    }

	
	
}
