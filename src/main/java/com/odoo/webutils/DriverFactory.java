package com.odoo.webutils;

import org.openqa.selenium.WebDriver;

public class DriverFactory 
{
	 
	
    public static WebDriver launch(String system,String browserName,String Headless)
   {
    	
    	WebDriver driver=null;
    	
	if (system.equalsIgnoreCase("local")) 
	{
		driver=Browserfactory.launchBrowser(browserName, Headless);
	} 
	else if (system.equalsIgnoreCase("remote")) 
	{
		driver=Browserfactory.launchBrowser(browserName, Headless);
	}
	return driver;

}
}
