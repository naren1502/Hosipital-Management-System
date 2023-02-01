package hospital_management_system;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.ChangePasswordPage;
import pom_Repository.Patients_Home_Page;

public class TC_017 extends BaseClass_HMS {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",16);
	}
	@Test (dataProvider = "userData") 
	public void forpatientModule(String data[]) {
		Patients_Home_Page patient=new Patients_Home_Page(driver);
		ChangePasswordPage change=new ChangePasswordPage(driver);
		//to check PatientPageTitle
		patient.getPatientElement().click();
		String actualPatientPageTitle = driver.getTitle();
		Assert.assertEquals(actualPatientPageTitle, data[0], "User login page is not displayed");
		Reporter.log("user login page is displayed", true);

		//to enter username
		patient.getUserNameElement().sendKeys(data[1]);
		String actualUsernameEntered = patient.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameEntered, data[1], "UserName is mismatched");
		Reporter.log("username is entered successfully", true);

		// to enter password
		patient.getPassWordEelement().sendKeys(data[2]);
		String actualpasswordEntered = patient.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpasswordEntered, data[2], "password is mismatched");
		Reporter.log("password is entered successfully", true);

		//to login for patient module
		patient.getLoginButton().click();
		String actualPatientHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualPatientHomePageTitle, data[3], "patientHomePageTitle is mismatched");
		Reporter.log("patientHomePageTitle: User | Dashboard is displayed successfully", true);

		//click on profile dropdown
		change.getProfileDropdown().click();

		//click on change password
		change.getChangePasswordOption().click();
		String actualPage = change.getChangePasswordPage().getText().trim();
		Assert.assertEquals(actualPage, data[4],"change password page is not displayed");
		Reporter.log("change password page is displayed",true);

		//enter the current password
		change.getCurrentPasswordTextfield().sendKeys(data[5]);
		String actualCurrentPassword = change.getCurrentPasswordTextfield().getAttribute("value");
		Assert.assertEquals(actualCurrentPassword, data[5],"current password is not entered properly");
		Reporter.log("current password is entered properly",true);

//		//enter the new password
//		change.getNewPasswordTextfield().sendKeys(data[6]);
//		String actualNewPassword = change.getNewPasswordTextfield().getAttribute("value");
//		Assert.assertEquals(actualNewPassword, data[6],"New password is not entered properly");
//		Reporter.log("New password is entered properly",true);

		//enter the confirm password
		change.getConfirmPasswordTextfield().sendKeys(data[6]);
		String actualConfirmPassword = change.getConfirmPasswordTextfield().getAttribute("value");
		Assert.assertEquals(actualConfirmPassword, data[6],"Confirm password is not entered properly");
		Reporter.log("Confirms password is entered properly",true);
		
		//click on submit button
		change.getSubmitButton().click();
		Alert alert = driver.switchTo().alert();
		String actualErrorMsg = alert.getText();
		alert.accept();
		Assert.assertEquals(actualErrorMsg,data[7],"current password is entered");
		Reporter.log("current password is not entered",true);
		
		
		
	}

}
