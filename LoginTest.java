package com.odoo.scripts;
import org.testng.annotations.Test;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginTest extends BaseAbstractTest
{
	@Test(priority=1)
	@Story("Invalid login without password")
	@Step("Enter valid Username [0], Enter no password[1]")
	@Severity(SeverityLevel.BLOCKER)
	@Description("To test the functionality of login Feature with correct details.")
	@Link("https://xpathy-infotech-pvt-ltd.odoo.com/web/login")
	
	public void validLoginTest()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "validLogin_ID");
		lf.login(data[1], data[2]);
		lf.verifyValidLogin(data[1]);
	}
	

	  @Test(priority=2) 
	  @Story("Invalid login without password")
	  @Step("Enter valid Username [0], Enter no password[1]")
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("To test the functionality of login Feature with incorrect details.")
	  @Link("https://xpathy-infotech-pvt-ltd.odoo.com/web/login")
	  
	  public void InvalidLoginTest() 
	  { 
	  String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx"; 
	  ExcelUtilities eu=new ExcelUtilities(filepath); 
	  String[] data = eu.readData("Sheet1","InvalidLogin_ID");
	  lf.login(data[1], data[2]);
	  lf.verifyInValidLogin(data[3]);
	  }
	 
}
