package br.com.framework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
