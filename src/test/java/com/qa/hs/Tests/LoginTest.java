package com.qa.hs.Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class LoginTest {
	
     public KeyWordEngine keyWordEngine;
	
		
		@Test
		public void loginTest() throws InvalidFormatException, InterruptedException {
			
		keyWordEngine = new KeyWordEngine();
		  keyWordEngine.startExecution("login");
	
	}
	
	
}
