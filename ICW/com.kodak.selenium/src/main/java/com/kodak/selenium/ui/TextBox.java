package com.kodak.selenium.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TextBox extends SimpleControl {

	public TextBox(String id, SearchContext wd) throws Exception {
		super(wd, id);
		JavascriptExecutor aExecutor;

	}

	/*
	 * @input text for textbox
	 */
	public void input(String text) {
		if (getWebElement().getText().equalsIgnoreCase(text)) {
			return;
		}

		if (text == null || text == "") {
			getWebElement().clear();
			return;
		}
		getWebElement().clear();
		getWebElement().sendKeys(text);
	}
}
