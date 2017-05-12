package com.kodak.selenium.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class SimpleControl extends HtmlControl {

	public SimpleControl(SearchContext wd, String id) throws ObjectNotDefinedException, ObjectDefinitionError {
		super(wd, id);
		// TODO Auto-generated constructor stub
	}

	public SimpleControl(SearchContext wd, String id, String param)
			throws ObjectNotDefinedException, ObjectDefinitionError {
		super(wd, id, param);
		// TODO Auto-generated constructor stub
	}

	public SimpleControl(SearchContext wd, By by) throws Exception {
		super(wd, by);
		// TODO Auto-generated constructor stub
	}

}
