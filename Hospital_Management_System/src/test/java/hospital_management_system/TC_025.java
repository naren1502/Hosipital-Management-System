package hospital_management_system;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Patients_Home_Page;

public class TC_025 extends BaseClass_HMS {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",24);
	}
	@Test (dataProvider = "userData") 
	public void enterAlternateBookingAppointment(String data[]){
		Patients_Home_Page patient=new Patients_Home_Page(driver);
		//to check PatientPageTitle
		patient.getPatientElement().click();
		String actualPatientPageTitle = driver.getTitle();
		Assert.assertEquals(actualPatientPageTitle, data[0], "User login is mismatched");
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
	
		patient.getUserNameProfile().click();
		patient.getMyProfileElement().click();
		
		//update the username
		patient.getNameElement().clear();
		patient.getNameElement().sendKeys(data[4]);
		String actualUsernameUpdated = patient.getNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameUpdated, data[4], "updated UserName is mismatched");
		Reporter.log("updated name is entered successfully", true);
		
		//update the address
		patient.getAddressElement().clear();
		patient.getAddressElement().sendKeys(data[5]);
		String actualPlaceUpdated = patient.getAddressElement().getAttribute("value");
		Assert.assertEquals(actualPlaceUpdated, data[5], "updated place is mismatched");
		Reporter.log("updated place is entered successfully", true);
		patient.getGenderElement().click();
		Select select=new Select(patient.getGenderElement());
		select.selectByVisibleText(data[6]);
		patient.getUpdateButton().click();
		System.out.println(driver.findElement(By.xpath("//h5[contains(@style,'color: green')]")).getText());

	}

}
