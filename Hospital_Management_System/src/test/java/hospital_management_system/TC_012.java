package hospital_management_system;


import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Patients_Home_Page;

public class TC_012 extends BaseClass_HMS {
	
	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",11);
	}
	@Test (dataProvider = "userData") 
	public void forpatientModule(String data[]){
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
		
		//booking appointment
		patient.getBookingAppointmentElement().click();
		patient.getSpecliazationIcon().click();
		Select select=new Select(patient.getSpecliazationIcon());
		select.selectByVisibleText(data[4]);
		Select select1=new Select(patient.getSelectDoctorElement());
		patient.getSelectDoctorElement().click();
		select1.selectByVisibleText(data[5]);
		patient.getDateElement().click();
		Actions actions=new Actions(driver);
		patient.getEnterDateforAppointment().click();
		actions.perform();
		patient.getTimeelement().click();
		patient.getHourElement().click();
		patient.getHourElement().clear();
		int time=(int) Double.parseDouble(data[6]);
		patient.getHourElement().sendKeys(time+"");
		
		patient.getSubmitButton().click();;
		
		Alert alert = driver.switchTo().alert();
		String actualSuccessMsg = alert.getText();
		Assert.assertEquals(actualSuccessMsg,data[7] , "appointment is booked");
		Reporter.log("Book appointment to appointment history is done", true);
		alert.accept();
	}

}
