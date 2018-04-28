package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class TesteCampoTreinamento {
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
	public void testeTestField() {
		dsl.escrever("elementosForm:nome", "Diogo");
		assertEquals("Diogo",dsl.getIdCampo("elementosForm:nome"));
	}
	
	@Test
	public void testeTestArea() {
		dsl.escrever("elementosForm:sugestoes","Melhorar o forms");
		assertEquals("Melhorar o forms",dsl.getIdCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void testeTestRadioButton() {
		dsl.clicar("elementosForm:sexo:0");
		assertTrue(dsl.isRadioSelect("elementosForm:sexo:0"));
	}
	
	@Test
	public void testeTestCampoSelect() {
		dsl.clicar("elementosForm:comidaFavorita:0");
		assertTrue(dsl.isRadioSelect("elementosForm:comidaFavorita:0"));
	}
	
	
	@Test
	public void testeTestComboEscolaridade() {
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select selecoesParaCombos = new Select(elemento);
		//selecoesParaCombos.selectByIndex(6);
		//selecoesParaCombos.selectByValue("mestrado");
		selecoesParaCombos.selectByVisibleText("Mestrado");
		assertEquals("Mestrado",selecoesParaCombos.getFirstSelectedOption().getText());
		
		List<WebElement> lista = selecoesParaCombos.getOptions();
		boolean encontrou = false;
		for(WebElement e : lista) {
			if(e.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		assertTrue(encontrou);
		assertEquals(8, selecoesParaCombos.getOptions().size());
	}
	
	@Test
	public void testeTestComboMultiplasEscolhas() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Karate");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		
		Select selecoesParaCombos = new Select(elemento);
		List<WebElement> lista = selecoesParaCombos.getAllSelectedOptions();
		assertEquals(3, lista.size());
	}
	
	@Test
	public void testeTestBtn() {
		dsl.clicar("buttonSimple");
		assertEquals("Obrigado!", dsl.getIdCampo("buttonSimple"));
		driver.quit();
		
	}
	@Test
	
	@Ignore
	public void testeTestLink() {
		driver.findElement(By.linkText("Voltar"));
		//TODO falta terminar esse test, verificando os textos depois que quicado no link
	}
	
	@Test
	public void testeBuscaTexto() {
		dsl.clicar("buttonSimple");
		//assertTrue(drive2.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		assertEquals("Campo de Treinamento", dsl.getTexto(By.tagName("h3")));
		assertEquals("Cuidado onde clica, muitas armadilhas...",dsl.getTexto(By.tagName("facilAchar")));
	}
}
