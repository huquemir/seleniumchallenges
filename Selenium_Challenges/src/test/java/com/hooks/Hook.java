package com.hooks;


import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass{
	@Before
	public static void Initialize() {
		BaseClass.setUp();
		
	}
	
	
	@After
	public static void tearDown() {
		driver.quit();
	}
	

}
