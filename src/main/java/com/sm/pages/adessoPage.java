package com.sm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sm.base.basePage;

public class adessoPage extends basePage {
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="totalWeight")
	WebElement Weight;
	
	@FindBy(id="totalVolume")
	WebElement Volume;
	
	@FindBy(name="package")
	WebElement Package;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement GetaQuote;

	
	public adessoPage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public String adessopagetitle() {
		return driver.getTitle();
	}
	
	public void adessohomepage(String orig, String dest, String weight, String vol, String pack){
		Select ori = new Select(driver.findElement(By.name("d2dPickupPortcode")));
		ori.selectByValue(orig);
		Select des = new Select(driver.findElement(By.name("d2dDeliveryLocation")));
		des.selectByValue(dest);
		Weight.sendKeys(weight);
		Volume.sendKeys(vol);
		Package.sendKeys(pack);
		GetaQuote.click();
		
	}
	

}
