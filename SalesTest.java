package com.odoo.scripts;

import java.util.Random;
import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


public class SalesTest extends BaseAbstractTest
{
	
	  Random rm= new Random(); 
	  int randomNo =rm.nextInt(100);
	  
	   @Test (enabled=false)
	 // @Test(priority=1) 
	  @Story("Creating customer in Sales Module")
	  @Owner("Abhishek Bharty")
	  @Step("Login[0],Click on sales[1],click on customers[2],click on create[3],Edit the fields[4],click on save[5]")
	  public void createCustomer() 
	  {    
	  String name; 
//*************************************************************************
	  String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx"; 
	  ExcelUtilities eu=new ExcelUtilities(filepath); 
	  String[] data = eu.readData("Sheet1","CreateCustomer_ID"); 
	  name=data[3].concat(Integer.toString(randomNo));
	  lf.login(data[1], data[2]); 
	  custf.CreateCustomer(name, data[4], data[5], data[6], data[7], data[8], data[9], data[10]);
	  custf.VerifyCreateCustomer(name);
	  eu.SetCellValue("Sheet1", 5, 3, name);
	  eu.SetCellValue("Sheet1", 6, 3, name);
	  eu.SetCellValue("Sheet1", 7, 3, name);
	  eu.SetCellValue("Sheet1", 9, 3, name);
	  }
	   
	   //@Test(priority=3) 
	  @Test (enabled=false) 
	  @Owner("Abhishek Bharty")
	  @Story("Creating customer in Sales Module Using Import Feature")
	  @Step("Login[0],Click on sales[1],click on customers[2],click on Import[3],Upload files[4],click on test Import[5],click on Import[6]")
	  public void createCustomerImport()
	  { 
	  String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx"; 
	  ExcelUtilities eu=new ExcelUtilities(filepath); 
	  String[] data = eu.readData("Sheet1","createCustomerImport_ID"); 
	  lf.login(data[1], data[2]);
	  custf.CreateCustomerImportFeature(data[4],data[5]);
	  custf.VerifyCustomerImportFeature(data[3]);
	  }
	  
      @Test (enabled=false)
      //@Test(priority=2)
	  @Owner("Abhishek Bharty")
	  @Story("Editing an Existing Customer in Sales Module Using Edit Feature")
      public void editCustomer()
       {
 	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
 	ExcelUtilities eu=new ExcelUtilities(filepath);
 	String[] data = eu.readData("Sheet1", "EditCustomer_ID");
 	lf.login(data[1], data[2]);
 	custf.EditCustomer(data[3],data[5], data[4]);
 	custf.ValidateEditCustomer(data[4]);
       }
	  
      //@Test(priority=4)
      @Test(enabled=false)
      @Owner("Abhishek Bharty")
      @Story("Creating Duplicate customer in Sales Module Using Duplicate Feature")
     // @Test(dependsOnMethods = "editCustomer")   
      
      public void CreateDuplicateCustomer()
      {	  
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] data = eu.readData("Sheet1", "EditCustomer_ID");
	lf.login(data[1], data[2]);
	custf.CreateDuplicateCustomer(data[3]);
	String name=data[3].concat("(copy)");
	custf.validateDuplicateCustomer(name);
      }   
    
      //@Test(priority=5)
       @Test(enabled=false)
       @Owner("Abhishek Bharty")
       @Story("Deleting Duplicate customer in Sales Module Using Delete Feature")
      // @Test(dependsOnMethods = "CreateDuplicateCustomer")
      public void DeleteDuplicateCustomer()
      { 	  
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] data = eu.readData("Sheet1", "DeleteDuplicateCustomer_ID");
	lf.login(data[1], data[2]);
	String name=data[3].concat(" (copy)");
	custf.DeleteDuplicateCustomer(name);
	custf.validateDeleteDuplicateCustomer(name);
      }
        
       //@Test(priority=7)
         @Owner("Abhishek Bharty")
         @Story("Deleting ALL customer in Sales-Customer Module Using Delete Feature on Action Dropdown")
         @Step("Login[0],Click on sales[1],click on customers[2],click on HamburgerIcon[3],Select all customers[5],click on ActionDropdown[4],click on Delete[6],Click on OK[7]")
         @Test(enabled=false)
       //@Test(dependsOnMethods = "createCustomer")     
      public void DeleteAllCustomer()
      {	  
	       String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	       ExcelUtilities eu=new ExcelUtilities(filepath);
	       String[] data = eu.readData("Sheet1", "DeleteAllCustomer_ID");
	       lf.login(data[1], data[2]);
	       custf.DeleteAllCustomer();
      }
          
           @Test(enabled=false)
        // @Test(dependsOnMethods = "createCustomer")
         public void CreatePipeline()
         {
        	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
        	 ExcelUtilities eu=new ExcelUtilities(filepath); 
        	 String[] data = eu.readData("Sheet1", "CreatePipeline_ID");
        	 String opportunity	= Integer.toString(randomNo).concat("-"+data[4]);
        	 lf.login(data[1], data[2]);
        	 pff.CreatePipeline(opportunity, data[3] , data[5]);
         }
           
           @Test(enabled=false)
        // @Test(dependsOnMethods = "CreatePipeline")
         public void ShiftPipeline()
         { 
        	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
        	 ExcelUtilities eu=new ExcelUtilities(filepath); 
        	 String[] data = eu.readData("Sheet1", "CreatePipeline_ID");
        	 String opportunity = Integer.toString(randomNo).concat("-"+data[4]);
        	 lf.login(data[1], data[2]);
        	 pff.DragandDrop(opportunity); 
         }
           
           @Test(enabled=false)
        // @Test(dependsOnMethods = "DeleteAllCustomer")
         public void DeleteAllOpportunities()
         {	  
   	         String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
   	         ExcelUtilities eu=new ExcelUtilities(filepath);
   	         String[] data = eu.readData("Sheet1", "DeleteAllOpportunity_ID");
   	         lf.login(data[1], data[2]);
   	         pff.DeleteAllOpportunity();
         }
           
           @Test
       //  @Test(priority=8)
         public void CreateSalesTeam()
         {
        	   String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
         	   ExcelUtilities eu=new ExcelUtilities(filepath);
         	   String[] data = eu.readData("Sheet1", "CreateSalesTeam_ID");
         	   lf.login(data[1], data[2]);
         	   String TlName=data[4].concat(Integer.toString(randomNo));
         	   String[] TLMail = data[5].split("@");
         	   String name = TLMail[0].concat(Integer.toString(randomNo)); 
         	   String[] Asignee = data[7].split("@");
         	   String AsigneeEmail = Asignee[0].concat(Integer.toString(randomNo)+"_2@").concat(Asignee[1]);
         	   stf.CreateSalesTeam(data[3].concat(Integer.toString(randomNo)),TlName,name.concat("@"+TLMail[1]),data[6].concat(Integer.toString(randomNo)),AsigneeEmail); 
         }
}
