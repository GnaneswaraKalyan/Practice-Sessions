package com.nop.uat.reg.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nop.uat.reg.utilies.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties pro;
	
	
	/*public TestBase() {
		try {
			pro=new Properties();
			
			FileInputStream fis = new FileInputStream("D:\\Practice\\End-To-End-Testing\\src\\main\\java\\com\\nop\\uat\\reg\\config\\config.properties");
			
			pro.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	public static void initialization() {
		try {
			pro=new Properties();
			
			FileInputStream fis = new FileInputStream("D:\\Practice\\End-To-End-Testing\\src\\main\\java\\com\\nop\\uat\\reg\\config\\config.properties");
			
			pro.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		////////////
		String browserName = pro.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Practice\\End-To-End-Testing\\src\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Practice\\End-To-End-Testing\\src\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("url"));
	}
	
	public static void quit() {
		driver.close();
	}
	
	public void dynamicWait(int seconds, By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			highlightElement(element);
		} catch (Exception e) {
			throw new RuntimeException("Failed: To click the Highlight the elements in the given Time" + e.getMessage());
		}
	}

	public static void highlightElement(By element) {
		try {
			WebElement ele=driver.findElement(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println("before");
			js.executeScript("arguments[0].setAttribute('style', 'border: 5px solid orange;');",ele);
			Thread.sleep(5000);
			System.out.println("after");
		} catch (Exception e) {
			throw new RuntimeException("Failed: To click the Highlight the elements in the given Time" + e.getMessage());
		}
	}

	

}

