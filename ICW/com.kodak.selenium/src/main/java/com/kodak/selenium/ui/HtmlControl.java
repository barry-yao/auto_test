package com.kodak.selenium.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodak.selenium.helper.ScreenshotHelper;
import com.kodak.selenium.helper.TestSetting;
import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class HtmlControl implements SearchContext, WrapsDriver {

	protected SearchContext _searchContext;
	protected By _by;

	protected Logger _logger = Logger.getLogger(this.getClass().getSimpleName());

	protected HtmlControlDefinition _definition;
	public HtmlControlDefinition getDefinition(){
		return _definition;
	}
	private Actions _actions = null;

	protected WebDriver _webDriver;
	public WebDriver getWebDriver(){
		return _webDriver;
	}

	private HtmlControl(SearchContext wd) {
		this._searchContext = wd;
		if (this._searchContext instanceof WebDriver)
			_webDriver = (WebDriver) this._searchContext;
		else if (this._searchContext instanceof WrapsDriver) {
			_webDriver = ((WrapsDriver) this._searchContext).getWrappedDriver();
		}
		else{			
			_logger.error("Unknown type SearchContext:"+wd.getClass().getName());
		}
		if (_webDriver != null)
			_actions = new Actions(_webDriver);
	}

	protected HtmlControl(SearchContext wd, String id) throws ObjectNotDefinedException, ObjectDefinitionError {
		this(wd);
		_definition = ObjectRepository.getDefinition(id);
		_by = _definition.getBy();
	}

	protected HtmlControl(SearchContext wd, String id, String param)
			throws ObjectNotDefinedException, ObjectDefinitionError {
		this(wd);
		_definition = ObjectRepository.getDefinition(id).setParam(param);
		_by = _definition.getBy();
	}

	public HtmlControl(SearchContext wd, By by) throws Exception {
		this(wd);
		this._by = by;
	}



	public WebElement getWebElement() {
		return  this._searchContext.findElement(_by) ;
	}

	/*
	 * Actions
	 */
	protected Actions getAction() {

		if (_actions == null) {
			WebDriver wDriver = null;
			if (this._searchContext instanceof WebDriver)
				wDriver = (WebDriver) this._searchContext;
			else if (this._searchContext instanceof WrapsDriver) {
				wDriver = ((WrapsDriver) this._searchContext).getWrappedDriver();
			} else {
				return null;
			}
			_actions = new Actions(wDriver);
		}
		return _actions;
	};

	public HtmlControl click() throws ObjectDefinitionError {
		this.waitTillVisible();
		this.getWebElement().click();
		return this;
	}

	public HtmlControl doubleClick() throws ObjectDefinitionError {
		this.waitTillVisible();
		this.getAction().doubleClick(this.getWebElement()).perform();
		return this;
	}

	/*
	 * Get properties
	 * 
	 */

	public String getClassName() throws ObjectDefinitionError {
		return this.getWebElement().getAttribute("class");
	}

	public String getAttr(String name) throws ObjectDefinitionError {
		return this.getWebElement().getAttribute(name);
	}

	public String getText() throws ObjectDefinitionError {
		return this.getWebElement().getText();
	}

	/*
	 * Wait functions
	 */
	public HtmlControl waitTillVisible() {
		new WebDriverWait(this._webDriver, TestSetting.DFT_TIMEOUT)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(_by));
		return this;
	}

	public HtmlControl waitTillInvisible() {
		new WebDriverWait(this._webDriver, TestSetting.DFT_TIMEOUT)
				.until(ExpectedConditions.invisibilityOfElementLocated(_by));
		return this;
	}

	public HtmlControl waitTillPresence() {
		new WebDriverWait(this._webDriver, TestSetting.DFT_TIMEOUT)
				.until(ExpectedConditions.presenceOfElementLocated(_by));
		return this;
	}

	@Override
	public String toString() {
		WebElement we = this.getWebElement();
		StringBuilder sb = new StringBuilder();
		sb.append("\tTagName:" + we.getTagName());
		sb.append(System.lineSeparator());

		sb.append("\tSize:" + we.getSize().toString());
		sb.append(System.lineSeparator());

		sb.append("\tLocation:" + we.getLocation().toString());
		sb.append(System.lineSeparator());
		return sb.toString();
		
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return this.getWebElement().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return this.getWebElement().findElement(by);
	}

	@Override
	public WebDriver getWrappedDriver() {
		// TODO Auto-generated method stub
		return ((WrapsDriver)this.getWebElement()).getWrappedDriver();
	}
	
	public void takeScreenshot(String name){
		ScreenshotHelper.taksScreenshot(getWrappedDriver(), name);
	}

}
