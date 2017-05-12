package com.kodak.selenium.icw.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import com.kodak.selenium.ui.ControlList;
import com.kodak.selenium.ui.NamedContainer;

public class ICWDropdownList<T> extends NamedContainer {

	protected String _menuItemId;

	public ICWDropdownList(SearchContext wd, String id, String menuItemId) throws Exception {
		super(wd, id);
		_menuItemId = menuItemId;
	}

	protected boolean isOpened() throws ObjectDefinitionError {
		String cls = this.getSelf().getClassName();
		return cls.contains("dropdown-open");
	}

	public void select(T value) throws Exception {
		if (!this.isOpened()) {
			this.getSelf().click();
		}

		String dataCss = this.getSelf().getAttr("data-dropdown");
		NamedContainer menu = new NamedContainer(this.getSelf().getWebDriver(), By.cssSelector(dataCss));
		menu.click(getMenuItemId(value), getMenuItemValue(value));
	}

	protected String getMenuItemValue(T value) {
		return value.toString();
	}
	
	protected String getMenuItemId(T value){
		return _menuItemId;
	}

	public T getCurrent() {
		return null;
	}

	public int getMenuItemCount() {
		try {
			if (!this.isOpened()) {
				this.getSelf().click();

			}
			String dataCss = this.getSelf().getAttr("data-dropdown");
			NamedContainer menu = new NamedContainer(this.getSelf().getWebDriver(), By.cssSelector(dataCss));
			if (this.isOpened()) {
				this.getSelf().click();
			}
			return new ControlList(menu.getSelf(), By.cssSelector("li:not(.dropdown-divider)")).count();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

	}

}
