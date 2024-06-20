package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileLib f=new FileLib();
	@BeforeTest
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readDataFromProperty("url");				driver.get(url);
		Reporter.log("openBrowser",true);
	}@BeforeMethod
	public void login() throws IOException {
		LoginPage l=new LoginPage(driver);
		String un = f.readDataFromProperty("un");
		String pwd = f.readDataFromProperty("pwd");			l.login(un,pwd);
		Reporter.log("login",true);
	}@AfterMethod
	public void logout() {
		HomePage h=new HomePage(driver);
		h.setLogout();
		Reporter.log("logout",true);
	}@AfterTest
	public void closeBrowser() {
		driver.quit();							Reporter.log("closeBrowser",true);
	}


}
