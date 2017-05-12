package com.kodak.selenium.ui;

import org.openqa.selenium.SearchContext;

public class Img extends SimpleControl {

	public Img(String id, SearchContext wd) throws Exception {
		super(wd, id);
	}

	public String getImgFileName() {
		String src = getWebElement().getAttribute("src");
		int start = src.lastIndexOf("/");
		int end = src.lastIndexOf(".");
		return src.substring(start + 1, end);
	}

}
