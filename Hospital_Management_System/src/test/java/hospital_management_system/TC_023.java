package hospital_management_system;

import java.time.Duration;
import org.openqa.selenium.Alert;
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

public class TC_023 extends BaseClass_HMS {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",22);
	}
	@Test (dataProvider = "userData") 
	public void enterAlternateBookingAppointment(String data[]){
		//to check AdminPageTitle
		Admin_Home_Page admin=new Admin_Home_Page(driver);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		admin.getAdminElement().click();
		String actualAdminPageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminPageTitle, data[0], "Admin Login is mismatched");
		Reporter.log("Admin Login page is displayed", true);

		//to enter username
		admin.getUserNameElement().sendKeys(data[1]);
		String actualUsernameEntered = admin.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameEntered, data[1], "UserName is mismatched");
		Reporter.log("username is entered successfully", true);

		// to enter password
		admin.getPassWordEelement().sendKeys(data[2]);
		String actualpasswordEntered = admin.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpasswordEntered, data[2], "password is mismatched");
		Reporter.log("password is entered successfully", true);

		//to login enter patient module
		admin.getLoginButton().click();
		String actualAdminHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminHomePageTitle,data[3], "Admin HomePage Title is mismatched");
		Reporter.log("Admin HomePage Title is displayed successfully", true);

		//to add doctor in admin
		admin.getDoctorsElement().click();
		admin.getAddDoctorElement().click();
		admin.getSelectDropdown().click();
		Select select=new Select(admin.getSelectDropdown());
		select.selectByIndex(1);

		//enter doctorname textfield

		admin.getDocNameElement().sendKeys(data[4]);
		String actaulDoctorName = admin.getDocNameElement().getAttribute("value");
		Assert.assertEquals(actaulDoctorName,data[4],"DoctorName is mismatched");
		Reporter.log("entered Doctorname is entered properly", true);
		// enter doctorAddress textfiled
		admin.getDocAddressElement().sendKeys(data[5]);
		String actualDoctorAddress = admin.getDocAddressElement().getAttribute("value");
		Assert.assertEquals(actualDoctorAddress, data[5],"DoctorAddress is mismatched");
		Reporter.log("entered Doctor Address is entered properly", true);

		// enter DoctorFees textfiled
		int fee=(int) Double.parseDouble(data[6]+"");
		admin.getDocFeesElement().sendKeys(fee+"");
		String actualDoctorFees = admin.getDocFeesElement().getAttribute("value");
		Assert.assertEquals(actualDoctorFees, fee+"","DoctorFees is mismatched");
		Reporter.log("entered Doctor Fees is entered properly", true);

		// enter DoctorContact textfiled
		int contact=(int) Double.parseDouble(data[7]+"");
		admin.getDocContactElement().sendKeys(contact+"");
		String actualDoctorContact = admin.getDocContactElement().getAttribute("value");
		Assert.assertEquals(actualDoctorContact, contact+"","Doctor Contact is mismatched");
		Reporter.log("entered Doctor Contact is entered properly", true);

		// enter DoctorEmail textfiled
		admin.getDocEmailElement().sendKeys(data[8]);
		String actualDoctorEmail = admin.getDocEmailElement().getAttribute("value");
		Assert.assertEquals(actualDoctorEmail, data[8],"Doctor Email is mismatched");
		Reporter.log("entered DoctorEmail is entered properly", true);

		// enter DoctorPassword textfiled
		admin.getDocPasswordElement().sendKeys(data[9]);
		String actaualDoctorPassword = admin.getDocPasswordElement().getAttribute("value");
		Assert.assertEquals(actaualDoctorPassword, data[9],"Doctor Password is mismatched");
		Reporter.log("entered Doctor Password is entered properly",true);

		// enter DoctorConfirmPassword textfiled
		admin.getDocConfirmPassword().sendKeys(data[10]);
		String actualDoctorConfirm = admin.getDocConfirmPassword().getAttribute("value");
		Assert.assertEquals(actualDoctorConfirm, data[10],"Doctor ConfirmPassword is mismatched");
		Reporter.log("entered Doctor Confirm Password is matched with DoctorPassword textfield entered properly", true);

		//enter submit 
		explicitWait.until(ExpectedConditions.elementToBeClickable(admin.getSubmitButton()));
		admin.getSubmitButton().click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Reporter.log("Doctor name added successfully",true);

		admin.getDashboardElement().click();
		admin.getAlterManageDoctorElement().click();
		admin.getDeleteElement().click();
		alert.accept();
		Reporter.log("Doctor name is deleted successfully",true);

	}

}
