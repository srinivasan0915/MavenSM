package com.sm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sm.base.basePage;

public class homePage extends basePage {

	@FindBy(xpath = "/li[@id='li_Statusmate']")
	WebElement smpagego;
	
	@FindBy(xpath = "//a[@href='/apps/ui/#/']//following::li[7]")
	WebElement adesso;
	
	/*@FindBy(xpath="//a[@href='/apps/ui/#/imo'])[1]")
	WebElement imogo;*/
	
	@FindBy(xpath="//div[@id='Quoting_Tools']/div[1]/div[1]/ul[1]/li[5]/figure[1]/figcaption[1]/a[1]")
	WebElement imogo;
	
	@FindBy(linkText = "GO")
	WebElement go;
	
	@FindBy(linkText = "GO")
	WebElement gotext;

	public homePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
		
	public String homepagetitle() {
		return driver.getTitle();
	}
	
	/*public statusmatePage smpageopen() throws Exception {
		smpagego.click();
		return new statusmatePage();
	}
	*/
/*	public adessoPage adessopageopen()throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(adesso).click().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("GO")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(go).click().perform();
		return new adessoPage();
	}*/
	
	public imoPage imopageopen()throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(imogo).click().perform();
		//imogo.click();
		/*Actions action1 = new Actions(driver);
		action1.moveToElement(go).click().perform();*/
		return new imoPage();
	}

}
