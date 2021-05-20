package com.qa.hs.keyword.engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.hs.keyword.basepackage.basepage;


@SuppressWarnings("unused")
public class KeyWordEngine {

	
	public WebDriver driver ;
	public Properties prop;
	
	
	public static Workbook book;
	public static Sheet sheet;
	
	 public basepage base;
	 public WebElement element;
	
	 public final String EXCEL_SHEET_PATH = ("C:\\Users\\Devesh Singhal\\eclipse-workspace\\MyFirstMavenDemo"
			 + "\\src\\main\\java\\com\\qa\\hs\\keyword\\scenarios\\test_scenarios7.xlsx");
	 

	public void startExecution(String sheetName) throws  InterruptedException, EncryptedDocumentException, IOException  {
	 
		 FileInputStream file = null;
		
		 file  = new FileInputStream(EXCEL_SHEET_PATH);

		 book = WorkbookFactory.create(file);
		 
		 sheet = book.getSheetAt(0);
		 
		 int k = 0;
		 
		 for (int i = 0; i < sheet.getLastRowNum(); i++) {

			 try {
				 
		 String locatorType = sheet.getRow(i+1).getCell(k+1).toString().trim();
		 String locatorValue = sheet.getRow(i+1).getCell(k+2).toString().trim();
         String action = sheet.getRow(i+1).getCell(k+3).toString().trim();
	     String value = sheet.getRow(i+1).getCell(k+4).toString().trim();

	  
	 switch (action) {
	 
	   case "open browser":
	      base = new basepage();
	      prop = base.init_properties();
	      
	          if(value.isEmpty() || value.equals("NA")) {
	    	  driver = base.init_driver(prop.getProperty("browser"));
	    	  } else {
	    	  
	    	  driver = base.init_driver(value);
	      }
	    
	      break;
	    	 
		 
	   case "enter url":
	       if(value.isEmpty() || value.equals("NA")) {
	    	   
    		 driver.get(prop.getProperty("url"));
    	 } else {
                 driver.get(value);
                 Thread.sleep(4000);
                 
                 driver.manage().window().maximize();
              Thread.sleep(15000);        
                         
	 }
	  
      break;  
      
	   case "quit":
		   driver.quit();
		   break;
		  
		   
 default:
    	break;
	     }
	     
	     
	   
		switch (locatorType) {
	     
	     case "id":
	    	 WebElement element = driver.findElement(By.id(locatorValue));
	    	 if(action.equalsIgnoreCase("sendKeys")) {
	    	element.clear();		 
	    	 element.sendKeys(value);
	    	 Thread.sleep(5000);
	    
	     } else if (action.equalsIgnoreCase("click")) {
	    	  element.click();
	    	  
	    	  
	    	 
	     } else if (action.equalsIgnoreCase("isDisplayed")) {
    		 element.isDisplayed();
    		 
    		 Thread.sleep(10000);
    		 
    	 }
	    	 locatorType=null;
	    	 
		   break;
		 
		
	     case "className":
	    	 element = driver.findElement(By.className(locatorValue));
	    	 if(action.equalsIgnoreCase("sendKeys")) {
	    	element.clear();		 
	    	 element.sendKeys(value);
	   
	    
	     } else if (action.equalsIgnoreCase("click")) {
	    	 element.click();
	    	 new WebDriverWait(driver, Duration.ofSeconds(10));
	
	    	 
	    	 
	     } else if (action.equalsIgnoreCase("isDisplayed")) {
    		 element.isDisplayed();
    		 Thread.sleep(5000);
    		 
    	 }
	    	 locatorType=null;
	    	 
		   break;
		   
		   
		   
	     case "name":
	    	 element = driver.findElement(By.name(locatorValue));
	    	 if(action.equalsIgnoreCase("sendKeys")) {
	    	element.clear();		 
	    	 element.sendKeys(value);
	    	 Thread.sleep(10000);
	    	 
	    	 driver.findElement(By.xpath("//*[@id='day']")).click();
	    	 
	    		// Create object of the Select class
	    		Select se = new Select(driver.findElement(By.xpath("//*[@id='day']")));
	    		 
	    		// Select the option by index
	    		se.selectByIndex(6);
	    		
	    		Thread.sleep(8000);
	    		driver.findElement(By.xpath("//*[@id='day']")).click();
	    
	     } else if (action.equalsIgnoreCase("click")) {
	    	 
	    	 element.click();
	    	 Thread.sleep(10000);
	  
	  
	     } 
	    	 locatorType=null;
	    	 
		   break;
		   
		
		   
		   
		   
		   
	     case "linkText":
	    	 element = driver.findElement(By.linkText(locatorValue));
	    	 if(action.equalsIgnoreCase("sendKeys")) {
	    	element.clear();		 
	    	 element.sendKeys(value);
	    
	     } else if (action.equalsIgnoreCase("click")) {
	    	 
	    	 element.click();
	    	 Thread.sleep(10000);
	    	 
	  
	     } 
	    	 locatorType=null;
	    	 
		   break;
		   
		   
		   
		   
		   case "xpath":
			   
			  element = driver.findElement(By.xpath(locatorValue));
	 	    	 if(action.equalsIgnoreCase("sendKeys")) {
		    	element.clear();		 
		    	 element.sendKeys(value);
		    
		     } else if (action.equalsIgnoreCase("click")) {
		    	 
		    	 element.click();
		    	 Thread.sleep(15000);
		 
	 
		     }  else if (action.equalsIgnoreCase("isDisplayed")) {
		    		 element.isDisplayed();
		    		 Thread.sleep(15000);
		    	 }
		     
		    	 locatorType=null;
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

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 