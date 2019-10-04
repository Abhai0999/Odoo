package com.odoo.generic;

import org.openqa.selenium.WebDriver;

public class Driver 
{
  private static WebDriver wdriver;
  
  public static WebDriver getdriver()
  {
	  
	  return wdriver;
  }
  public static void setdriver(WebDriver driver)
  {
	  
	   wdriver=driver;
  }

	
	
}
