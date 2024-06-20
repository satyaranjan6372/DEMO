package com.actitime.textscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
import com.actitime.testscript.Listeners;
import com.actitime.testscript.Test;

public class CustomerModule {
	@Listeners(com.actitime.generic.ListenerImplementation.class)
	public class CustomerModule extends BaseClass{
		@Test
		public void createCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
			String expectedCustName=f.readDataFromExcel("CreateCustomer", 1, 2);
			String desc=f.readDataFromExcel("CreateCustomer", 1, 3);
			HomePage h=new HomePage(driver);
			h.setTaskTab();
			TaskListPage t=new TaskListPage(driver);
			t.getAddNewBtn().click();
			t.getNewCustBtn().click();
			t.getCustomerNameTbx().sendKeys(expectedCustName);
			t.getCustomerDescTbx().sendKeys(desc);
			t.getCompanyDropdownBtn().click();
			t.getOurComOpt().click();
			t.getCreateCustBtn().click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.textToBePresentInElement(t.getCreatedCustName(), expectedCustName));
			String actualCustName = t.getCreatedCustName().getText();
			Assert.assertEquals(actualCustName, expectedCustName);
//			Reporter.log(expectedCustName+" has been created",true);
			f.writeDataIntoExcel("CreateCustomer", 1, 5, expectedCustName+" has been created");
		}
	}
}
		

