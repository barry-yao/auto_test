package com.kodak.selenium.icw.components;

import org.openqa.selenium.WebDriver;

import com.kodak.selenium.icw.enums.SRFileStatus;
import com.kodak.selenium.ui.NamedContainer;

public class SRFileItem extends NamedContainer {

	public SRFileItem(WebDriver wd, String fileName) throws Exception {
		super(wd, "fileItemWithName", fileName);
		// TODO Auto-generated constructor stub
	}

	public void click() {

	}
	
	public SRFileStatus getStaus() throws Exception{
		String cls =this.getHtmlControl("statusIcon").getClassName();
		return SRFileStatus.parse(cls);
	}

}
