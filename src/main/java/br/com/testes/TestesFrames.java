package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesFrames {
	@Test
	public void testeFrame() {
		System.setProperty("webdriver.gecko.driver","/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		String str = driver.switchTo().alert().getText();
		assertEquals("Frame OK!", str);
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(str);
		
		driver.quit();
	}
	
	@Test
	public void testeNewWindow() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		String str = "Hello World!!!";
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:nome")).sendKeys(str);
		driver.quit();
	}
	
	@Test
	public void testeWindowHandler() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		
		String str = "Hello World!!!";
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		driver.findElement(By.id("elementosForm:nome")).sendKeys(str);
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
