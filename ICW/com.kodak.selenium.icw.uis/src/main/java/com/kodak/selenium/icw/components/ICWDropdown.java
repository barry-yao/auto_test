package com.kodak.selenium.icw.components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.HtmlControl;

public class ICWDropdown extends HtmlControl {
	protected HtmlControl dataContent = null;

	public ICWDropdown(SearchContext wd, String id) throws Exception {
		super(wd, id);
		String css = this._definition.attribute("dataContentCss");
		if (css == null)
			css = this.getAttr("data-dropdown");
		if (css != null)
			
			dataContent = new HtmlControl(this.getWebDriver(), By.cssSelector(css));
	}

	protected void open() throws Exception {
		this.click();
		if (dataContent == null) {
			String css = this.getAttr("data-dropdown");
			if (css == null) {
				throw new Exception("Dropdown list does not defined.");
			}
			dataContent = new HtmlControl(this.getWebDriver(), By.cssSelector(css));
		}
		dataContent.waitTillVisible();

	}

	public void select(String value) throws Exception {
		this.open();
		String xpath = String.format("//*[text()='%s']", value);
		dataContent.findElement(By.xpath(xpath)).click();
	}

	public String current() throws ObjectDefinitionError {
		return this.getText();
	}

	protected WebElement findItem(String css) {
		By by = css.startsWith("/") ? By.xpath(css) : By.cssSelector(css);
		return this.dataContent.getWebElement().findElement(by);
	}
}
