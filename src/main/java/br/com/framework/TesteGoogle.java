package br.com.framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	private WebDriver drive;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		drive = new FirefoxDriver();
		drive.manage().window().setPosition(new Point(100,100));
		drive.manage().window().setSize(new Dimension(400, 400));
		drive.get("https://www.google.com");
	}
	
	@After
	public void finaliza() {
		drive.quit(); //Fecha e mata os processos do geckodriver
	}
	@Test
	public void teste() {
		assertEquals("Google", drive.getTitle());
		assertTrue("Google".equals(drive.getTitle()));
	}
}
