package com.odoo.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public class BaseAbstratTest 
{
	public static EventFiringWebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		
		
	}
	
	@BeforeMethod
	public void precondition()
	{
		MyTestListener listener= new MyTestListener();
		driver= new EventFiringWebDriver(Driver.getdriver());
		driver.register(listener);
		driver.get(GenericLib.getValue(GenericLib.getConfigFile(), "url"));	
	}
	
	@AfterMethod
	public void postcondition()
	{
		
		
	}

}
