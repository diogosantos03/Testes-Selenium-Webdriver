package br.com.testes2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.core.DSL;
import br.com.core.DriverFactory;

public class TesteAjax {
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void testeAjax() {
		dsl.escrever("j_idt635:name", "Teste");
		dsl.clicar("j_idt635:j_idt638");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt635:display"), "Teste"));
		assertEquals("Teste",dsl.getTexto(By.id("j_idt635:display")));
		
	}

}
