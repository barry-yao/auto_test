package com.kodak.selenium.icw.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kodak.selenium.helper.ScreenshotHelper;
import com.kodak.selenium.icw.components.SRPreference;
import com.kodak.selenium.icw.components.SRPreference.ApproveReviewOptions;
import com.kodak.selenium.icw.enums.FileListStyles;
import com.kodak.selenium.icw.enums.SRFileStatus;
import com.kodak.selenium.icw.pages.MyTasks;
import com.kodak.selenium.icw.pages.SmartReview;

public class ReviewTest extends FunctionTestBase {

	public ReviewTest() {
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {

	}

	@AfterMethod
	public void afterMethod() {

		ScreenshotHelper.taksScreenshot(this.inst.getWebDriver());
		try {
			Thread.sleep(1000 * 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void approve() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();
		sr.approve("Approved");
		sr.close();
	}

	// @Test
	public void reject() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();
		sr.reject("Approved");
		sr.close();
	}

	// @Test
	public void annoText4() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();

		sr.drawTest();

		sr.close();
	}

	// @Test
	public void testFileItem() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();

		for (String file : sr.getFiles()) {

			this._logger.info("File:" + file);
			SRFileStatus status = sr.getFileStatus(file);
			this._logger.info("Status:" + status.toString());

		}
		sr.close();
	}

//	@Test
	public void changeFileListStyle() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();

		for( FileListStyles styles : FileListStyles.values()){
			sr.changeFileListStyle(styles);
//			Thread.sleep(1000*10);	
		}
		sr.close();
	}
	
//	@Test
	public void switchRevisions() throws Exception {
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sr = mt.openSR();
		sr.selectFileItem("A.pdf");
		int i= sr.getRevisionCount();
		for(int rev=i;rev>0;rev-=1){
			String name="Revision_" +rev;
			this._logger.info(name);
			sr.selectRevision(rev);
			sr.taksScreenshot(name);
			Thread.sleep(1000);
		}
		
		sr.selectLatestVersion();
		
		
		sr.close();
	}
	
//	@Test
	public void testJS() throws Exception{
		MyTasks mt = icwMain.gotoMyTasks();
		mt.openSR();
		Thread.sleep(1000*100);
	}
	
//	@Test
	public void testChangeTask() throws Exception{
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sReview =  mt.openSR();
		sReview.selectNoTask();
		sReview.selectTask("t1");
	}
	
	@Test
	public void testPreference() throws Exception{
		MyTasks mt = icwMain.gotoMyTasks();
		SmartReview sReview =  mt.openSR();
		SRPreference srPref= sReview.preference();
		srPref.setApprove(ApproveReviewOptions.Next);
		srPref.setApprove(ApproveReviewOptions.Prompt);
		srPref.setApprove(ApproveReviewOptions.Current);
		srPref.done();
		Thread.sleep(1000*10);
	}
	
	
	
}
