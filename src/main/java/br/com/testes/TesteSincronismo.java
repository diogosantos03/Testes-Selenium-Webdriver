package br.com.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSincronismo {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	@After
	public void finaliza() {
		//driver.quit();
	}
	
	@Test
	public void deveInteragirRespostaDemorada() throws InterruptedException {
		dsl.clicarNoBtn("buttonDelay");
		Thread.sleep(3000);
		dsl.escrever("novoCampo", "Escrevendo Test");
	}
	
}
