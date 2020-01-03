package com.sm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.base.basePage;

public class loginPage extends basePage {

	// Page Factory - Object Repository(OR)
	@FindBy(className = "my-vanguard")
	WebElement login;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(css = "input[value='LOG IN']")
	WebElement loginpopup;

	// Initializing the Page Objects:
	public loginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String gethometitle() {
		return driver.getTitle();
	}

	public homePage login(String user, String pass) throws Exception {
		login.click();
		username.sendKeys(user);
		password.sendKeys(pass);
		loginpopup.click();
		return new homePage();
	}

}
