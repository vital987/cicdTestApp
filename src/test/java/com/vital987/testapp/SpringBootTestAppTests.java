package com.vital987.testapp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import java.io.IOException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) @ExtendWith(SeleniumJupiter.class)
class SpringBootTestAppTests
{
	@LocalServerPort
	int randomServerPort;

	protected ChromeDriver driver;

	@BeforeEach
	public void before()
	{
		ChromeOptions options;
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments(
				"--disable-dev-shm-using", 
				"--disable-extensions", 
				"--disable-gpu", 
				"--headless",
				"--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@ParameterizedTest @ValueSource(strings = "")
	void additionCheck()
	{
		driver.get("http://127.0.0.1:" + randomServerPort);
		float x = Float.parseFloat(driver.findElement(By.id("numx")).getText());
		float y = Float.parseFloat(driver.findElement(By.id("numy")).getText());
		float add = Float.parseFloat(driver.findElement(By.id("add")).getText());
		assertEquals(add, x + y);
	}

	@ParameterizedTest @ValueSource(strings = "")
	void substractionCheck()
	{
		driver.get("http://127.0.0.1:" + randomServerPort);
		float x = Float.parseFloat(driver.findElement(By.id("numx")).getText());
		float y = Float.parseFloat(driver.findElement(By.id("numy")).getText());
		float substract = Float.parseFloat(driver.findElement(By.id("substract")).getText());
		assertEquals(substract, x - y);
	}

	@ParameterizedTest @ValueSource(strings = "")
	void multiplicationCheck()
	{
		driver.get("http://127.0.0.1:" + randomServerPort);
		float x = Float.parseFloat(driver.findElement(By.id("numx")).getText());
		float y = Float.parseFloat(driver.findElement(By.id("numy")).getText());
		float multiply = Float.parseFloat(driver.findElement(By.id("multiply")).getText());
		assertEquals(multiply, x * y);
	}

	@ParameterizedTest @ValueSource(strings = "")
	void divisionCheck()
	{
		driver.get("http://127.0.0.1:" + randomServerPort);
		float x = Float.parseFloat(driver.findElement(By.id("numx")).getText());
		float y = Float.parseFloat(driver.findElement(By.id("numy")).getText());
		float divide = Float.parseFloat(driver.findElement(By.id("divide")).getText());
		assertEquals(divide, x / y);
	}

	@Test
	void podNameCheck() throws IOException
	{
		assertEquals(0, Exec.returnVal("bash -c 'if [[ -z \"$HOSTNAME\" ]]; then false; fi'"));
	}
}
