package com.sm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sm.base.basePage;
import com.sm.pages.homePage;
import com.sm.pages.loginPage;
import com.sm.pages.statusmatePage;

public class statusmatePageTest extends basePage{
	loginPage loginpageob;
	homePage homepageob;
	statusmatePage smpageob;

	public statusmatePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws Exception {
		setdriver();
		loginpageob = new loginPage();
		homepageob = loginpageob.login(pro.getProperty("username"), pro.getProperty("password"));

	
	}
	
	@Test(priority = 1)
	public void getPageTitletest() {
		String pageTitle = smpageob.smpagetitle();
		Assert.assertEquals(pageTitle, "Statusmate - Vanguard Logistics Services");
	}
		
	@AfterMethod
	public void teardown() {
		driver.close();
	}


}

