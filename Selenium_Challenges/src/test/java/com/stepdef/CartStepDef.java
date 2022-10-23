package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;
import com.elements.ElementPage;
import com.utils.CommonUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDef extends BaseClass {
	
	ElementPage pf = PageFactory.initElements(driver, ElementPage.class);
	
	@When("User clicks on the first item")
	public void user_clicks_on_the_first_item() {
	    CommonUtility.clickDynamicElement(pf.getSelectProducts(), 0);
	    
	}

	@When("User selects the quantity")
	public void user_selects_the_quantity() throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("(//select[@class='form-control'])[1]")));
		select.selectByValue("2");
		Thread.sleep(5000);
	    
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
	    
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(5000);
	}

	@Then("the correct quantity is displayed")
	public void the_correct_quantity_is_displayed() {
	    
	    
	}
	
	@When("User hovers over their profile")
	public void user_hovers_over_their_profile() throws InterruptedException {
	   CommonUtility.mouseHover(driver.findElement(By.linkText("Profile")));
	   Thread.sleep(5000);
	}

}
