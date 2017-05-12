package com.kodak.selenium.icw.components;

import org.openqa.selenium.SearchContext;

import com.kodak.selenium.ui.NamedContainer;

public class SRPreference extends NamedContainer {

	public SRPreference(SearchContext wd) throws Exception {
		super(wd, "srPreference");
		// TODO Auto-generated constructor stub
	}

	/*
	 * Buttons
	 */
	public void done() throws Exception {
		this.click("preDone");
	}
	
	public void setDefault() throws Exception{
		this.click("preDefault");
	}
	/*
	 * General
	 */
	public void setApprove(ApproveReviewOptions arOption) throws Exception{
		new SpanValueDropdown(this._selfContext,"preApproveReview").select(arOption.value());
	}
	
	/*
	 * Units
	 * 
	 */
	
	/*
	 * full Screen
	 */
	public void showAnnotations(boolean show){
		
	}
	/*
	 * 
	 * Internal classes
	 */
	public class SpanValueDropdown extends ICWDropdown {

		public SpanValueDropdown(SearchContext wd, String id) throws Exception {
			super(wd, id);
			// TODO Auto-generated constructor stub
		}

		public void select(int spanValue) throws Exception {
			this.open();
			String css = String.format("span[value='%d']", spanValue);
			this.findItem(css).click();
		}
	}

	public static enum ApproveReviewOptions {
		Prompt(0), Next(1), Current(2);
		
		private ApproveReviewOptions(int value) {

			_value = value;
		}

		private int _value;

		public int value() {
			return _value;
		}
	}

}
