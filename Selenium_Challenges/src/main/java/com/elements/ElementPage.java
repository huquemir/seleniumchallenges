package com.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ElementPage extends BaseClass {
	
	
	public ElementPage() {
		
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//*[@href='/contact']")
	private WebElement contactButton;

	public WebElement getContactButton() {
		return contactButton;
	}

	
	@FindBy(xpath = "//*[@href='/login']")
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}
	
	
	@FindBy(id = "email")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}
	
	
	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}
	
	@FindBy(linkText = "Reports")
	private WebElement reportsButton;

	public WebElement getReportsButton() {
		return reportsButton;
	}
	
	@FindBy(id = "username")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(id = "uploadfile")
	private WebElement fileUpload;

	public WebElement getFileUpload() {
		return fileUpload;
	}
	
	@FindBy(id = "demo")
	private WebElement demo;

	public WebElement getDemo() {
		return demo;
	}
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement files;

	public WebElement getFiles() {
		return files;
	}
	
	@FindBy(xpath = "//*[text()='Morning']")
	private WebElement morningCheckbox;

	public WebElement getMorningCheckbox() {
		return morningCheckbox;
	}
	
	@FindBy(xpath = "//*[text()='Afternoon']")
	private WebElement afternoonCheckbox;

	public WebElement getAfternoonCheckbox() {
		return afternoonCheckbox;
	}
	
	@FindBy(xpath = "//*[text()='Evening']")
	private WebElement eveningCheckbox;

	public WebElement getEveningCheckbox() {
		return eveningCheckbox;
	}
	
	@FindBy(xpath = "//*[text()='Monday']")
	private WebElement selectMonday;

	public WebElement getSelectMonday() {
		return selectMonday;
	}
	
	@FindBy(xpath = "//*[text()='Tuesday']")
	private WebElement selectTuesday;

	public WebElement getSelectTuesday() {
		return selectTuesday;
	}
	
	@FindBy(xpath = "//*[@class='my-3 p-3 rounded card']/a")
	private List<WebElement> selectProducts;

	public List<WebElement> getSelectProducts() {
		return selectProducts;
	}
	
	
}
