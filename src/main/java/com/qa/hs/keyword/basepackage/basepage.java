package com.qa.hs.keyword.basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class basepage {

	
	public WebDriver driver ;
	public Properties prop ;
	
	public WebDriver init_driver(String browserName) {
		
		ChromeOptions options = new ChromeOptions(); 
	HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
	HashMap<String, Object> profile = new HashMap<String, Object>();
	HashMap<String, Object> prefs = new HashMap<String, Object>();
	
	conentSettings.put("notifications", 1);
	profile.put("managed_default_content_settings", conentSettings);
	prefs.put("profile", profile);
	options.setExperimentalOption("prefs", prefs);
	

		
      if(browserName.equals("chrome"))	{
			
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	  
	  
		if(prop.getProperty("headless").equals("yes")) {
			
			//headless mode:
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
		} else {
			
			driver = new ChromeDriver();
		}
      }
      
      return driver ;
				
		}
	  
	  public Properties init_properties() {
		  
		  prop = new Properties();	 
	try
	{
		
FileInputStream ip = new FileInputStream("C:\\Users\\Devesh Singhal\\eclipse-workspace\\MyFirstMavenDemo\\"
		+"src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
	  
   prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	 return prop;
}
	  
}




