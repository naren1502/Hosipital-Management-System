package hospital_management_system;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_library.BaseClass_HMS;
import generic_library.ReadData;
import pom_Repository.Admin_Home_Page;

public class TC_011 extends BaseClass_HMS{
	
	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",10);
	}
	@Test (dataProvider = "userData")
	public void forAdminModule(String data[]){
		//to check AdminPageTitle
		Admin_Home_Page admin=new Admin_Home_Page(driver);
		//explicitWait=new WebDriverWait(driver, 15);
		admin.getAdminElement().click();
		String actualAdminPageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminPageTitle, data[0], "Admin Login is mismatched");
		Reporter.log("Admin Login page is displayed", true);

		//to enter username
		admin.getUserNameElement().sendKeys(data[1]);
		String actualUsernameEntered = admin.getUserNameElement().getAttribute("value");
		Assert.assertEquals(actualUsernameEntered,data[1], "UserName is mismatched");
		Reporter.log("username is entered successfully", true);

		// to enter password
		admin.getPassWordEelement().sendKeys(data[2]);
		String actualpasswordEntered = admin.getPassWordEelement().getAttribute("value");
		Assert.assertEquals(actualpasswordEntered, data[2], "password is mismatched");
		Reporter.log("password is entered successfully", true);

		//to login enter patient module
		admin.getLoginButton().click();
		String actualAdminHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualAdminHomePageTitle, data[3], "Admin home page title is mismatched");
		Reporter.log("Admin home page title is displayed successfully", true);

		//to add doctor specialization in admin
		admin.getDoctorsElement().click();
		admin.getDocSpecialization().click();
		admin.getEnterSpecialization().sendKeys(data[4]);
		String actualSpecialization = admin.getEnterSpecialization().getAttribute("value");
		Assert.assertEquals(actualSpecialization, data[4],"Specialization is not entered properly");
		admin.getSubmitButton().click();
		Reporter.log("entered specialization is entered properly", true);
		//System.out.println(driver.findElement(By.xpath("//p[@style='color:red;']")).getText());
		
		admin.getDoctorsElement().click();
		admin.getDocSpecialization().click();
		
		admin.getEditDocSpclElement().click();
		admin.getEnterDocSpclElement().clear();
		admin.getEnterDocSpclElement().sendKeys(data[5]);
		admin.getUpdateDocSpclButton().click();
	}
}
