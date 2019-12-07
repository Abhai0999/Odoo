package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;
import com.odoo.generic.GenericLib;

public class ChromeCapabilties 
{
	public static ChromeOptions getCapabilities(String headless)
	{
		String filepath=GenericLib.getConfigFile();
		
		ChromeOptions options=new ChromeOptions();
		options.setCapability("PLATFORM_NAME", GenericLib.os);
		options.setCapability("APPLICATION_NAME", GenericLib.getValue(filepath, "application"));
		options.setHeadless(Boolean.parseBoolean(headless));
		options.addArguments("--disable-notifications");
		
		return options;
	}
	
	

}
