package br.com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public DriverFactory() {
		
	}
	public static WebDriver getDriver() {
		if(driver == null) {
			switch (Propriedades.browsers) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			}
			
			//driver.manage().window().setPosition(new Point(100, 100));
			//driver.manage().window().setSize(new Dimension(700, 700));
		}
		return driver;
	}
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
	}
}
