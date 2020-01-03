package com.sm.pages;

import org.openqa.selenium.support.PageFactory;

import com.sm.base.basePage;

public class statusmatePage extends basePage {

	
	public statusmatePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
		
	public String smpagetitle() {
		return driver.getTitle();
	}
	
}
