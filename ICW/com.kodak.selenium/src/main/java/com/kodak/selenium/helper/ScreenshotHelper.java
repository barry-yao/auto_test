package com.kodak.selenium.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotHelper {
	private static final Logger _logger = Logger.getLogger(ScreenshotHelper.class.getSimpleName());

	public ScreenshotHelper() {
		// TODO Auto-generated constructor stub
	}

	public static void taksScreenshot(TakesScreenshot wd) {
		taksScreenshot(wd, null);
	}

	public static void taksScreenshot(WebDriver wd){
		taksScreenshot((TakesScreenshot)wd, null);
	}
	
	public static void taksScreenshot(WebDriver wd, String fileName){
		taksScreenshot((TakesScreenshot)wd, fileName);
	}
	
	public static void taksScreenshot(WebElement wd, String fileName){
		taksScreenshot((TakesScreenshot)wd, fileName);
	}
	
	public static void taksScreenshot(TakesScreenshot wd, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) wd;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		String newFile = "d:\\screenshot\\" + (fileName == null ? scrFile.getName() : fileName + ".png");
		try {
			FileUtils.copyFile(scrFile, new File(newFile));
		} catch (IOException ex) {
			_logger.error("create screenshot fail:" + newFile, ex);
		}
		_logger.info(newFile);
	}

}
