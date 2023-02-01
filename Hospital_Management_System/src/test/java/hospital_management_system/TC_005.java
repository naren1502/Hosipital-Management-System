package hospital_management_system;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Doctors_Home_Page;

public class TC_005 extends BaseClass_HMS{

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",4);
	}
	@Test (dataProvider = "userData")
	public void forDoctorModule(String data[]){
		//to check PatientPageTitle
		Doctors_Home_Page doctor=new Doctors_Home_Page(driver);
		doctor.getDoctorElement().click();
		String actualDoctorPageTitle = driver.getTitle();
		Assert.assertEquals(actualDoctorPageTitle, data[0], "Doctor Login is mismatched");
		Reporter.log("Doctor Login page is displayed", true);

		//to enter username
		doctor.getUserNameElement().sendKeys(data[1]);
		String actualUsernameEntered = doctor.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameEntered, data[1], "UserName is mismatched");
		Reporter.log("username is entered successfully", true);

		// to enter password
		doctor.getPassWordEelement().sendKeys(data[2]);
		String actualpasswordEntered = doctor.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpasswordEntered, data[2], "password is mismatched");
		Reporter.log("password is entered successfully", true);

		//to login for patient module
		doctor.getLoginButton().click();
		String actualDoctorHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualDoctorHomePageTitle, data[3], "DoctorHomePageTitle is mismatched");
		Reporter.log("DoctorHomePageTitle is displayed successfully", true);

		doctor.getPatientElement().click();
		doctor.getManagePatient().click();
		doctor.getEditDetails().click();
		doctor.getAddName().clear();

		//enter the name
		doctor.getAddName().sendKeys(data[4]);
		Assert.assertEquals(doctor.getAddName().getAttribute("value"),data[4], "entered name is mismatched");
		Reporter.log("entered name is updated successfully", true);
		
		//enter the address
		doctor.getAddAddress().clear();
		doctor.getAddAddress().sendKeys(data[5]);
		Assert.assertEquals(doctor.getAddAddress().getAttribute("value"), data[5], "entered address is mismatched");
		Reporter.log("entered address is updated successfully", true);
		
		//enter the medical history
		doctor.getMedicalHistoryElement().clear();
		doctor.getMedicalHistoryElement().sendKeys(data[6]);
		Assert.assertEquals(doctor.getMedicalHistoryElement().getAttribute("value"), data[6], "entered data is mismatched");
		Reporter.log("entered medical history is updated successfully", true);
		doctor.getUpdateElement().click();
		
		doctor.getSearchPatient().click();
		doctor.getSearchByEnteringName().sendKeys(data[7]);
		doctor.getSearchButton().click();
		String actual = driver.findElement(By.xpath("(//tr)[2]/..//td[@class='hidden-xs']")).getText();
		Assert.assertEquals(actual, data[7], "name is mismatched");
		Reporter.log("patient report is added successfully", true);

	}

}
