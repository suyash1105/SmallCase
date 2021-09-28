package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	
	public static void initialize(String website)
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		if(website.equals("Amazon"))
		{
			driver.get("https://www.amazon.in/");
		}
		else
			driver.get("https://www.flipkart.com/");
		
	}
	
}
