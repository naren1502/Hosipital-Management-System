package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Patients_Home_Page;

public class TC_001 extends BaseClass_HMS{
	
	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",0);
	}
	@Test (dataProvider = "userData")
	public void forpatientModule(String[]data) throws InterruptedException{
		Patients_Home_Page patient=new Patients_Home_Page(driver);
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
		patient.getUpdateProfileElement().click();
		patient.getAddressElement().clear();
		patient.getAddressElement().sendKeys(data[4]);
		patient.getUpdateButton().click();
	}
}
