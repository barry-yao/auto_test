package com.kodak.selenium.ui;

import org.openqa.selenium.SearchContext;

public class Canvas extends SimpleControl {

	public Canvas(String id, SearchContext wd) throws Exception {
		super(wd, id);
	}

	public Canvas(String fmtId, SearchContext wd, String fmtValue) throws Exception {
		super(wd, fmtId, fmtValue);
	}

	public void click(int x, int y) {
		this.getAction().moveToElement(getWebElement(), x, y).click().perform();

	}

	public void draw(int x, int y, int width, int height) {
		this.getAction().moveToElement(getWebElement(), x, y).dragAndDropBy(getWebElement(), width, height).perform();
	}

}
