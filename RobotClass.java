package com.odoo.webutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass 
{
	public static void fileupload(String filepath) throws AWTException
	{
Robot rob= new Robot();
StringSelection sel= new StringSelection(filepath);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
rob.setAutoDelay(3000);
rob.keyPress(KeyEvent.VK_CONTROL);
rob.keyPress(KeyEvent.VK_V);

rob.keyRelease(KeyEvent.VK_CONTROL);
rob.keyRelease(KeyEvent.VK_V);

rob.keyPress(KeyEvent.VK_ENTER);
rob.keyRelease(KeyEvent.VK_ENTER);
}
}