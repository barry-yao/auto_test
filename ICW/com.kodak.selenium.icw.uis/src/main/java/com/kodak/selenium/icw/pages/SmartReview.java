package com.kodak.selenium.icw.pages;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kodak.selenium.icw.components.ICWDropdown;
import com.kodak.selenium.icw.components.ICWDropdownList;
import com.kodak.selenium.icw.components.SRFileItem;
import com.kodak.selenium.icw.components.SRPreference;
import com.kodak.selenium.icw.enums.FileListStyles;
import com.kodak.selenium.icw.enums.SRFileStatus;
import com.kodak.selenium.ui.Canvas;
import com.kodak.selenium.ui.ControlList;
import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;

import jdk.nashorn.internal.ir.ThrowNode;

import com.kodak.selenium.ui.NewPage;
import com.kodak.selenium.ui.SimpleMethod;

public class SmartReview extends NewPage {

	/*
	 * Parts
	 * 
	 * 
	 */
	
	
	public SmartReview(WebDriver wd, SimpleMethod trigger) throws Exception {
		super(wd, trigger);
		this.waitElementAppear("review.progressbar");
		this.waitElementDisappear("review.progressbar");
	}

	private Canvas getMainCanvas() throws Exception {
		return this.getCanvas("viewKinetic0");
	}

	@Override
	protected void waitLoading() throws Exception {

		this.waitElementDisappear("review.progressbar");
	}

	public void approve(String comment) throws Exception {
		this.click("approve");
		this.input("reviewUserComment", comment);

		this.click("reviewApply");
		this.click("Current");
	}

	public void reject(String comment) throws Exception {
		this.click("reject");
		this.input("reviewUserComment", comment);
		this.click("reviewApply");
		this.click("Current");
	}

	public String getLeftFileName() throws Exception {
		return this.getHtmlControl("leftTitle").getText();
	}

	public String getMiddleFileName() throws Exception {
		return this.getHtmlControl("middleTitle").getText();
	}

	/*
	 * Left region operations
	 */

	public SRFileStatus getFileStatus(String fileName) throws Exception {
		SRFileItem sfFile = new SRFileItem(this._webDriver, fileName);
		return sfFile.getStaus();
	}

	public void changeFileListStyle(FileListStyles style) throws Exception {
		FileListStyleDropdown list = new FileListStyleDropdown();
		if (list.getCurrent() != style)
			list.select(style);
	}

	public List<String> getFiles() throws Exception {
		return new ControlList(_webDriver, "fileItemNames").getTexts();
	}

	public void selectFileItem(String name) throws Exception {

		this._logger.info("Select file:" + name);
		if (this.getCurrentDisplayedFile().equals(name))
			return;

		this.getHtmlControl("fileItemWithName", name).click();

		this.waitLoading();
	}

	public String getCurrentDisplayedFile() throws Exception {
		return this.getText("currentFileItem");
	}
	
	/*
	 * Change tasks name
	 */
	private ICWDropdown taskDropdown() throws Exception{
		return new ICWDropdown(this._webDriver, "taskName");
	}
	
	public void selectTask(String taskName) throws Exception{
		 taskDropdown().select(taskName);
		 this.waitLoading();
	}
	public void selectNoTask() throws Exception{
		taskDropdown().select("NoTask");
		this.waitLoading();
	}
	

	/*
	 * Main canvas
	 * 
	 */
	public void selectRevision(int i) throws Exception {
		new RevisionDropdown().selectRevision(i);
		this.waitLoading();
	}

	public void selectLatestVersion() throws Exception {
		new RevisionDropdown().selectLatestVersion();
		this.waitLoading();
	}

	public int getRevisionCount() throws Exception {
		return new RevisionDropdown().getRevisionCount();
	}

	/*
	 * Annotation part
	 */
	public void drawText(String id) throws Exception {
		this.click("buttonAnnotationText");
		// Thread.sleep(1000 * 2);
		this.getCanvas(id).click(100, 200);
		// this.taksScreenshot("Canvas_" + id);
		// this._logger.info("done");
		this.click(id);
	}

	public void drawTest() throws Exception {
		this.click("buttonAnnotationText");

		// String css1 = "#viewKinetic0 canvas:last-child";
		String css1 = "#viewKinetic0";

		Actions as = new Actions(this._webDriver);

		WebElement we = this._selfContext.findElement(By.cssSelector(css1));

		as.moveToElement(we, 100, 100).clickAndHold().release(we).perform();

		// as.moveToElement(we, 100, 200).clickAndHold().release(we).perform();
		// we.click();
		Thread.sleep(1000 * 10);
		// we.click();
		this.input("userComment", "This is automation text annotation");
		this.click("annotationControlCreate");
	}

	/*
	 * Annotation part
	 */
	public void drawText(int x, int y, String text) throws Exception {
		this.click("buttonAnnotationText");
		this.getMainCanvas().click(x, y);
		this.taksScreenshot("Canvas");
		this._logger.info("done");
	}
	
	/*
	 * 
	 * 
	 */
	public SRPreference preference() throws Exception{
		this.click("buttonUserPreference");
		return new SRPreference(this._selfContext);
	}

	/*
	 * Inner class
	 */
	public class FileListStyleDropdown extends ICWDropdown {
		public FileListStyleDropdown() throws Exception {
			super(SmartReview.this._selfContext, "buttonSetFileListStyle");
		}

		public FileListStyles getCurrent() {
			try {
				String clsName = this.getClassName().split(" ")[0];
				return FileListStyles.parse(clsName);
			} catch (ObjectDefinitionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public void select(FileListStyles style) throws Exception {
			this.open();
			dataContent.findElement(By.className(style.getMenuItemClassName())).click();
		}
	}

	public class RevisionDropdown extends ICWDropdown {

		public RevisionDropdown() throws Exception {
			super(SmartReview.this._selfContext, "imageHeaderDropdownTrigger");
		}

		public int getCurrentVersion() {
			try {
				String revisionName = this.current();
				String ptn = "\\(r(\\d+)\\)";

				Matcher m = Pattern.compile(ptn).matcher(revisionName);
				return m.find() ? Integer.valueOf(m.group(1)) : 0;
			} catch (ObjectDefinitionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}

		public int getRevisionCount() {
			// 1: one is latest Version,
			// 2. the seprator
			String cssSelector = "li:not(.dropdown-divider)";
			return this.dataContent.getWebElement().findElements(By.cssSelector(cssSelector)).size() - 1;
		}

		public void selectRevision(int revision) throws Exception {
			if (revision <= 0) {
				throw new InvalidParameterException("revision must be positive:" + revision);
			}
			String css = String.format("li:nth-last-child(%d) a", revision);
			String string = this.findItem(css).getAttribute("innerText");
			this.select(string);
		}

		public void selectLatestVersion() throws Exception {
			String string = this.findItem("li:first-child").getAttribute("innerText");
			this.select(string);
		}

	}

}
