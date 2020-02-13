package com.nop.uat.reg.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ObjectRepository.HomepageObjects;
import com.ObjectRepository.LoginPageObjects;
import com.nop.uat.reg.base.TestBase;
import com.nop.uat.reg.pages.Dashboard;
import com.nop.uat.reg.pages.Homepage;
import com.nop.uat.reg.pages.LoginPage;
import com.nop.uat.reg.utilies.Actionclass;
import com.nop.uat.reg.utilies.TestUtil;

public class TC001_LoginTest extends TestBase {

	static LoginPageObjects loginPage;
	static LoginPage lp;
	static Dashboard dashboard;
	static Actionclass actions;
	static TestUtil utils;
	static TestBase tb;
	static HomepageObjects home;

	@BeforeClass
	public static void setUp() {
		initialization();
		lp = new LoginPage();
		loginPage = new LoginPageObjects();
		dashboard = new Dashboard();
		actions = new Actionclass();
		home = new HomepageObjects();
	}

	@Test(priority = 1)
	public static void validateloginTest() throws Exception {
		highlightElement(lp.webTitle);
		Thread.sleep(3000);
		System.out.println("Is Displayed");
	}

	@Test
	public static void loginTest() throws Throwable {
		Thread.sleep(2000);
		actions.javascriptEnterText(loginPage.email_txtbx, pro.getProperty("username"));

	}

	@Test(priority = 3)
	public static void homeTest() throws Throwable {
		loginTest();
		highlightElement(home.nop_Logo);
		Thread.sleep(3000);
		highlightElement(home.NopCommerce_News);
		Thread.sleep(3000);
		highlightElement(home.Common_statistics);
		Thread.sleep(3000);
		highlightElement(home.nop_Logout);
		Thread.sleep(3000);
	}

	@AfterClass
	public static void teardown() {
		quit();
	}

}
