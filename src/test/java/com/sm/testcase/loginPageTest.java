package com.sm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sm.base.basePage;
import com.sm.pages.homePage;
import com.sm.pages.loginPage;

public class loginPageTest extends basePage {
	loginPage loginpageob;
	homePage homepageob;

	public loginPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws Exception {
		setdriver();
		loginpageob = new loginPage();
	}
	
	@Test(priority = 1)
	public void getPageTitletest() {
		String pageTitle = loginpageob.gethometitle();
		Assert.assertEquals(pageTitle, "Tools - Vanguard Logistics Services");
	}
	@Test(priority = 2)
	public void logintest() throws Exception {
		homepageob = loginpageob.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}


}
