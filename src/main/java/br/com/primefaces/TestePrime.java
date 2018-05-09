package br.com.primefaces;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.testes.DSL;


public class TestePrime {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL(driver);
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void deveIteragirComRadioPrime() {
		dsl.clicar(By.xpath("//*[@id=\"j_idt115:console:0\"]/../..//span"));
		assertTrue(dsl.isRadioSelect("j_idt115:console:0"));
		
		dsl.clicar(By.xpath("//*[.=\"PS4\"]/../td[2]//span"));
		assertTrue(dsl.isRadioSelect("j_idt115:console:1"));
		
	}

}
