package com.nop.uat.reg.pages;

import java.util.Properties;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nop.uat.reg.base.TestBase;

public class LoginPage extends TestBase {

	static Properties pro;
	
	public By webTitle=By.xpath("//h1[text()='Admin area demo']");
	public By nopEmail=By.name("Email");
	public By nopPwd=By.name("Password");
	public By nopLoginBtn=By.xpath("//input[@class='button-1 login-button']");
	public By nopRememberMetext=By.xpath("//label[@for='RememberMe']");
	public By nopRememberMe_checkBox=By.xpath("//input[@type='checkbox']");
	
	
	}

