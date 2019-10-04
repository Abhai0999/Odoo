package com.odoo.webutils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;

public class MyTestListener implements ITestListener,WebDriverEventListener
{
	public static Logger log;
	public static int executioncount,passcount,failcount,skipcount=0;
	long starttime,stoptime=0;


	public void onTestStart(ITestResult result) 
	{
		executioncount++;
		log.info(result.getName()+"script execution starts ");
		starttime=System.currentTimeMillis();
	}
	
	
	public void onTestSuccess(ITestResult result) 
	{
		passcount++;
		log.info(result.getName()+"script execution passed ");
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		failcount++;
		log.info(result.getName()+"script execution failed ");	
		TakesScreenshot ts=(TakesScreenshot)Driver.getdriver();
		
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File destfile=new File(GenericLib.dir+"/screenshots/"+result.getName()+sdf.format(new Date())+".png");
		
		try
		{
			Files.copy(srcfile, destfile);
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		skipcount++;
		log.info(result.getName()+"script execution skipped ");
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}
	
	
	public void onStart(ITestContext context) 
	{
		
		 SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		 System.setProperty("timestamp", sdf.format(new Date()));
		
		 System.setProperty("logpath", GenericLib.dir+"reports/logs");
		 System.setProperty("htmlpath", GenericLib.dir+"reports/HTML");
		
		 PropertyConfigurator.configure("log4j.properties");
	     log=Logger.getLogger("log4j.properties");
	     log.info("Framework execution done");
		
	     String filepath=GenericLib.getConfigFile();
	     String system=GenericLib.getValue(filepath, "system");
	     String browserName=GenericLib.getValue(filepath, "browserName");
	     String headless=GenericLib.getValue(filepath, "headless");
	     WebDriver driver= DriverFactory.launch(system, browserName, headless);
	     Driver.setdriver(driver);
	     log.info(" Browser launched and maximized ");
	     
	}
	public void onFinish(ITestContext context) 
	{
		Driver.getdriver().close();
		if (Driver.getdriver()!= null) 
		{
			Driver.getdriver().quit();
		}	
		log.info(" Browser Closed ");
		Workbook wb=new XSSFWorkbook();
		Sheet sh = wb.createSheet("Odoo Execution Report");
		Row rw = sh.createRow(0);
		rw.createCell(0).setCellValue("Scripts Execution");
		rw.createCell(1).setCellValue("Status");
		
		ExcelUtilities eu = new ExcelUtilities();
		
		eu.writeData(sh, 1, "Total Script Executed", executioncount);
		eu.writeData(sh, 1, "Total Script Passed", passcount);
		eu.writeData(sh, 1, "Total Script Failed", failcount);
		eu.writeData(sh, 1, "Total Script Skipped", skipcount);
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String filepath=GenericLib.dir+"/reports/excelreport/Report"+sdf.format(new Date()+".xlsx");
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(filepath));
			wb.write(fos);
			log.info(" Excelreport Generated ");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		stoptime=System.currentTimeMillis();
		double totalTime=(stoptime-starttime)/1000;
		log.info(" Framework execution time taken: "+totalTime+"seconds ");
		log.info(" Framework Execution Ends ");
	}
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onException(Throwable t, WebDriver driver) {
		log.fatal(t.getMessage());
		
	}
	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
}
 