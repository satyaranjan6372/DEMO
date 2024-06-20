package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tasklistpage {
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;

	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustBtn;
	@FindBy(id="customerLightBox_nameField")
	private WebElement customerNameTbx;
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement customerDescTbx;
	@FindBy(id="ext-gen29")
	private WebElement companyDropdownBtn;
	@FindBy(linkText = "Our Company")
	private WebElement ourComOpt;
	@FindBy(id="customerLightBox_commitBtn")
	private WebElement createCustBtn;
	@FindBy(xpath = "//a[text()='All Customers']/../../div[@class='title ellipsis']")
	private WebElement createdCustName;
	public  TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getNewCustBtn() {
		return newCustBtn;
	}
	public WebElement getCustomerNameTbx() {
		return customerNameTbx;
	}
	public WebElement getCustomerDescTbx() {
		return customerDescTbx;
	}
	public WebElement getCompanyDropdownBtn() {
		return companyDropdownBtn;
	}
	public WebElement getOurComOpt() {
		return ourComOpt;
	}
	public WebElement getCreateCustBtn() {
		return createCustBtn;
	}
	public WebElement getCreatedCustName() {
		return createdCustName;
	}
	}


