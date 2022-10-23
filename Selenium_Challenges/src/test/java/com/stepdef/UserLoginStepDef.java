package com.stepdef;

import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.elements.ElementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStepDef extends BaseClass {
	
	ElementPage pf = PageFactory.initElements(driver, ElementPage.class);
	
	@Given("User clicks on the sign in button")
	public void user_clicks_on_the_sign_in_button() {
	    pf.getSignInButton().click();
	    
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {
	   pf.getEmail().sendKeys("testuser@email.com");
	   pf.getPassword().sendKeys("123456");
	    
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
	    pf.getSignIn().click();
	    
	}

	@Then("user is able to sign in")
	public void user_is_able_to_sign_in() {
	    
	    
	}

}
