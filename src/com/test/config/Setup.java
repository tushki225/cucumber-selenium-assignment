package com.test.config;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.constants.Constants;
import cucumber.api.java.Before;

public class Setup {

    public static WebDriver driver;
    public static WebDriverWait wait;
    
	@SuppressWarnings("deprecation")
	@Before
    public void setWebDriver() throws Exception {  
//    	ChromeOptions chromeOptions = new ChromeOptions();
//    	chromeOptions.addArguments("--disable-notifications");
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
		driver=new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver,5);		 
    }
}
