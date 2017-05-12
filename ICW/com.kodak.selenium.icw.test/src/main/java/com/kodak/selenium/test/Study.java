package com.kodak.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.kodak.selenium.helper.ScreenshotHelper;

public class Study {

	public Study() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.bin", "C:\\Program
		// Files\\Google\\Chrome\\Application\\chrome.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\FilesToDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 有的时候访问不了下面的url
		driver.get("http://literallycanvas.com/");

		String css = "div[title='Rectangle']";
		// driver.findElement(By.cssSelector(css)).click();
		WebElement element_canvas = driver.findElement(By.cssSelector("canvas:nth-child(2)"));
		// WebElement element_canvas =
		// driver.findElement(By.className("lc-drawing"));

		Actions actions = new Actions(driver);
		// release()表示释放鼠标
		actions.clickAndHold(element_canvas).moveByOffset(10, 10).moveByOffset(20, 5).release().perform();
		Thread.sleep(1000 * 5);
		ScreenshotHelper.taksScreenshot(driver, "1");
		
		actions.clickAndHold(element_canvas).moveByOffset(10, 50).moveByOffset(50, 10).release().perform();
		Thread.sleep(1000 * 5);
		ScreenshotHelper.taksScreenshot(driver, "2");

//		actions.clickAndHold(element_canvas).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
//				.moveByOffset(-50, -10).release().perform();
//		ScreenshotHelper.taksScreenshot(driver, "2");
//
//		actions.moveToElement(element_canvas, 10, 10).click().perform();
//		ScreenshotHelper.taksScreenshot(driver, "3");
//		actions.moveToElement(element_canvas, 100, 130).click().perform();
//		ScreenshotHelper.taksScreenshot(driver, "4");
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Done");
	}

}
