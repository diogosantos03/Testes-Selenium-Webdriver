package br.com.framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public DriverFactory() {
		
	}
	public static WebDriver getDriver() {
		if(driver == null) {
			driver = new FirefoxDriver();
			driver.manage().window().setPosition(new Point(100, 100));
			driver.manage().window().setSize(new Dimension(700, 700));
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
