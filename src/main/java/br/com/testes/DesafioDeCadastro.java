package br.com.testes;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DesafioDeCadastro {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void desafio() {
		dsl.escrever("elementosForm:nome","Diogo");
		dsl.escrever("elementosForm:sobrenome","Santos");
		dsl.clicar("elementosForm:sexo:0");
		dsl.clicar("elementosForm:comidaFavorita:2");
	
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		dsl.selecionarCombo("elementosForm:esportes","Natacao");
		
		dsl.clicar("elementosForm:cadastrar");
		
		assertTrue(dsl.getTexto(By.id("resultado")).contains("Cadastrado!"));
		assertTrue(dsl.getTexto(By.id("descNome")).endsWith("Diogo"));
		assertTrue(dsl.getTexto(By.id("descSobrenome")).endsWith("Santos"));
		assertTrue(dsl.getTexto(By.id("descSexo")).endsWith("Masculino"));
		assertTrue(dsl.getTexto(By.id("descComida")).endsWith("Pizza"));
		assertTrue(dsl.getTexto(By.id("descEscolaridade")).endsWith("mestrado"));
		assertTrue(dsl.getTexto(By.id("descEsportes")).endsWith("Natacao"));
	}
}
