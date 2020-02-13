package com.nop.uat.reg.utilies;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nop.uat.reg.base.TestBase;

public class Actionclass {

	public TestUtil utils;
	public WebDriver driver;
	public static Properties pro;

	public By click(By element) {
		try {
			TestBase.highlightElement(element);
			driver.findElement(element).click();
		} catch (Exception e) {
			throw new RuntimeException("Failed: To click the element in the given time" + e.getMessage());
		}
		return element;
	}
	
	public void enterText(By element,String text) {
		try {
			TestBase.highlightElement(element);
			System.out.println("SENDING TEXT");
			Thread.sleep(2000);
			driver.findElement(element).sendKeys(text);
			
		} catch (Exception e) {
			throw new RuntimeException("Failed: To enter the text into the field in the given time" + e.getMessage());
		}
	}
	
	public void javascriptEnterText(By element,String text) {
		try {
			WebElement ele=driver.findElement(element);
			JavascriptExecutor myExecutor = (JavascriptExecutor) driver;
			myExecutor.executeScript("arguments[0].value='"+text+"';'",ele);
			TestBase.highlightElement(element);
		} catch (Exception e) {
			throw new RuntimeException("Failed: To enter the text in the given time" + e.getMessage());
		}
	}
	
}
