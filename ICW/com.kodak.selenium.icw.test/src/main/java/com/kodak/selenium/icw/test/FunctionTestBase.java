package com.kodak.selenium.icw.test;

import org.testng.annotations.BeforeClass;

import com.kodak.selenium.icw.pages.ICWInstance;
import com.kodak.selenium.icw.pages.Login;

public class FunctionTestBase extends ICWTestBase {

	public FunctionTestBase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void beforeClass() throws Exception {
		super.beforeClass();
		Login l = inst.launch(serviceName);
		this.icwMain=l.login("Administrator", "Kodak");
	}

}
