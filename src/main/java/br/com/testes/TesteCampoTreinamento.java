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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class TesteCampoTreinamento {
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
		//driver.quit();
	}
	
	@Test
	public void testeTestField() {
		page.escreverNome("Diogo");
		assertEquals("Diogo",page.obterCampoNome());
	}
	
	@Test
	public void testeTestArea() {
		page.escreverSugetao("Melhorar o forms");
		assertEquals("Melhorar o forms",page.obterCampoSugestao());
	}
	
	@Test
	public void testeTestRadioButton() {
		page.clicarSexoMaculino();
		assertTrue(page.radioSexoMasculinoSelecionado());
	}
	
	@Test
	public void testeTestCampoSelect() {
		page.clicarEmCarne();
		assertTrue(page.carneEstaSelecionada());
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
		page.selecionarEsporte("Natacao");
		page.selecionarEsporte("Karate");
		page.selecionarEsporte("O que eh esporte?");
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		
		Select selecoesParaCombos = new Select(elemento);
		List<WebElement> lista = selecoesParaCombos.getAllSelectedOptions();
		assertEquals(3, lista.size());
	}
	
	@Test
	public void testeTestBtn() {
		page.clicarBtnCliqueMe();
		assertEquals("Obrigado!", page.obterTextBtnCliqueMe());
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
		page.clicarBtnCliqueMe();
		//assertTrue(drive2.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		assertEquals("Campo de Treinamento", page.obterTituloPagina());
		assertEquals("Cuidado onde clica, muitas armadilhas...",page.obtertxtFacil());
	}
	
	@Ignore
	public void testJavaScript(){
		//TODO Este teste foi implementado na class TestesFrames no método testeFrame2
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Testando alert Selenium')");
		//String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		js.executeScript("document.getElementById('elementosForm:nome').value = msg");
		
	}
}
