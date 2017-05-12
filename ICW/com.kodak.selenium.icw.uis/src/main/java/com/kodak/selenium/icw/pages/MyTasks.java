package com.kodak.selenium.icw.pages;

import org.openqa.selenium.WebDriver;

import com.kodak.selenium.helper.JavaScriptHelper;
import com.kodak.selenium.ui.HtmlControl;

public class MyTasks extends ICWMainPageBase {

	public MyTasks(WebDriver wd) throws Exception {
		super(wd);
		// TODO Auto-generated constructor stub

	}

	public SmartReview openSR(String taskName) throws Exception {

		// this.getHtmlControl("myTask.row",taskName).executeJS("ondblclick");\
		HtmlControl row = this.getHtmlControl("myTask.row", taskName);
		// this.getHtmlControl("myTask.thumbnail",taskName).doubleClick();
		return new SmartReview(this._webDriver, () -> row.doubleClick());

	}

	public SmartReview openSR() throws Exception {

		HtmlControl row = this.getHtmlControl("myTask.tasks");

		return new SmartReview(this._webDriver, () -> row.doubleClick());
	}

	/*
	 * For Browser other than Chrome. as doble click does not works.
	 */
	public SmartReview openSRByJavascript() throws Exception {
		HtmlControl row = this.getHtmlControl("myTask.tasks");
		JavaScriptHelper jsHelper = new JavaScriptHelper(_webDriver);

		return new SmartReview(this._webDriver, () -> jsHelper.doubleClick(row));

	}

}
