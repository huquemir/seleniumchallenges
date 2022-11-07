package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"Features/Api.feature"},
		plugin = {"pretty","json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue = {"com.stepdef"},
		monochrome = true
		)

public class ApiRunnerClass extends AbstractTestNGCucumberTests {
	
	

}
