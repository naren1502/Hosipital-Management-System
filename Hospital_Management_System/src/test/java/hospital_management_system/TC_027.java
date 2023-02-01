package hospital_management_system;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import generic_library.ReadData;
import generic_library.ReadDataFromPropertyFile;
import pom_Repository.ForgotPassword_Page;
import pom_Repository.Patients_Home_Page;

public class TC_027 {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",26);
	}
	@Test (dataProvider = "userData") 
	public void forgotPassword(String data[]){
		
		ForgotPassword_Page forgot=new ForgotPassword_Page(driver);
		Patients_Home_Page patient=new Patients_Home_Page(driver);
		//to check PatientPageTitle
		patient.getPatientElement().click();
		String actualPatientPageTitle = driver.getTitle();
		Assert.assertEquals(actualPatientPageTitle, data[0], "User login page is not displayed");
		Reporter.log("user login page is displayed", true);
		
		//change the password
		forgot.forgotPassword(data);
	}
	public WebDriver driver;
	public Actions action;
	
	@Parameters("browserName")
	@BeforeTest
	public void browserSetup(@Optional("chrome")String bname) throws InvalidBrowserValueException, InterruptedException{

		//step1 : launching a browser
		if(bname.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
			Reporter.log("empty chrome browser is launched successfully");
		}
		else if(bname.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			Reporter.log("empty firefox browser is launched successfully");
		}
		else {
			throw new InvalidBrowserValueException();
		}
		//step 2: navigating to the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ReadDataFromPropertyFile.fromPropertyFile("url"));
		String actualHomePageTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(actualHomePageTitle, ReadDataFromPropertyFile.fromPropertyFile("expectedHomePageTitle"), "Hotel Management System page is not displayed");
		Reporter.log("Hospital Management System page is displayed successfully", true);
	}

	@AfterTest
	public void browserTermination(){
		driver.quit();
	}
	
	@SuppressWarnings("serial")
	public class InvalidBrowserValueException extends Exception{
		InvalidBrowserValueException(){
			super("invalid browser name is passed");
		}
	}

}
