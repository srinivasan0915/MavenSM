package com.sm.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sm.base.basePage;
import com.sm.pages.adessoPage;
import com.sm.pages.homePage;
import com.sm.pages.loginPage;
import com.sm.utility.Testutil;

public class adessoPageTest extends basePage{
	loginPage loginpageob;
	homePage homepageob;
	adessoPage adessopageob;
	Testutil testutil;
	String sheetName = "adessodata";
	
	public adessoPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		setdriver();
		testutil = new Testutil();
		loginpageob = new loginPage();
		adessopageob = new adessoPage();
		homepageob = loginpageob.login(pro.getProperty("username"), pro.getProperty("password"));
		//adessopageob = homepageob.adessopageopen();
	}
	
	@Test(priority=1)
	public void adessopagetitle(){
		String AdessoPageTitle = adessopageob.adessopagetitle();
		Assert.assertEquals(AdessoPageTitle, "ADESSO");
	}
	
	@Test(priority=2, dataProvider="getAdessoTestData")
	public void validatequotepage(String Origin, String Destination, String Weight, String Volume, String NoOfPackage){
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		adessopageob.adessohomepage(Origin, Destination, Weight, Volume, NoOfPackage);
	}
	
	@DataProvider
	public Object[][] getAdessoTestData(){
		Object data[][] = Testutil.getTestData(sheetName);
		return data;
	}

}
