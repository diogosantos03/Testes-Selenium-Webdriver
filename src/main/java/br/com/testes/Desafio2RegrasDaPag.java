package br.com.testes;


import static org.junit.Assert.fail;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio2RegrasDaPag {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void regraNome() {
		/*Inserindo dados no campo sobrenome para testar a regra do campo nome*/
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("test");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Nome eh obrigatorio",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSobrenome() {
		/*Inserindo dados no campo nome para testar a regra do campo sobrenome*/
		driver.findElement(By.id("elementosForm:nome")).sendKeys("test");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Sobrenome eh obrigatorio", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraSexo() {
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("test");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("test");
		
		boolean masc = driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		boolean fem = driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		if(!masc || !fem) {
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Assert.assertEquals("Sexo eh obrigatorio", driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}else {
			fail();
		}
		
	}
	
	@Test
	public void regraComidaFavorita() {
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("test");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("test");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void regraEsportes() {
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("test");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("test");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement webElement = driver.findElement(By.id("elementosForm:esportes"));
		Select select = new Select(webElement);
		select.selectByVisibleText("Karate");
		select.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Voce faz esporte ou nao?",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	
	@After
	public void finaliza() {
		driver.quit();
	}

}
