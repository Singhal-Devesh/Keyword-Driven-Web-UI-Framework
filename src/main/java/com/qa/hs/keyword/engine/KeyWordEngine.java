package com.qa.hs.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graphbuilder.curve.Point;
import com.qa.hs.keyword.basepackage.basepage;

public class KeyWordEngine {

	
	public WebDriver driver ;
	public Properties prop;
	
	
	public static Workbook book;
	public static Sheet sheet;
	
	 public  basepage base;
	 public WebElement element;
	
	 public final String EXCEL_SHEET_PATH = "C:\\Users\\Devesh Singhal\\eclipse-workspace\\MyFirstMavenDemo"
			 + "\\src\\main\\java\\com\\qa\\hs\\keyword\\scenarios\\hubspot_scenarios.xlsx";
	 
	 @SuppressWarnings("deprecation")
	public void startExecution(String sheetName) throws InvalidFormatException, InterruptedException   {
	 
		 String locatorName = null;
		 String locatorValue =  null;
		 
		 
		 FileInputStream file = null;
		try { 
		 file  = new FileInputStream(EXCEL_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		try {
		 book = WorkbookFactory.create(file);
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
		 sheet = book.getSheet(sheetName);
		 int k = 0;
		 for(int i=0; i<sheet.getLastRowNum(); i++) {

			 try {
			 
		 String locatorColValue = sheet.getRow(i+1).getCell(k+1).toString();
		 
		  if(!locatorColValue.equalsIgnoreCase("NA")) {
			 
			  
			locatorName = locatorColValue.split("=")[0].trim();
			
			locatorValue = locatorColValue.split("=")[2].trim();
		  } 
		
		  
		 String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
	     String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();


	      
	     switch (action) {
	   case "open browser":
	      base = new basepage();
	      prop = base.init_properties();
	      
	      driver = base.init_driver(value);
	      if(value.isEmpty() || value.equals("NA")){
	    	  driver = base.init_driver(prop.getProperty("browser"));
	    	  
	      } else {
	    	  
	    	  driver = base.init_driver(value);
	      }
	    
	      break;
	    	 
		 
	   case "enter url":
	       if(value.isEmpty() || value.equals("NA")) {
    		 driver.get(prop.getProperty("url"));
    	 } else {
                 driver.get("https://facebook.com");
                 driver.manage().window().maximize();
                 driver.manage().deleteAllCookies();
                
                 driver.navigate().refresh();
                         
             
	 }
	  
      break;  
      
	   case "quit":
		   driver.quit();
		   break;
		   
 default:
    	break;
	     }
	     
	     
	     switch (locatorName) {
	     
	     case "id":
	    	 WebElement element = driver.findElement(By.id(locatorValue));
	    	 if(action.equalsIgnoreCase("sendKeys")) {
	    	element.clear();		 
	    	 element.sendKeys(value);
	    
	     } else if (action.equalsIgnoreCase("click")) {
	    	 
	    	 element.click();
	     } 
	    	 locatorName=null;
	    	 
		   break;
		   
		   default:
			   break;
			   
}   
			 }
	 
		catch(Exception e) {
	    
			 
			 
		 }

		 
	 }


	 }
	 }	 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 