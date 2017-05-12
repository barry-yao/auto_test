package com.kodak.selenium.ui;

import org.openqa.selenium.WebDriver;

public class SimplePage extends PageBase {

	public SimplePage(WebDriver wd) throws Exception {
		super(wd);
		this.waitLoading();
	}

}
