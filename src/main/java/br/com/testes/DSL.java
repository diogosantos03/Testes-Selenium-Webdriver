package br.com.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escrever(String idElemento, String txt) {
		driver.findElement(By.id(idElemento)).sendKeys(txt);
	}
	
	public String getIdCampo(String idElement) {
		return driver.findElement(By.id(idElement)).getAttribute("value");
	}
	public void clicar(String idElement) {
		driver.findElement(By.id(idElement)).click();
	}
	public boolean isRadioSelect(String idElement) {
		return driver.findElement(By.id(idElement)).isSelected();
	}
	
	public void selecionarCombo(String idElement, String valorSelecionado) {
		WebElement elemento = driver.findElement(By.id(idElement));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valorSelecionado);
	}
	public String getTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public Object executarJavaScriptCod(String cmd, Object... param){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
	
	public void clicarNoBtn(String id){
		driver.findElement(By.id(id)).click();
	}
	
}
