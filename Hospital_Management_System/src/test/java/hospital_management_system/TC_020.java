package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.ChangePasswordPage;
import pom_Repository.Patients_Home_Page;
import pom_Repository.UpdateProfilePage;

public class TC_020 extends BaseClass_HMS {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",19);
	}
	@Test (dataProvider = "userData") 
	public void forpatientModule(String data[]) {
		Patients_Home_Page patient=new Patients_Home_Page(driver);
		ChangePasswordPage change=new ChangePasswordPage(driver);
		UpdateProfilePage update=new UpdateProfilePage(driver);
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
		
		//click on my profile
		change.getMyProfileOption().click();
		String actualEditProfilePage = update.getEditProfilePage().getText();
		Assert.assertEquals(actualEditProfilePage, data[4],"edit profile page is not displayed");
		Reporter.log("edit profile page is displayed",true);
		
		//click on update email id
		update.getUpdateEmailIdLink().click();
		String actualEditEmailPage = update.getUpdateEmailPage().getText().trim();
		Assert.assertEquals(actualEditEmailPage, data[5],"edit email page is not displayed");
		Reporter.log("edit email page is displayed",true);
		
		//update email id
		update.getUpdateEmailIdTextfield().sendKeys(data[6]);
		String actualUpdateEmail = update.getUpdateEmailIdTextfield().getAttribute("value");
		Assert.assertEquals(actualUpdateEmail, data[6],"email id is not entered properly");
		Reporter.log("email id is entered properly",true);
		
		//click on update button
		update.getUpdateButton().click();
		String actualUpdatedEmailMsg = update.getUpdateEmailMsg().getText().trim();
		Assert.assertEquals(actualUpdatedEmailMsg,data[7],"profile is not updated" );
		Reporter.log("profile is updated successfully",true);
		
		
	}

}
