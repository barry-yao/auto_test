package com.kodak.selenium.icw.pages;

import org.openqa.selenium.WebDriver;

import com.kodak.selenium.ui.PageBase;

public class Login extends PageBase {
	protected Login(WebDriver wd) {
		super(wd);
	}

	public ICWMainPageBase login(String userName, String password) throws Exception {
		return this.login(userName, password, null);
	}

	public ICWMainPageBase login(String userName, String password, String lang) throws Exception {
		getTextBox("username").input(userName);
		getTextBox("password").input(password);

		if (lang != null) {

		}

		this.click("login");

		return new FolderView(this._webDriver);

	}

}
