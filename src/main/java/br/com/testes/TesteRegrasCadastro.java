package br.com.testes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Parameter(value=0)
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
		//comidas = new ArrayList<String>();
		//esportes = new String[4];
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getCollections(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Diogo", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Diogo", "Santos", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Diogo", "Santos", "Masculino", Arrays.asList("Carne","Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Diogo", "Santos", "Masculino", Arrays.asList("Carne"), new String[]{"Karate","O que eh esporte?"}, "Voce faz esporte ou nao?"}
			
		});
	}
	@Test
	public void deveValidarRegras() {
		page.escreverSobreNome(sobrenome);
		page.escreverNome(nome);
		if(sexo.equals("Masculino"))page.clicarSexoMaculino();
		if(sexo.equals("Feminino"))page.clicarSexoFeminino();
		
		
		if(comidas.contains("Carne"))page.clicarEmCarne();
		if(comidas.contains("Pizza"))page.clicarEmPizza();
		if(comidas.contains("Vegetariano"))page.clicarEmVegetariano();
		page.setEsporte(esportes);
		page.clicarBtnCadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
