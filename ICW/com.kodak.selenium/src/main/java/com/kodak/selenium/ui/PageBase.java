package com.kodak.selenium.ui;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodak.selenium.helper.ScreenshotHelper;

public class PageBase extends ContainerBase {
	protected WebDriver _webDriver;
	
	public PageBase(WebDriver wd) {
		super(wd);
		_webDriver =wd;
	}

	protected void waitLoading() throws Exception{

	}

	public String getTitle() {
		return this._webDriver.getTitle();
	}

	public String getFileName() {
		String url = _webDriver.getCurrentUrl();
		int questionPos = url.indexOf("?");
		if (questionPos > -1) {
			url = url.substring(0, questionPos);
		}

		int start = url.lastIndexOf("/");
		int end = url.lastIndexOf(".");
		return url.substring(start + 1, end);
	}

	protected void changeLocation(SimpleMethod action) throws Exception {
		String titlePre = this.getTitle();
		action.action();
		while (this.getTitle().equalsIgnoreCase(titlePre)) {
			Thread.sleep(500);
		}

		this._logger.info(String.format("%s::%s\r\n", titlePre, this.getTitle()));
	}

	public void logState() {
		JavascriptExecutor a = ((JavascriptExecutor) this._selfContext);
		Object obj = a.executeScript("return document.readyState");
		this._logger.info(String.format("readyState:%s", obj));
	}

	public void taksScreenshot() {
		taksScreenshot(null);
	}

	public void taksScreenshot(String fileName) {
		ScreenshotHelper.taksScreenshot(this._webDriver, fileName);
	}
}
