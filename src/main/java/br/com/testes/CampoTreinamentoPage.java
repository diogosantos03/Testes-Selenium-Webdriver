package br.com.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		this.dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome",nome);
	}
	
	public void setSobreNome(String sobreNome) {
		dsl.escrever("elementosForm:sobrenome",sobreNome);
	}
	public void setSexoMasculino() {
		dsl.clicar("elementosForm:sexo:0");
	}
	
	public void setComidaPizza() {
		dsl.clicar("elementosForm:comidaFavorita:2");
	}
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	public void setEsporte(String... esporte) {
		for(String s : esporte) {
			dsl.selecionarCombo("elementosForm:esportes",s);
		}
		
	}
	public void clicarBtnCadastrar() {
		dsl.clicar("elementosForm:cadastrar");
	}
	public String obterResultadoCadastro() {
		return dsl.getTexto(By.id("resultado"));
	}
	public String obterNomeCadastro() {
		return dsl.getTexto(By.id("descNome"));
	}
	public String obterSobreNomeCadastro() {
		return dsl.getTexto(By.id("descSobrenome"));
	}
	public String obterSexoCadastro() {
		return dsl.getTexto(By.id("descSexo"));
	}
	public String obterComidaCadastro() {
		return dsl.getTexto(By.id("descComida"));
	}
	public String obterEscolaridadeCadastro() {
		return dsl.getTexto(By.id("descEscolaridade"));
	}
	public String obterEsporteCadastro() {
		return dsl.getTexto(By.id("descEsportes"));
	}
	public void escreverNome(String txt) {
		dsl.escrever("elementosForm:nome", txt);
	}
	public void escreverSobreNome(String txt) {
		dsl.escrever("elementosForm:sobrenome", txt);
	}
	public boolean radioSexoMasculinoSelecionado() {
		return dsl.isRadioSelect("elementosForm:sexo:0");
	}
	public boolean radioSexoFemininoSelecionado() {
		return dsl.isRadioSelect("elementosForm:sexo:1");
	}
	public void clicarSexoMaculino() {
		dsl.clicar("elementosForm:sexo:0");
	}
	public void clicarSexoFeminino() {
		dsl.clicar("elementosForm:sexo:1");
	}
	public void clicarEmCarne() {
		dsl.clicar("elementosForm:comidaFavorita:0");
	}
	public void clicarFrango() {
		dsl.clicar("elementosForm:comidaFavorita:1");
	}
	public void clicarEmPizza() {
		dsl.clicar("elementosForm:comidaFavorita:2");
	}
	public void clicarEmVegetariano() {
		dsl.clicar("elementosForm:comidaFavorita:3");
	}
	public void selecionarEsporte(String esporte) {
		dsl.selecionarCombo("elementosForm:esportes", esporte);
	}
	
	public String obterCampoNome() {
		return dsl.getIdCampo("elementosForm:nome");
	}
	public void escreverSugetao(String sugestao) {
		dsl.escrever("elementosForm:sugestoes",sugestao);
	}
	public String obterCampoSugestao() {
		return dsl.getIdCampo("elementosForm:sugestoes");
	}
	public boolean carneEstaSelecionada() {
		return dsl.isRadioSelect("elementosForm:comidaFavorita:0");
	}
	public void clicarBtnCliqueMe() {
		dsl.clicar("buttonSimple");
	}
	public String obterTextBtnCliqueMe() {
		return dsl.getIdCampo("buttonSimple");
	}
	public String obterTituloPagina() {
		return dsl.getTexto(By.tagName("h3"));
	}
	public String obtertxtFacil() {
		return dsl.getTexto(By.className("facilAchar"));
	}
	public void clicarBtnAlert() {
		dsl.clicar("alert");
	}
	public void clicarBtnConfirmar() {
		dsl.clicar("confirm");
	}
	public void clicarBtnPrompt() {
		dsl.clicar("prompt");
	}
	public void clicarBtnFrame() {
		dsl.clicar("frameButton");
	}
	public void clicarPopUpEase() {
		dsl.clicar("buttonPopUpEasy");
	}
	public void clicarBtnHard() {
		dsl.clicar("buttonPopUpHard");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
