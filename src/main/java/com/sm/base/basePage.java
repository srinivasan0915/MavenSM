package com.sm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sm.utility.Testutil;
import com.sm.utility.WebEventListener;

public class basePage {
	public static Properties pro;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	public basePage() throws Exception{
		File open = new File("./src/main/java/Configuration/Config.Properties");
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(open);
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setdriver(){
		String browserName= pro.getProperty("browser");
		String brchromeurl = pro.getProperty("chromeurl");
		String brfirefoxurl = pro.getProperty("firefoxurl");
		String brieurl = pro.getProperty("ieurl");
		switch(browserName){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", brchromeurl);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", brfirefoxurl);
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", brieurl);
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Browser : " +browserName +" is invaild, Launching Firefox as browser of choice..");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
}
