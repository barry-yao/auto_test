package com.kodak.selenium.test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestStudy {
	@Test
	public void f() throws MalformedURLException {

		Logger _logger = Logger.getLogger(this.getClass().getSimpleName());

		URL r = new URL("http://www.kodak.com/index.asp?a=b&c=d");
		
		_logger.info(r.getFile());
		


	}
}
