package com.kodak.selenium.test;

import org.testng.annotations.Test;

import com.kodak.selenium.icw.enums.SRFileStatus;

import org.testng.annotations.BeforeClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.AfterClass;

public class Test1 extends ObjectRepositoryTest {
//	@Test
	public void f() {
		SRFileStatus st = SRFileStatus.Approved;
		System.out.println(st.toString());
	}

	public void beforeClass1() {
		super.beforeClass();
		System.out.println("Before::" + this.getClass().getSimpleName());
	}

	@AfterClass
	public void afterClass() {
	}
	
	@Test
	public void studyRegex(){
		String f = "A.pdf (r3332) (ÐÞ¸Ä°æ: 3)(r34)..(r123)..999..(001)";
	 String result=	getRevision(f);
	 System.out.println(result);
		
		
	}
	
	private String getRevision(String revisionName){
		
//		String ptn = "\\(r(\\d)\\)";
		String ptn = "\\(r(\\d+)\\)";

		System.out.println("ptn:"+ptn);
		System.out.println("revisionName:"+revisionName);
		Matcher m= Pattern.compile(ptn).matcher(revisionName);
		while(m.find()){
			String v = m.group(1);
			int i= Integer.valueOf(v);
			System.out.println(i);
		}
		
		
		
		return "";
//		return null;
		
	}

}
