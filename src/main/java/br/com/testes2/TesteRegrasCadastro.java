package br.com.testes2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import br.com.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest{
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
		DriverFactory.getDriver().get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
		//comidas = new ArrayList<String>();
		//esportes = new String[4];
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
		Assert.assertEquals(msg, DriverFactory.getDriver().switchTo().alert().getText());
		DriverFactory.getDriver().switchTo().alert().accept();
	}

}
