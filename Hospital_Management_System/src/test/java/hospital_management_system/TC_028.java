package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Admin_Home_Page;
import pom_Repository.ForgotPassword_Page;
import pom_Repository.Patients_Home_Page;

public class TC_028 extends BaseClass_HMS{

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",27);
	}
	@Test (dataProvider = "userData") 
	public void forgotPasswordAndLogin(String data[]){
		Admin_Home_Page admin=new Admin_Home_Page(driver);
		ForgotPassword_Page forgot=new ForgotPassword_Page(driver);
		Patients_Home_Page patient=new Patients_Home_Page(driver);
		//to check PatientPageTitle
		patient.getPatientElement().click();
		String actualPatientPageTitle = driver.getTitle();
		Assert.assertEquals(actualPatientPageTitle, data[0], "User login page is not displayed");
		Reporter.log("user login page is displayed", true);
		
		//change the password
		forgot.forgotPassword(data);
		//to enter username
		admin.getUserNameElement().sendKeys(data[3]);
		String actualUsernameEntered = admin.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameEntered, data[3], "UserName is mismatched");
		Reporter.log("username is entered successfully", true);
		
		// to enter password
		admin.getPassWordEelement().sendKeys(data[5]);
		String actualpasswordEntered = admin.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpasswordEntered, data[5], "password is mismatched");
		Reporter.log("password is entered successfully", true);
		
		//to login for patient module
		admin.getLoginButton().click();
		String actualAdminHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminHomePageTitle, data[8], "Admin home page title is mismatched");
		Reporter.log("Admin home page title is displayed successfully", true);
		
	}
	

}
