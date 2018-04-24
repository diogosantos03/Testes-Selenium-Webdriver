package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive = new FirefoxDriver();
		drive.manage().window().setPosition(new Point(100,100));
		drive.manage().window().setSize(new Dimension(100, 400));
		drive.get("https://www.google.com");
		assertEquals("Google", drive.getTitle());
		assertTrue("Google".equals(drive.getTitle()));
		//drive.close();//Fecha o navegador logo em seguida
		drive.quit(); //Mata os processos
	}
}
