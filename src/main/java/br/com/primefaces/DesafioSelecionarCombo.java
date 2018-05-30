package br.com.primefaces;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.testes.DSL;

public class DesafioSelecionarCombo {
	
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL(driver);
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void desafio() {
		dsl.clicar(By.xpath("//*[@id='j_idt115:console']/div[3]/span"));
		dsl.clicar(By.xpath(".//*[@id='j_idt115:console_2']"));
		
		assertEquals("PS4", dsl.getTexto(By.id("j_idt115:console_label")));
	}

}
