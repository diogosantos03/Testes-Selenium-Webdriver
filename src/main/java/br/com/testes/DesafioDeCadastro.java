package br.com.testes;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DesafioDeCadastro {
	private WebDriver driver;
	private CampoTreinamentoPage page;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void desafio() {
		page.setNome("Diogo");
		page.setSobreNome("Santos");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.clicarBtnCadastrar();
		
		assertTrue(page.obterResultadoCadastro().contains("Cadastrado!"));
		assertTrue(page.obterNomeCadastro().endsWith("Diogo"));
		assertTrue(page.obterSobreNomeCadastro().endsWith("Santos"));
		assertTrue(page.obterSexoCadastro().endsWith("Masculino"));
		assertTrue(page.obterComidaCadastro().endsWith("Pizza"));
		assertTrue(page.obterEscolaridadeCadastro().endsWith("mestrado"));
		assertTrue(page.obterEsporteCadastro().endsWith("Natacao"));
	}
}
