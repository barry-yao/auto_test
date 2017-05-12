package com.kodak.selenium.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class ControlList extends HtmlControl {

	public ControlList(SearchContext wd, String id) throws ObjectNotDefinedException, ObjectDefinitionError {
		super(wd, id);
		// TODO Auto-generated constructor stub
	}

	public ControlList(SearchContext wd, String id, String param)
			throws ObjectNotDefinedException, ObjectDefinitionError {
		super(wd, id, param);
		// TODO Auto-generated constructor stub
	}

	public ControlList(SearchContext wd, By by) throws Exception {
		super(wd, by);
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getTexts(){
		List<String> texts = new ArrayList<String>();
		for(WebElement we: this._searchContext.findElements(this._by)){
			texts.add(we.getText());
		}
		return texts;
	}
	
	public List<WebElement> getControls(){
		List<WebElement> texts = new ArrayList<WebElement>();
		for(WebElement we: this._searchContext.findElements(this._by)){
			texts.add(we);
		}
		return texts;
	}
	
	public int count(){
		return this._searchContext.findElements(_by).size();
	}

}
