package br.com.testes;

import java.util.List;

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
	public void clicar(By by) {
		driver.findElement(by).click();
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
	
	public void clicarBtnTabela(String colunaBusca, String valor, String colunaBtn, String idTabela) {
		WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		obterIndiceColuna(colunaBusca, tabela);
		
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		int idColunaBotao = obterIndiceColuna(colunaBtn, tabela);
		
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
	}

	public int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idlinha = -1;
		for(int i=0; i<linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idlinha = i+1;
				break;
			}
		}
		return idlinha;
	}

	public int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i=0; i<colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
