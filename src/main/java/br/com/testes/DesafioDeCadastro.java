package br.com.testes;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioDeCadastro {
	@Test
	public void desafio() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(700, 700));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Diogo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
	
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select elementos = new Select(elemento);
		elementos.selectByVisibleText("Mestrado");
		
		WebElement elemento2 = driver.findElement(By.id("elementosForm:esportes"));
		Select elementos2 = new Select(elemento2);
		elementos2.selectByVisibleText("Natacao");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		
		assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
		
		assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Diogo"));
		assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Santos"));
		assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
		assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("mestrado"));
		assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao"));
		
	
		driver.quit();
	}
}
