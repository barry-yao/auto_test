package com.kodak.selenium.icw.pages;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.kodak.selenium.drivers.ChormeDriverUtil;
import com.kodak.selenium.drivers.WebDriverUtil;
import com.kodak.selenium.helper.ScreenshotHelper;
import com.kodak.selenium.ui.ObjectRepository;

public class ICWInstance {

	protected WebDriver webDriver;
	protected Logger _logger = Logger.getLogger(this.getClass().getSimpleName());
	private static String repoFile = "ICWSiteRepository.xml";
	private WebDriverUtil _wdUtil;
	static {
		try {
			ClassLoader classLoader = ICWInstance.class.getClassLoader();
			URL url = classLoader.getResource(repoFile);
			ObjectRepository.init(url.getFile());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	private static final String chromeDriver = "D:\\SeleniumDrivers\\chromedriver.exe";

	public ICWInstance() {

		_wdUtil = new ChormeDriverUtil(chromeDriver);
	}

	public Login launch(String icwService) {
		webDriver = _wdUtil.launch();
		webDriver.manage().window().maximize();
		// webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(icwService);
		return new Login(this.webDriver);
	}

	public void quit() {

		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	public void initialize() throws Exception {
		_wdUtil.initialize();
	}

	public void finalize() {
		_wdUtil.finalize();
	}

	public void taksScreenshot() {
		ScreenshotHelper.taksScreenshot(webDriver);
	}
}
