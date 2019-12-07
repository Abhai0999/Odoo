package com.odoo.webutils;

import org.openqa.selenium.WebDriver;

public class DriverFactory 
{
	public static WebDriver launch(String system, String browserName, String headless)
	{
		WebDriver driver=null;
		
		if (system.equalsIgnoreCase("local")) 
		{
			driver=BrowserFactory.launchBrowser(browserName, headless);
		}
		else if(system.equalsIgnoreCase("remote"))
		{
			//selenium Grid
		}
		
		return driver;
	}
	
}
