package com.odoo.webutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.odoo.generic.GenericLib;

public class Browserfactory 
{
public static WebDriver launchBrowser(String browserName,String headless)
{
	WebDriver driver= null;
	String filepath=GenericLib.getConfigFile();
	if (GenericLib.os.contains("Windows"))
	  {
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "chrome_windows"));
			driver=new ChromeDriver(ChromeCapabilities.getCapabilities(headless));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		     {
			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "firefox_windows"));
			driver=new FirefoxDriver(FirefoxCapabilities.getCapabilities(headless));
		     }
	       }
	else if (GenericLib.os.contains("mac"))
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "chrome_mac"));
			driver=new ChromeDriver(ChromeCapabilities.getCapabilities(headless));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		     {
			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "firefox_mac"));
			driver=new FirefoxDriver(FirefoxCapabilities.getCapabilities(headless));
		     }
       }
	     else if (GenericLib.os.contains("linux")||GenericLib.os.contains("ubuntu"))
	           {
       if (browserName.equalsIgnoreCase("chrome")) 
         {
    	   if (browserName.equalsIgnoreCase("chrome")) 
   		{
   			
   			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "chrome_linux"));
   			driver=new ChromeDriver(ChromeCapabilities.getCapabilities(headless));
   		}
   		else if(browserName.equalsIgnoreCase("firefox"))
   		     {
   			System.setProperty("Webdriver.chrome.driver", GenericLib.getValue(filepath, "firefox_linux"));
   			driver=new FirefoxDriver(FirefoxCapabilities.getCapabilities(headless));
   		     }
		}
     
	}
	return driver;
}
}
