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
	WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void testeTestField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Diogo");
		assertEquals("Diogo",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void testeTestArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Melhorar o forms");
		assertEquals("Melhorar o forms",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void testeTestRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}
	
	@Test
	public void testeTestCampoSelect() {
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
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
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		
		Select selecoesParaCombos = new Select(elemento);
		selecoesParaCombos.selectByVisibleText("Natacao");
		selecoesParaCombos.selectByVisibleText("Karate");
		selecoesParaCombos.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> lista = selecoesParaCombos.getAllSelectedOptions();
		assertEquals(3, lista.size());
	}
	
	@Test
	public void testeTestBtn() {
		driver.findElement(By.id("buttonSimple")).click();
		assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
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
		driver.findElement(By.id("buttonSimple")).click();
		//assertTrue(drive2.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar")).getText());
	}
}
