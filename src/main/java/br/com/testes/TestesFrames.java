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
	private CampoTreinamentoPage page;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit(); //Fecha e mata os processos do geckodriver
	}
	
	@Test
	public void testeFrame() {
		driver.switchTo().frame("frame1");
		page.clicarBtnFrame();
		String str = driver.switchTo().alert().getText();
		assertEquals("Frame OK!", str);
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		page.escreverNome(str);
	}
	
	@Test
	public void testeNewWindow() {
		page.clicarPopUpEase();
		driver.switchTo().window("Popup");
		String str = "Hello World!!!";
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window("");
		page.escreverNome(str);
	}
	
	@Test
	public void testeWindowHandler() {
		page.clicarBtnHard();
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		
		String str = "Hello World!!!";
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.findElement(By.tagName("textArea")).sendKeys(str);
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		page.escreverNome(str);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
