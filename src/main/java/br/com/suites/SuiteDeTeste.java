package br.com.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.core.DriverFactory;
import br.com.testes2.DesafioDeCadastro;
import br.com.testes2.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	DesafioDeCadastro.class,
	TesteRegrasCadastro.class,
	/*Desafio2RegrasDaPag.class,
	TesteCampoTreinamento.class,
	TesteGoogle.class,
	TestesAlert.class,
	TestesFrames.class*/
})
public class SuiteDeTeste {
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
