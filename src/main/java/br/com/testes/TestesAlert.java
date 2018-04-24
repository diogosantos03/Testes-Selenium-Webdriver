package br.com.testes;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesAlert {
	@Test
	public void testeBuscaAlert() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		drive2.findElement(By.id("alert")).click();
		Alert alerta = drive2.switchTo().alert();
		assertEquals("Alert Simples",alerta.getText());
		alerta.accept();
		drive2.findElement(By.id("elementosForm:nome")).sendKeys("Escreva algo");
		
		drive2.quit();
	}
	
	@Test
	public void testeBuscaConfirm() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		drive2.findElement(By.id("confirm")).click();
		assertEquals("Confirm Simples", drive2.switchTo().alert().getText());
		drive2.switchTo().alert().accept();
		assertEquals("Confirmado", drive2.switchTo().alert().getText());
		drive2.switchTo().alert().accept();
		
		drive2.findElement(By.id("confirm")).click();
		assertEquals("Confirm Simples", drive2.switchTo().alert().getText());
		drive2.switchTo().alert().dismiss();
		assertEquals("Negado", drive2.switchTo().alert().getText());
		drive2.switchTo().alert().accept();
		
		
		drive2.quit();
	}
}
