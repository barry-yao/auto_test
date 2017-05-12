package com.kodak.selenium.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.kodak.selenium.ui.HtmlControl;


public class JavaScriptHelper {

	private JavascriptExecutor javascriptExecutor;

	private static final String dlbClickJS = "var event =  new MouseEvent('dblclick', { cancelable: true,}); "
			+ "arguments[0].dispatchEvent(event);";

	private static final String dlbClickJS4IE = "var event =  new MouseEvent('dblclick', { cancelable: true,}); "
			+ "arguments[0].fireEvent(event);";

	public JavaScriptHelper(WebDriver wDriver) {
		javascriptExecutor = (JavascriptExecutor) wDriver;
	}

	public void doubleClick(WebElement webElement) {
		javascriptExecutor.executeScript((javascriptExecutor instanceof InternetExplorerDriver) ? dlbClickJS4IE : dlbClickJS,
				webElement);
	}

	public void doubleClick(HtmlControl htmlControl) {
		doubleClick(htmlControl.getWebElement());
	}

}
