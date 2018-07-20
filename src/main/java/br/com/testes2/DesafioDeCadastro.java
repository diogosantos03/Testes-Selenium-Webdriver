package br.com.testes2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import br.com.page.CampoTreinamentoPage;

public class DesafioDeCadastro extends BaseTest{
	private CampoTreinamentoPage page;
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "/home/diogo/Documentos/Curso_Selenium/Gecko_Drive/geckodriver");
		DriverFactory.getDriver().get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	
	@Test
	public void desafio() {
		page.setNome("Diogo");
		page.setSobreNome("Santos");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.clicarBtnCadastrar();
		
		assertEquals("Cadastrado!", page.obterResultadoCadastro());
		assertEquals("Diogo",page.obterNomeCadastro());
		assertEquals("Santos",page.obterSobreNomeCadastro());
		assertEquals("Masculino",page.obterSexoCadastro());
		assertEquals("Pizza",page.obterComidaCadastro());
		assertEquals("mestrado", page.obterEscolaridadeCadastro());
		assertEquals("Natacao",page.obterEsporteCadastro());
	}
}
