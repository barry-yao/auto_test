package com.kodak.selenium.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class NamedContainer extends ContainerBase {

	protected HtmlControl _self;
//	protected WebDriver getWebDriver(){
//		return _self.getwebd
//	}
	

	protected SearchContext getSelfContext() {
		return _self;
	}

	public HtmlControl getSelf() {
		return _self;
	}

	public NamedContainer(SearchContext wd, String id) throws Exception {
		super(wd);
		_self = new HtmlControl(wd, id);
		_selfContext = _self;

	}

	public NamedContainer(SearchContext wd, By by) throws Exception {
		super(wd);
		// TODO Auto-generated constructor stub
		_self = new HtmlControl(wd, by);
		_selfContext = _self;
	}

	public NamedContainer(SearchContext wd, String id, String name) throws Exception {
		super(wd);

		// TODO Auto-generated constructor stub
		_self = new HtmlControl(wd, id, name);
		_selfContext = _self;
	}

}
