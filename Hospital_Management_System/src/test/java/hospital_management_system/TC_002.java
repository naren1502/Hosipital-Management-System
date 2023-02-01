package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Doctors_Home_Page;

public class TC_002 extends BaseClass_HMS{
	
	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",1);
	}
	@Test (dataProvider = "userData")
	public void forDoctorModule(String data[]){
		
		//to check DoctorPageTitle
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
		
		doctor.getAddPatientElement().click();
		
		//enter the patient name
		doctor.getAddName().sendKeys(data[4]);
		String actualName = doctor.getAddName().getAttribute("value");
		Assert.assertEquals(actualName, data[4],"patient name is not entered properly");
		Reporter.log("patient name is entered properly");
		
		//enter the contact
		int contact=(int)Double.parseDouble(data[5]);
		doctor.getAddContact().sendKeys(contact+"");
		String actualContact = doctor.getAddContact().getAttribute("value");
		Assert.assertEquals(actualContact, contact+"","Contact number is not entered properly");
		Reporter.log("Contact number is entered properly");
		
		//enter the email id
		doctor.getAddEmail().sendKeys(data[6]);
		String actualEmail = doctor.getAddEmail().getAttribute("value");
		Assert.assertEquals(actualEmail, data[6],"Email id is not entered properly");
		Reporter.log("Email id is entered properly");
		
		//enter the address
		doctor.getAddAddress().sendKeys(data[7]);
		String actualAddress = doctor.getAddAddress().getAttribute("value");
		Assert.assertEquals(actualAddress, data[7],"Address is not entered properly");
		Reporter.log("Address is entered properly");
		
		//enter the age
		int age=(int)Double.parseDouble(data[8]);
		doctor.getAddAge().sendKeys(age+"");
		String actualAge = doctor.getAddAge().getAttribute("value");
		Assert.assertEquals(actualAge,age+"","Age is not entered properly");
		Reporter.log("Age is entered properly");
		
		//click on add button
		doctor.getAddButton().click();
	}
}
