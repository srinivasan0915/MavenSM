package com.sm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sm.base.basePage;
import com.sm.pages.adessoPage;
import com.sm.pages.homePage;
import com.sm.pages.imoPage;
import com.sm.pages.loginPage;
//import com.sm.pages.statusmatePage;

public class homePageTest extends basePage {
	loginPage loginpageob;
	homePage homepageob;
	adessoPage adessopageob;
	imoPage imopageob;

	public homePageTest() throws Exception {
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
		String pageTitle = homepageob.homepagetitle();
		Assert.assertEquals(pageTitle, "Tools - Vanguard Logistics Services");
	}
/*	@Test(priority = 2)
	public void statusmatemenu() throws Exception {
		smpageob = homepageob.smpageopen();
		
	}
	*/
/*	@Test(priority = 3)
	public void adessomenu() throws Exception {
	homepageob.adessopageopen();
	}*/
	
	@Test(priority = 4)
	public void adessomenu() throws Exception {
	homepageob.imopageopen();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
