package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;

import com.odoo.generic.GenericLib;

public class ChromeCapabilities 
{
public static ChromeOptions getCapabilities(String headless)
{
	
	String filepath=GenericLib.getConfigFile();
	
		/*
		 * if(GenericLib.os.contains("Windows")) 
		 * { filepath=GenericLib.dir+
		 * "\\config.properties"; } else if (GenericLib.os.contains("Mac")) {
		 * filepath=GenericLib.dir+ "/config.properties"; } else if
		 * (GenericLib.os.contains("linux")|| GenericLib.os.contains("ubuntu")) {
		 * filepath=GenericLib.dir+ "/config.properties"; }
		 */
	ChromeOptions options= new ChromeOptions();
	options.setCapability("PLATFORM_NAME", "GenericLib.os");
	options.setCapability("APPLICATION_NAME", GenericLib.getValue(filepath,"application"));
	options.setHeadless(Boolean.parseBoolean(headless));
	
	return options;
}
}
