package com.sm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sm.base.basePage;

public class imoPage extends basePage {
	
	@FindBy(xpath = "//div[@class='main-content']//h1[1]")
	WebElement imoHeader;
	
	@FindBy(id = "origin")
	WebElement chooseOrigin;
	
	@FindBy(xpath = "//button[@class='dropdown-item active']")
	WebElement origindrop;
	
	@FindBy(id = "destination")
	WebElement chooseDestination;
	
	@FindBy(xpath = "//button[@class='dropdown-item active']")
	WebElement dropdownDest;
	
	@FindBy(xpath = "//button[contains(@class,'btn vg-btn-fullwidth')]")
	WebElement showRate;
	
	@FindBy(xpath = "//thead[@class='table-head']//tr")
	WebElement tabelheader;
	
	@FindBy(xpath = "//tbody")
	WebElement tabelvalue;
	
	@FindBy(xpath = "//tr[@class='ng-star-inserted']")
	WebElement tabelvaluevaild;
	
	@FindBy(xpath = "//td[@class='text-center']//label[1]")
	WebElement noRateFound;
	
	public imoPage() throws Exception {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public String imoPageTitle() {
		return driver.getTitle();
	}
	public String imoPageHeaderTitle() {
		return imoHeader.getText();
	}
	public void imoPageRatevalue(String Origin, String Destination) throws InterruptedException{
		chooseOrigin.sendKeys(Origin);
		Thread.sleep(1000);
		origindrop.click();
		Thread.sleep(1000);
		System.out.println("Origin Selected Successfully");
		chooseDestination.sendKeys(Destination);
		Thread.sleep(1000);
		dropdownDest.click();
		Thread.sleep(1000);
		System.out.println("Destination Selected Successfully");
		showRate.click();
		if (tabelheader.isDisplayed()){
			System.out.println("Print Header Name : " + "\n" +tabelheader.getText());
			if (tabelvalue.isDisplayed()){
				System.out.println("Print Rate Search Value is present : " + "\n" +tabelvaluevaild.getText());
				Thread.sleep(1000);
			}else {
				System.out.println("Print Rate Search Value is not present : " + "\n" +noRateFound.getText());
				Thread.sleep(1000);
			}
		}
	}

}
