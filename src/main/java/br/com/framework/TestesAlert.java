package br.com.framework;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

public class TestesAlert {
	private CampoTreinamentoPage page;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver(); //Fecha e mata os processos do geckodriver
	}
	@Test
	public void testeBuscaAlert() {
		page.clicarBtnAlert();
		Alert alerta = DriverFactory.getDriver().switchTo().alert();
		assertEquals("Alert Simples",alerta.getText());
		alerta.accept();
		page.escreverNome("Diogo");
	}
	
	@Test
	public void testeBuscaConfirm() {
		page.clicarBtnConfirmar();
		assertEquals("Confirm Simples", DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().accept();
		assertEquals("Confirmado", DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().accept();
		
		page.clicarBtnConfirmar();
		assertEquals("Confirm Simples", DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().dismiss();
		assertEquals("Negado", DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().accept();
	}
	
	@Test
	public void testePrompt() {
		page.clicarBtnPrompt();
		DriverFactory.getDriver().switchTo().alert().sendKeys("10");
		DriverFactory.getDriver().switchTo().alert().accept();
		assertEquals("Era 10?", DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().accept();
	}
}
