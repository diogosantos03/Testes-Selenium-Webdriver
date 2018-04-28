package br.com.testes;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Desafio2RegrasDaPag {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void regraNome() {
		/*Inserindo dados no campo sobrenome para testar a regra do campo nome*/
		dsl.escrever("elementosForm:sobrenome", "test");
		dsl.clicar("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSobrenome() {
		/*Inserindo dados no campo nome para testar a regra do campo sobrenome*/
		dsl.escrever("elementosForm:nome", "test");
		dsl.clicar("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSexo() {
		dsl.escrever("elementosForm:sobrenome", "test");
		dsl.escrever("elementosForm:nome", "test");
		
		boolean masc = dsl.isRadioSelect("elementosForm:sexo:0");
		boolean fem = dsl.isRadioSelect("elementosForm:sexo:1");
		if(!masc || !fem) {
			dsl.clicar("elementosForm:cadastrar");
			Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}else {
			fail();
		}
		
	}
	
	@Test
	public void regraComidaFavorita() {
		dsl.escrever("elementosForm:sobrenome", "test");
		dsl.escrever("elementosForm:nome", "test");
		
		dsl.clicar("elementosForm:sexo:0");
		
		dsl.clicar("elementosForm:comidaFavorita:0");
		dsl.clicar("elementosForm:comidaFavorita:3");
		dsl.clicar("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraEsportes() {
		dsl.escrever("elementosForm:sobrenome", "test");
		dsl.escrever("elementosForm:nome", "test");
		
		dsl.clicar("elementosForm:sexo:0");
		
		dsl.clicar("elementosForm:comidaFavorita:0");
		
		dsl.selecionarCombo("elementosForm:esportes", "Karate");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicar("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

}
