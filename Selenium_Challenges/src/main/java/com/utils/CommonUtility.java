package com.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class CommonUtility extends BaseClass {
	
	public static void clickCheckbox(WebElement checkbox) {
        if(checkbox.isSelected()) {
        	System.out.println("Checkbox is Selected");
        } else if(!checkbox.isSelected()) {
        	checkbox.click();
        	System.out.println("Now selecting Checkbox");
        } else {
        	System.out.println("Checkbox is Not selected");
        }

	}
	
	
	public static void clickRadioButton(WebElement radioButton) {
		
        if(radioButton.isSelected()) {
        	System.out.println("Radio Button is Selected");
        } else if(!radioButton.isSelected()) {
        	radioButton.click();
        	System.out.println("Now selecting Radio Button");
        } else {
        	System.out.println("Radio Button is Not selected");
        }
	}
	
	public static void mouseHover(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
	
	public static void clickDynamicElement(List<WebElement> element, int num) {		
		for(int i=0; i<element.size(); i++) {
			if(i>=num) {
				element.get(i).click();
				break;
			}
		}		
	}

	

}
