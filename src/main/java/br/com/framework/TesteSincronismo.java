package br.com.framework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		dsl.clicarNoBtn("buttonDelay");
		Thread.sleep(3000);
		dsl.escrever("novoCampo", "Escrevendo Test");
	}
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarNoBtn("buttonDelay");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Escrevendo Test");
	}
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.clicarNoBtn("buttonDelay");
		dsl.escrever("novoCampo", "Escrevendo Test");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
}
