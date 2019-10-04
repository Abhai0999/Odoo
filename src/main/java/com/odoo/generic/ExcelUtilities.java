 package com.odoo.generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{
String filepath;

public ExcelUtilities(String filepath) 
{
	this.filepath=filepath;	
}
public ExcelUtilities() 
{
	
}
public String[] readData(String sheetName,String testcaseID) throws EncryptedDocumentException, IOException	
{
	 String[] value=null;
	FileInputStream fis= new FileInputStream(new File(filepath));
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(sheetName);
	int rowcount= sh.getLastRowNum();
	for (int i = 0; i <=rowcount ; i++) 
	{
		 Row rw=sh.getRow(i);	
		if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) 
		{
			int cellcount = rw.getLastCellNum();
			value= new String[cellcount];
			for (int j = 0; j < cellcount ; j++) 
			{
				Cell cl=rw.getCell(j);
				switch (cl.getCellType()) 
				{
				
				case STRING:
					value[j]=cl.getStringCellValue();
					
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cl)) 
					{
						SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
						value[j]=sdf.format(cl.getDateCellValue());
					}
					else
					{
						long longval=(long) cl.getNumericCellValue();
						value[j]=Long.toString(longval);		
					}
					break;
					
				case BOOLEAN:
					value[j]=Boolean.toString(cl.getBooleanCellValue());
					break;
					
				default:
					break;
				}
			}  //end cell loop
			break;
		}//end if	
	}//end of row loop
	return value;	
}

public void writeData(Sheet sh,int row,String title,int data)
{
	sh.createRow(row).createCell(0).setCellValue(title);
	sh.createRow(row).createCell(1).setCellValue(data);
}
}
