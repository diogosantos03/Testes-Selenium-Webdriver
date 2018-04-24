package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	@Test
	public void testeTestField() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive = new FirefoxDriver();
		drive.manage().window().setPosition(new Point(100,100));
		drive.manage().window().setSize(new Dimension(500, 500));
		drive.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		drive.findElement(By.id("elementosForm:nome")).sendKeys("Diogo");
		assertEquals("Diogo",drive.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		drive.quit();
	}
	
	@Test
	public void testeTestArea() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive1 = new FirefoxDriver();
		drive1.manage().window().setPosition(new Point(100,100));
		drive1.manage().window().setSize(new Dimension(500, 500));
		drive1.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		drive1.findElement(By.id("elementosForm:sugestoes")).sendKeys("Melhorar o forms");
		assertEquals("Melhorar o forms",drive1.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		drive1.quit();
	}
	
	@Test
	public void testeTestRadioButton() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(500, 500));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		drive2.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(drive2.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		drive2.quit();
		
	}
	
	@Test
	public void testeTestCampoSelect() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(500, 500));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		drive2.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		assertTrue(drive2.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		drive2.quit();
		
	}
	
	
	@Test
	public void testeTestComboEscolaridade() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement elemento = drive2.findElement(By.id("elementosForm:escolaridade"));
		
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
		
		
		drive2.quit();
		
	}
	
	@Test
	public void testeTestComboMultiplasEscolhas() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement elemento = drive2.findElement(By.id("elementosForm:esportes"));
		
		Select selecoesParaCombos = new Select(elemento);
		selecoesParaCombos.selectByVisibleText("Natacao");
		selecoesParaCombos.selectByVisibleText("Karate");
		selecoesParaCombos.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> lista = selecoesParaCombos.getAllSelectedOptions();
		assertEquals(3, lista.size());
		
		drive2.quit();
	}
	
	@Test
	public void testeTestBtn() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		drive2.findElement(By.id("buttonSimple")).click();
		assertEquals("Obrigado!", drive2.findElement(By.id("buttonSimple")).getAttribute("value"));
		drive2.quit();
		
	}
	@Test
	@Ignore
	public void testeTestLink() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		drive2.findElement(By.linkText("Voltar"));
		
		//TODO falta terminar esse test, verificando os textos depois que quicado no link
		
		//drive2.quit();
	}
	
	@Test
	public void testeBuscaTexto() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver drive2 = new FirefoxDriver();
		drive2.manage().window().setPosition(new Point(100,100));
		drive2.manage().window().setSize(new Dimension(700, 700));
		drive2.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		drive2.findElement(By.id("buttonSimple")).click();
		//assertTrue(drive2.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		assertEquals("Campo de Treinamento", drive2.findElement(By.tagName("h3")).getText());
		assertEquals("Cuidado onde clica, muitas armadilhas...",drive2.findElement(By.className("facilAchar")).getText());
		
		
		drive2.quit();
		
	}
}
