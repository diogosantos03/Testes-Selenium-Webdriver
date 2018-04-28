package br.com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesAlert {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit(); //Fecha e mata os processos do geckodriver
	}
	@Test
	public void testeBuscaAlert() {
		dsl.clicar("alert");
		Alert alerta = driver.switchTo().alert();
		assertEquals("Alert Simples",alerta.getText());
		alerta.accept();
		dsl.escrever("elementosForm:nome","Escreva algo");
	}
	
	@Test
	public void testeBuscaConfirm() {
		dsl.clicar("confirm");
		assertEquals("Confirm Simples", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		assertEquals("Confirmado", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirm")).click();
		assertEquals("Confirm Simples", driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		assertEquals("Negado", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void testePrompt() {
		dsl.clicar("prompt");
		driver.switchTo().alert().sendKeys("10");
		driver.switchTo().alert().accept();
		assertEquals("Era 10?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
}
