package com.kodak.selenium.ui;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class NewPage extends PageBase {

	protected String _triggeredhandle;

	public NewPage(WebDriver wd, SimpleMethod trigger) throws Exception {
		super(wd);
		_triggeredhandle = wd.getWindowHandle();
		Set<String> oldHandles = wd.getWindowHandles();
		int olderHandles = oldHandles.size();
		// Action to open new window.
		trigger.action();
		// Wait till new window opens.
		while (wd.getWindowHandles().size() != olderHandles + 1) {
			Thread.sleep(500);
		}
		Set<String> newHandles = wd.getWindowHandles();
		newHandles.removeAll(oldHandles);
		String cur = (String) newHandles.toArray()[0];
		
		wd.switchTo().window(cur);
		this.waitLoading();
		String msg = String.format("Switch to new window, Title=%s, handler=%s", this._webDriver.getTitle(),
				this._webDriver.getWindowHandle());
		this._logger.info(msg);		
	}

	public void close() {
		String msg = String.format("Closing opend window, Title=%s, handler=%s", this._webDriver.getTitle(),
				this._webDriver.getWindowHandle());
		this._logger.info(msg);
		this._webDriver.close();
		this._webDriver.switchTo().window(_triggeredhandle);
		msg = String.format("Switched to window, Title=%s, handler=%s", this._webDriver.getTitle(),
				this._webDriver.getWindowHandle());
		this._logger.info(msg);

	}

}
