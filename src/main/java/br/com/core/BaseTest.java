package br.com.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) DriverFactory.getDriver();
		File arq = takeScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arq, new File("/home/diogo/eclipse-workspace/Testes-Selenium-Webdriver/target/screenshots/"+testName.getMethodName()+".png"));
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
		
	}
}
