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
	public void setEsporte(String esporte) {
		dsl.selecionarCombo("elementosForm:esportes",esporte);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
