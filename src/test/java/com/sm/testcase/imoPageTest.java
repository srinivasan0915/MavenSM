package com.sm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sm.base.basePage;
import com.sm.pages.homePage;
import com.sm.pages.imoPage;
import com.sm.pages.loginPage;
import com.sm.utility.Testutil;

public class imoPageTest extends basePage {
	loginPage loginpageob;
	homePage homepageob;
	Testutil testutil;
	imoPage imopageob;
	String sheetName = "IMO_Data";
	
	public imoPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		setdriver();
		testutil = new Testutil();
		loginpageob = new loginPage();
		homepageob = loginpageob.login(pro.getProperty("username"), pro.getProperty("password"));
		//imopageob = new imoPage();
		imopageob = homepageob.imopageopen();
		
	}
	
	@Test(priority=1)
	public void imopagetitle(){
		System.out.println("Click on IMO 2020 Rate search button:");
		String imopagetitle = imopageob.imoPageTitle();
		Assert.assertEquals(imopagetitle, "IMO 2020 Rate Search");
		System.out.println("Page Title :" +imopagetitle);
		String imoHeadername = imopageob.imoPageHeaderTitle();
		Assert.assertEquals(imoHeadername, "IMO 2020 RATE SEARCH");
		System.out.println("Header Title :"	+ imoHeadername);
	}
	
	@Test(priority=2, dataProvider="imo2020data")
	public void imoPageTestvalue(String Origin, String Destination) throws InterruptedException{
		imopageob.imoPageRatevalue(Origin, Destination);
	}
	
	@DataProvider
	public Object[][] imo2020data(){
		Object data[][] = Testutil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
