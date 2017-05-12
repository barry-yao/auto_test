package com.kodak.selenium.icw.pages;

import org.openqa.selenium.WebDriver;

import com.kodak.selenium.icw.components.ToolbarStrip;
import com.kodak.selenium.icw.components.ToolbarStrip.Pages;
import com.kodak.selenium.ui.SimplePage;

public class ICWMainPageBase extends SimplePage {

	protected ToolbarStrip _toolbarStrip;

	public ICWMainPageBase(WebDriver wd) throws Exception {
		super(wd);
		
		this.taksScreenshot();
		// while(wd.findElements(By.className("fold")))
		_toolbarStrip = new ToolbarStrip(wd);
	}

	@Override
	protected void waitLoading() throws Exception{
		String clsName= "loading."+this.getClass().getSimpleName();
		this.waitElementDisappear(clsName);
	}


	public ToolbarStrip getToolbar() {
		return _toolbarStrip;
	}

	public MyTasks gotoMyTasks() throws Exception {
		this.getToolbar().gotoPage(Pages.pageBarMyTasks);
		return new MyTasks(this._webDriver);
	}
}
