package hospital_management_system;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Admin_Home_Page;

public class TC_008 extends BaseClass_HMS{
	WebDriverWait explicitWait;
	
	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",7);
	}
	@Test (dataProvider = "userData")
	public void forAdminModule(String data[]){
		//to check AdminPageTitle
		Admin_Home_Page admin=new Admin_Home_Page(driver);
		explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		admin.getAdminElement().click();
		String actualAdminPageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminPageTitle, data[0], "Admin Login is mismatched");
		Reporter.log("Admin Login page is displayed", true);

		//to enter username
		admin.getUserNameElement().sendKeys(data[1]);
		String actualUsername  = admin.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsername , data[1], "UserName is mismatched");
		Reporter.log("username is   successfully", true);

		// to enter password
		admin.getPassWordEelement().sendKeys(data[2]);
		String actualpassword  = admin.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpassword ,data[2], "password is mismatched");
		Reporter.log("password is   successfully", true);

		//to login enter patient module
		admin.getLoginButton().click();
		String actualAdminHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminHomePageTitle, data[3], "AdminHomePageTitle is mismatched");
		Reporter.log("AdminHomePageTitle is displayed successfully", true);
		//to add doctor in admin
		admin.getDoctorsElement().click();
		admin.getAddDoctorElement().click();
		admin.getSelectDropdown().click();

		//selecting the doctor
		Select select=new Select(admin.getSelectDropdown());
		select.selectByIndex(1);

		//enter doctorname textfield
		admin.getDocNameElement().sendKeys(data[4]);
		String actaulDoctorName = admin.getDocNameElement().getAttribute("value");
		Assert.assertEquals(actaulDoctorName, data[4],"DoctorName is mismatched");
		Reporter.log("  Doctor name is entered properly", true);

		// enter doctorAddress textfiled
		admin.getDocAddressElement().sendKeys(data[5]);
		String actualDoctorAddress = admin.getDocAddressElement().getAttribute("value");
		Assert.assertEquals(actualDoctorAddress, data[5],"DoctorAddress is mismatched");
		Reporter.log("  Doctor Address is entered properly", true);

		// enter DoctorFees textfiled
		int amt=(int) Double.parseDouble(data[6]);
		admin.getDocFeesElement().sendKeys(amt+"");
		String actualDoctorFees = admin.getDocFeesElement().getAttribute("value");
		Assert.assertEquals(actualDoctorFees, amt+"","DoctorFees is mismatched");
		Reporter.log("  Doctor Fees is entered properly", true);

		// enter DoctorContact textfiled
		int contact=(int) Double.parseDouble(data[7]);
		admin.getDocContactElement().sendKeys(contact+"");
		String actualDoctorContact = admin.getDocContactElement().getAttribute("value");
		Assert.assertEquals(actualDoctorContact, contact+"","DoctorContact is mismatched");
		Reporter.log("Doctor Contact is entered properly", true);

		// enter DoctorEmail textfiled
		admin.getDocEmailElement().sendKeys(data[8]);
		String actualDoctorEmail = admin.getDocEmailElement().getAttribute("value");
		Assert.assertEquals(actualDoctorEmail, data[8],"DoctorEmail is mismatched");
		Reporter.log("Doctor Email is entered properly", true);

		// enter DoctorPassword textfiled
		admin.getDocPasswordElement().sendKeys(data[9]);
		String actaualDoctorPassword = admin.getDocPasswordElement().getAttribute("value");
		Assert.assertEquals(actaualDoctorPassword,data[9],"DoctorPassword is mismatched");
		Reporter.log("Doctor Password is entered properly",true);

		// enter DoctorConfirmPassword textfiled
		admin.getDocConfirmPassword().sendKeys(data[10]);
		String actualDoctorConfirm = admin.getDocConfirmPassword().getAttribute("value");
		Assert.assertEquals(actualDoctorConfirm,data[10],"Doctor ConfirmPassword is mismatched");
		Reporter.log("Doctor ConfirmPassword is matched with DoctorPassword textfield  properly", true);

		//for submit 
		explicitWait.until(ExpectedConditions.elementToBeClickable(admin.getSubmitButton()));
		admin.getSubmitButton().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Reporter.log("Doctor name added successfully",true);

		admin.getDoctorsElement().click();
		admin.getManageDoctorElement().click();
		driver.findElement(By.xpath("//td[text()='"+data[4]+"']/..//a[@tooltip='Edit']")).click();
		admin.getDocNameElement().clear();
		admin.getDocNameElement().sendKeys(data[11]);
		admin.getUpdateElement().click();

		Assert.assertEquals("Doctor Details updated Successfully", data[12], "updated message is not matching");
		Reporter.log("Doctor details updated successfully",true);
	}
}
