package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "TASKS")
	private WebElement taskTab;
	@FindBy(linkText = "USERS")
	private WebElement userTab;
	@FindBy(id="logoutLink")
	private WebElement logoutBtn;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogout() {
		logoutBtn.click();
	}
	public void setTaskTab() {
		taskTab.click();
	}
	public void setUserTab() {
		userTab.click();
	}
	}

