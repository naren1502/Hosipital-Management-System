package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import generic_library.ReadDataFromPropertyFile;
import pom_Repository.Admin_Home_Page;
import pom_Repository.Doctors_Home_Page;

public class TC_022 extends BaseClass_HMS {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",20);
	}
	@Test (dataProvider = "userData") 
	public void forAlternateBookingAppointment(String data[]){
		//to check PatientPageTitle
				Doctors_Home_Page doctor=new Doctors_Home_Page(driver);
				doctor.getDoctorElement().click();
				String actualDoctorPageTitle = driver.getTitle();
				Assert.assertEquals(actualDoctorPageTitle, data[0], "Doctor Login is mismatched");
				Reporter.log("Doctor Login page is displayed", true);

				//to enter username
				doctor.getUserNameElement().sendKeys(ReadDataFromPropertyFile.fromPropertyFile("doctorUsername"));
				String actualUsernameEntered = doctor.getUserNameElement().getAttribute("value");
				Assert.assertEquals(actualUsernameEntered, data[1], "UserName is mismatched");
				Reporter.log("username is entered successfully", true);

				// to enter password
				doctor.getPassWordEelement().sendKeys(ReadDataFromPropertyFile.fromPropertyFile("doctorPassword"));
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
				doctor.getAddName().sendKeys(data[4]);
				Assert.assertEquals(doctor.getAddName().getAttribute("value"), data[4], "entered name is mismatched");
				Reporter.log("entered name is added successfully", true);
				
				int contact=(int) Double.parseDouble(data[5]+"");
				doctor.getAddContact().sendKeys(contact+"");
				Assert.assertEquals(doctor.getAddContact().getAttribute("value"), contact+"", "entered phonenumber is mismatched");
				Reporter.log("entered phone number is added successfully", true);
				doctor.getAddEmail().sendKeys(data[6]);
				Assert.assertEquals(doctor.getAddEmail().getAttribute("value"), data[6], "entered email id is mismatched");
				Reporter.log("entered email id is added successfully", true);
				
				doctor.getRadioButton().click();
				doctor.getAddAddress().sendKeys(data[7]);
				Assert.assertEquals(doctor.getAddAddress().getAttribute("value"),data[7], "entered city is mismatched");
				Reporter.log("entered city is added successfully",true);
			
				doctor.getMedicalHistoryElement().sendKeys(data[8]);
				Assert.assertEquals(doctor.getMedicalHistoryElement().getAttribute("value"), data[8], "entered data is mismatched");
				Reporter.log("entered medical history is added successfully", true);
				doctor.getAddButton().click();
				
				
				Admin_Home_Page admin=new Admin_Home_Page(driver);
				admin.getPatientsElement().click();
				admin.getManagePatients().click();


	}

}
