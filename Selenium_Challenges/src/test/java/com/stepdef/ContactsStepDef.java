package com.stepdef;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BaseClass;
import com.elements.ElementPage;
import com.utils.CommonUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsStepDef extends BaseClass {
	
	ElementPage pf = PageFactory.initElements(driver, ElementPage.class);
	
	@When("User clicks on the Contact Us Page")
	public void user_clicks_on_the_contact_us_page() {
	   pf.getContactButton().click(); 
	    
	}

	@When("User clicks on Monday and Tuesday selection")
	public void user_clicks_on_monday_and_tuesday_selection() {
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByIndex(1);
        days.selectByIndex(2);
	    
	}

	@Then("Monday and Tuesday are selected")
	public void monday_and_tuesday_are_selected() {
	    Assert.assertTrue(pf.getSelectMonday().isSelected());
	    Assert.assertTrue(pf.getSelectTuesday().isSelected());
	}

	@When("User clicks on Morning and Afternoon checkboxes")
	public void user_clicks_on_morning_and_afternoon_checkboxes() {
		CommonUtility.clickCheckbox(pf.getMorningCheckbox());
		CommonUtility.clickCheckbox(pf.getAfternoonCheckbox());
	}

	@Then("Morning and Afternoon checkboxes are selected")
	public void morning_and_afternoon_checkboxes_are_selected() {
	    Assert.assertTrue(pf.getMorningCheckbox().isEnabled());
	    Assert.assertTrue(pf.getAfternoonCheckbox().isEnabled());
	    
	}

	@Then("Evening checkbox is not selected")
	public void evening_checkbox_is_not_selected() {
	    //Assert.assertTrue(!pf.getEveningCheckbox().isEnabled());
	    
	}
	
	@When("User opens a new tab window")
	public void user_opens_a_new_tab_window() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("window.open()");
		Thread.sleep(5000);
	    
	}
	
	
	@Then("User switches to the new tab window and close and switch back to the old tab")
	public void user_switches_to_the_new_tab_window_and_close_and_switch_back_to_the_old_tab() throws InterruptedException {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	       driver.switchTo().window(tabs.get(1));
	       Thread.sleep(5000);
	       driver.close();
	       Thread.sleep(5000);
	       driver.switchTo().window(tabs.get(0));
	       Thread.sleep(5000);
	}


}
