package com.kodak.selenium.icw.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kodak.selenium.icw.pages.ICWInstance;
import com.kodak.selenium.icw.pages.ICWMainPageBase;
import com.kodak.selenium.icw.pages.Login;
import com.kodak.selenium.icw.pages.MyTasks;
import com.kodak.selenium.icw.pages.SmartReview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;

public class ICWTestBase {
	protected ChromeDriverService _service;
	protected String _chromeDriverPath = "D:\\SeleniumDrivers\\chromedriver.exe";
	protected Logger _logger;
	protected ICWInstance inst;
	protected ICWMainPageBase icwMain;
	protected String serviceName = "http://icw2k12qa2/";

	public ICWTestBase() {
		_logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		this._logger.info("Class...");
		inst = new ICWInstance();
		inst.initialize();
	}

	@AfterClass
	public void afterClass() throws Exception {
		inst.quit();
		inst.finalize();

		this._logger.info("Class Done...");
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		this._logger.info("Method before...");
	}

	@AfterMethod
	public void afterMethod() {
		this._logger.info("Method after...");

		//
	}

	// @Test
	public void test() throws Exception {

		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();

		sr.approve("Approve:");

	}

}
