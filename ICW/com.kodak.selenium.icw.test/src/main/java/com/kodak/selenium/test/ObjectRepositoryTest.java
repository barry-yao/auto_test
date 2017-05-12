package com.kodak.selenium.test;

import org.testng.annotations.Test;

import com.kodak.selenium.icw.pages.ICWInstance;
import com.kodak.selenium.ui.HtmlControlDefinition;
import com.kodak.selenium.ui.ObjectRepository;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ObjectRepositoryTest {
  
  @BeforeClass
  public void beforeClass() {
	  ICWInstance inst = new ICWInstance();
	  System.out.println("Before :Base");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class:Base");
  }
  
  @Test
  public void test() throws Exception{
	 HtmlControlDefinition definition= ObjectRepository.getDefinition("myTasksPage");
	 System.out.println(definition.toString());
	 System.out.println("-=-=-==-=-=-=-=-=");
	 System.out.println(definition);
  }

}
