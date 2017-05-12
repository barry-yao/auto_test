package com.kodak.selenium.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class Checkbox extends SimpleControl {

	public Checkbox(SearchContext wd, String id) throws ObjectNotDefinedException, ObjectDefinitionError {
		super(wd, id);
		// TODO Auto-generated constructor stub
	}

	public void check(boolean value){
		 org.openqa.selenium.WebElement aElement;
	}
}
