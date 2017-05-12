package com.kodak.selenium.icw.components;

import org.openqa.selenium.WebDriver;

import com.kodak.selenium.ui.ContainerBase;

public class ToolbarStrip extends ContainerBase {

	public ToolbarStrip(WebDriver wd) {
		super(wd);
	}

	public void gotoPage(Pages p) throws Exception {
		this._logger.info(getImg(p.name()).getImgFileName());
		if (getImg(p.name()).getImgFileName().endsWith("Sel")) {
			return;
		}

		getImg(p.name()).click();
		
	}

	public enum Pages {
		pageBarMyTasks("MyTasks"), pageBarManageTask("MyManagedTasks"), pageBarProjectsLibraries(
				"FolderView"), pageBarManageAccess("ICWManageAccess");

		Pages(String fileName) {
			_fileName = fileName;
		}

		private String _fileName;

		public String getFileName() {
			return _fileName;
		}
	}

}
