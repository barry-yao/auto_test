package com.kodak.selenium.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class ContainerBase {

	protected SearchContext _selfContext;
	protected Logger _logger = Logger.getLogger(this.getClass().getSimpleName());

	protected ContainerBase(SearchContext wd) {
		_selfContext = wd;
	}

	protected TextBox getTextBox(String id) throws Exception {
		return new TextBox(id, _selfContext);
	}

	protected Img getImg(String id) throws Exception{
		return new Img(id, _selfContext);
	}
	protected HtmlControl getHtmlControl(String id) throws Exception {
		return new HtmlControl(_selfContext, id);
	}

	protected HtmlControl getHtmlControl(By by) throws Exception {
		return new HtmlControl(_selfContext, by);
	}

	protected HtmlControl getHtmlControl(String fmtId, String fmtValue) throws Exception {
		return new HtmlControl(_selfContext, fmtId, fmtValue);
	}

	public ContainerBase click(String id) throws Exception {
		this.getHtmlControl(id).click();
		return this;
	}

	public ContainerBase click(String fmtId, String value) throws Exception {
		this.getHtmlControl(fmtId, value).click();
		return this;
	}

	protected Canvas getCanvas(String id) throws Exception {
		return new Canvas(id, this._selfContext);
	}

	protected ContainerBase input(String id, String text) throws Exception {
		this.getTextBox(id).input(text);
		return this;
	}
	
	protected void check(String id,boolean value) throws Exception{
		HtmlControl hc= this.getHtmlControl(id);

	}

	protected String getText(String id) throws Exception {
		return this.getHtmlControl(id).getText();
	}
	
	protected List<String> getElementsText(String id) throws ObjectNotDefinedException, ObjectDefinitionError{
		return new ControlList(_selfContext, id).getTexts();
	}

	/*
	 * Wait...
	 */
	protected ContainerBase waitElementDisappear(String id) throws Exception {
		this.getHtmlControl(id).waitTillInvisible();
		return this;
	}

	protected ContainerBase waitElementAppear(String id) throws Exception {
		this.getHtmlControl(id).waitTillPresence().waitTillVisible();
		return this;
	}
	
	

}
