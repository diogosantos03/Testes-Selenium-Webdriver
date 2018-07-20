package br.com.testes2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.core.DriverFactory;

public class TesteGoogle {
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("https://www.google.com");
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver(); //Fecha e mata os processos do geckodriver
	}
	@Test
	public void teste() {
		assertEquals("Google", DriverFactory.getDriver().getTitle());
		assertTrue("Google".equals(DriverFactory.getDriver().getTitle()));
	}
}
