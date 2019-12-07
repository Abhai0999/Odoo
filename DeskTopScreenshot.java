package com.odoo.webutils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class DeskTopScreenshot 
{
public static void main(String[] args) throws AWTException 
{
	Robot rob= new Robot();
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rt= new Rectangle(screensize);
	BufferedImage photo = rob.createScreenCapture(rt);
	
	try 
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String timedateformat = sdf.format(new Date());
		ImageIO.write(photo, "png", new File("./DesktopImage/desktopImage"+timedateformat+".png"));
	} 
	catch (IOException e) 
	{
	e.printStackTrace();
	}	
}
}
