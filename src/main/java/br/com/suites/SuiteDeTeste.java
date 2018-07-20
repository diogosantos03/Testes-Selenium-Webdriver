package br.com.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.testes2.Desafio2RegrasDaPag;
import br.com.testes2.DesafioDeCadastro;
import br.com.testes2.TesteCampoTreinamento;
import br.com.testes2.TesteGoogle;
import br.com.testes2.TesteRegrasCadastro;
import br.com.testes2.TestesAlert;
import br.com.testes2.TestesFrames;

@RunWith(Suite.class)
@SuiteClasses({
	Desafio2RegrasDaPag.class,
	DesafioDeCadastro.class,
	TesteCampoTreinamento.class,
	TesteGoogle.class,
	TesteRegrasCadastro.class,
	TestesAlert.class,
	TestesFrames.class
})
public class SuiteDeTeste {

}
