package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericLib 
{
public static String dir=System.getProperty("user.dir");
public static String os=System.getProperty("os.name");
public static String getValue(String filepath,String key)  
      {
	String value= null;	
	try 
	{
		Properties prop= new Properties();
		prop.load(new FileInputStream(new File(filepath)));
		value=prop.getProperty(key);	
	} 
	catch (IOException e) 
	{
		
	}
	return value;
}
public static String getConfigFile()
{
	
String filepath=null;

if (GenericLib.os.contains("Windows")) 
{
	filepath=GenericLib.dir+"\\config.properties";
} 

else if(GenericLib.os.contains("mac"))
{
	filepath=GenericLib.dir+"/config.properties";
}
else if(GenericLib.os.contains("linux") || GenericLib.os.contains("ubuntu"))
{
	filepath=GenericLib.dir+"/config.properties";
}




return filepath;


}
}
