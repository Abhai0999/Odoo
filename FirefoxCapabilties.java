package com.odoo.webutils;


import org.openqa.selenium.firefox.FirefoxOptions;
import com.odoo.generic.GenericLib;

public class FirefoxCapabilties 
{
	public static FirefoxOptions getCapabilities(String headless)
	{
		String filepath = GenericLib.getConfigFile();
		
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability("PLATFORM_NAME", GenericLib.os);
		options.setCapability("APPLICATION_NAME", GenericLib.getValue(filepath, "application"));
		options.setHeadless(Boolean.parseBoolean(headless));
		
		
		return options;
	}
	

}
