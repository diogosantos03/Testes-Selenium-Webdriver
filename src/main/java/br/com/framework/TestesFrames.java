package br.com.framework;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestesFrames {
	private CampoTreinamentoPage page;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver(); //Fecha e mata os processos do geckodriver
	}
	
	@Test
	public void testeFrame() {
		DriverFactory.getDriver().switchTo().frame("frame1");
		page.clicarBtnFrame();
		String str = DriverFactory.getDriver().switchTo().alert().getText();
		assertEquals("Frame OK!", str);
		DriverFactory.getDriver().switchTo().alert().accept();
		
		DriverFactory.getDriver().switchTo().defaultContent();
		page.escreverNome(str);
	}
	
	@Test
	public void testeFrame2() {
		WebElement frame = DriverFactory.getDriver().findElement(By.id("frame2"));
		dsl.executarJavaScriptCod("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		DriverFactory.getDriver().switchTo().frame("frame2");
		DriverFactory.getDriver().findElement(By.id("frameButton")).click();
		String msg = DriverFactory.getDriver().switchTo().alert().getText();
		DriverFactory.getDriver().switchTo().alert().accept();
		assertEquals("Frame OK!",msg);
	}
	
	@Test
	public void testeNewWindow() {
		page.clicarPopUpEase();
		DriverFactory.getDriver().switchTo().window("Popup");
		String str = "Hello World!!!";
		DriverFactory.getDriver().findElement(By.tagName("textArea")).sendKeys(str);
		DriverFactory.getDriver().close();
		DriverFactory.getDriver().switchTo().window("");
		page.escreverNome(str);
	}
	
	@Test
	public void testeWindowHandler() {
		page.clicarBtnHard();
		
		System.out.println(DriverFactory.getDriver().getWindowHandle());
		System.out.println(DriverFactory.getDriver().getWindowHandles());
		
		String str = "Hello World!!!";
		DriverFactory.getDriver().switchTo().window(DriverFactory.getDriver().getWindowHandles().toArray()[1].toString());
		DriverFactory.getDriver().findElement(By.tagName("textArea")).sendKeys(str);
		DriverFactory.getDriver().close();
		DriverFactory.getDriver().switchTo().window(DriverFactory.getDriver().getWindowHandles().toArray()[0].toString());
		page.escreverNome(str);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
