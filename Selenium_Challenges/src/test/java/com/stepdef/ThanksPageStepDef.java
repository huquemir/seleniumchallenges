package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

import io.cucumber.java.en.When;

public class ThanksPageStepDef extends BaseClass {
	
	@When("User clicks on the Submit button on contacts page")
	public void user_clicks_on_the_submit_button_on_contacts_page() {
	    driver.findElement(By.id("submit-form")).click();
	    
	}

	@When("User drag and drops an item")
	public void user_drag_and_drops_an_item() {
        WebElement from = driver.findElement(By.xpath("//*[text()='Thanks']"));
        WebElement to = driver.findElement(By.xpath("//*[text()='Contacting']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(from, to).build().perform();
	    
	}

	@When("User switches to the iframe and clicks on the zoom in button")
	public void user_switches_to_the_iframe_and_clicks_on_the_zoom_in_button() {
	    
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        for (int i=0; i<5; i++) {
        driver.findElement(By.xpath("//*[@class='leaflet-control-zoom-in']")).click();
        }
	}

}
