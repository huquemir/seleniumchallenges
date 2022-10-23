package com.stepdef;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;
import com.elements.ElementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportsStepDef extends BaseClass {
	
	ElementPage pf = PageFactory.initElements(driver, ElementPage.class);
	
	@Given("User clicks on the profile")
	public void user_clicks_on_the_profile() {
	   pf.getUsername().click();
	}
	
	@Given("User clicks on Reports button")
	public void user_clicks_on_reports_button() {
	   pf.getReportsButton().click(); 
	    
	}

	@When("User clicks on Upload button")
	public void user_clicks_on_upload_button() {
	    pf.getFileUpload().click();
	    
	}

	@When("User Enters Name and User clicks on Ok button")
	public void user_enters_name_and_user_clicks_on_ok_button() {
	    Alert alert = driver.switchTo().alert();
	    alert.sendKeys("Hello");
	    alert.accept();
	    
	}

	@Then("Message {string} is displayed")
	public void message_is_displayed(String expected) {
	    String actual = pf.getDemo().getText();
	    Assert.assertEquals(actual, expected);
	    
	}

	@When("User cancels the alert")
	public void user_cancels_the_alert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	    
	}
	
	@Then("Message {string} is displayed on screen")
	public void message_is_displayed_on_screen(String expected) {
		 String actual = pf.getDemo().getText();
		 Assert.assertEquals(actual, expected);
	}

	@When("User uploads a file")
	public void user_uploads_a_file() throws InterruptedException {
	    pf.getFiles().sendKeys("/Users/mirhuque/Desktop/celcius.png");
	    Thread.sleep(2000);
	    
		/*
		StringSelection s = new StringSelection("/Users/mirhuque/Desktop/celcius.png");
		// Clip-board copy
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		WebElement ele = driver.findElement(By.id("image-file"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		Robot rb = new Robot();
		   // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
		*/
	    
	}

	@Then("The attribute {string} is displayed")
	public void the_file_name_is_displayed(String expected) {
	    String actual = pf.getFiles().getTagName();
	    Assert.assertEquals(actual, expected);
	    
	}

}
