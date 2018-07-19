package br.com.framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class TesteCampoTreinamento {
	private CampoTreinamentoPage page;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
		dsl = new DSL();
	}
	@After
	public void finaliza() {
		DriverFactory.killDriver();//driver.quit();
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
		WebElement elemento = DriverFactory.getDriver().findElement(By.id("elementosForm:escolaridade"));
		
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
		WebElement elemento = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
		
		Select selecoesParaCombos = new Select(elemento);
		List<WebElement> lista = selecoesParaCombos.getAllSelectedOptions();
		assertEquals(3, lista.size());
	}
	
	@Test
	public void testeTestBtn() {
		page.clicarBtnCliqueMe();
		assertEquals("Obrigado!", page.obterTextBtnCliqueMe());
		DriverFactory.killDriver();
		
	}
	@Test
	
	@Ignore
	public void testeTestLink() {
		DriverFactory.getDriver().findElement(By.linkText("Voltar"));
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
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("alert('Testando alert Selenium')");
		//String msg = driver.switchTo().alert().getText();
		DriverFactory.getDriver().switchTo().alert().accept();
		js.executeScript("document.getElementById('elementosForm:nome').value = msg");
	}
	
	@Test
	public void clicarBtnTabela() {
		dsl.clicarBtnTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
	}
}
