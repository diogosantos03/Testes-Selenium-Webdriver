package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesFrames {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit(); //Fecha e mata os processos do geckodriver
	}
	
	@Test
	public void testeFrame() {
		driver.switchTo().frame("frame1");
		dsl.clicar("frameButton");
		String str = driver.switchTo().alert().getText();
		assertEquals("Frame OK!", str);
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		dsl.escrever("elementosForm:nome", str);
	}
	
	@Test
	public void testeNewWindow() {
		dsl.clicar("buttonPopUpEasy");
		driver.switchTo().window("Popup");
		String str = "Hello World!!!";
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window("");
		dsl.escrever("elementosForm:nome", str);
	}
	
	@Test
	public void testeWindowHandler() {
		dsl.clicar("buttonPopUpHard");
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		
		String str = "Hello World!!!";
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		dsl.escrever("elementosForm:nome", str);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
