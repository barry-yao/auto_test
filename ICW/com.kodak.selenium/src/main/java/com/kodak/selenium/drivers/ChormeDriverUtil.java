package com.kodak.selenium.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChormeDriverUtil extends WebDriverUtil {
	protected ChromeDriverService _service;
	private String _chromeDriver;

	public ChormeDriverUtil() {
		super();
	}

	public ChormeDriverUtil(String driver) {
		this();		
		_chromeDriver = driver;
		System.setProperty("webdriver.chrome.driver", driver);
	}

	@Override
	public void initialize() throws IOException {
		if (_service == null) {
			_service = new ChromeDriverService.Builder().usingDriverExecutable(new File(_chromeDriver))
					.usingAnyFreePort().build();
		}
		_service.start();
	}

	@Override
	public void finalize() {
		_service.stop();
	}

	@Override
	public WebDriver launch() {
		return new ChromeDriver();
	}

}
