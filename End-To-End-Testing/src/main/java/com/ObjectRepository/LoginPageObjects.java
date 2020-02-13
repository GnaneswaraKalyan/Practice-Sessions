package com.ObjectRepository;

import org.openqa.selenium.By;

public class LoginPageObjects {

	public By lp_TitleVal = By.xpath("//h1[text()='Admin area demo']");
	public By email_txtbx = By.xpath("//input[@class='email']");
	public By pwd_txtbx = By.xpath("//input[@class='password']");
	public By rem_txt = By.xpath("//*[text()='Remember me?']");
	public By login_btn = By.xpath("//*[@type='submit']");
	

	
}
