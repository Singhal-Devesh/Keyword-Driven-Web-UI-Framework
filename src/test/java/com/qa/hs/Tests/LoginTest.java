package com.qa.hs.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class LoginTest {
	
     public KeyWordEngine keyWordEngine;
	
		
		@Test
		public void loginTest() throws IllegalStateException, Exception, IOException {
			
		keyWordEngine = new KeyWordEngine();
		
		
		
				keyWordEngine.startExecution("Login_Page");
		
			}
		
		}
	

		
		

	
	
