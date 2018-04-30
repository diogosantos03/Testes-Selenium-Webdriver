
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
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@Test
	public void regraNome() {
		/*Inserindo dados no campo sobrenome para testar a regra do campo nome*/
		page.escreverNome("Diogo");
		page.clicarBtnCadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSobrenome() {
		/*Inserindo dados no campo nome para testar a regra do campo sobrenome*/
		page.escreverSobreNome("Santos");
		page.clicarBtnCadastrar();
		Assert.assertEquals("Nome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSexo() {
		page.escreverSobreNome("Santos");
		page.escreverNome("Diogo");
		
		boolean masc = page.radioSexoMasculinoSelecionado();
		boolean fem = page.radioSexoFemininoSelecionado();
		if(!masc || !fem) {
			page.clicarBtnCadastrar();
			Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}else {
			fail();
		}
		
	}
	
	@Test
	public void regraComidaFavorita() {
		page.escreverSobreNome("Santos");
		page.escreverNome("Diogo");
		
		page.clicarSexoMaculino();
		
		page.clicarEmCarne();
		page.clicarEmVegetariano();
		page.clicarBtnCadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraEsportes() {
		page.escreverSobreNome("Santos");
		page.escreverNome("Diogo");
		
		page.clicarSexoMaculino();
		
		page.clicarEmCarne();
		
		page.selecionarEsporte("Karate");
		page.selecionarEsporte("O que eh esporte?");
		page.clicarBtnCadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

}
