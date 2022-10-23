package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.base.BaseClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"Features/"},
		plugin = {"pretty","json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue = {"com.stepdef","com.hooks"},
		monochrome = true
		)

public class RunnerClass extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	@Parameters("browserType")
	public static void beforeTest(@Optional("firefox") String browser) {
		BaseClass.initializeProperties();
		BaseClass.prop.setProperty("BrowserType", browser);
	}

	@AfterClass
	public static void afterTest() {
		
	}

}
