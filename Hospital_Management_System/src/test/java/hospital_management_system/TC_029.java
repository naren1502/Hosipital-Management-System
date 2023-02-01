package hospital_management_system;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import pom_Repository.Home_Contact_Page;

public class TC_029 {

	@DataProvider
	public String[][] userData() {
		return ReadData.readDataExcel("testData",28);
	}
	@Test (dataProvider = "userData") 
	public void contact(String data[]){
		Home_Contact_Page contact=new Home_Contact_Page(driver);
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//click on contact major tab
		explicitWait.until(ExpectedConditions.elementToBeClickable(contact.getContactMajorTab()));
		contact.getContactMajorTab().click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, data[0], "Contact us page is not displayed");
		Reporter.log("Contact us page is displayed", true);

		//Enter the name
		contact.getFullnameTextfield().clear();
		contact.getFullnameTextfield().sendKeys(data[1]);
		String actualFullnameValue = contact.getFullnameTextfield().getAttribute("value");
		Assert.assertEquals(actualFullnameValue, data[1],"Full name is not entered properly");
		Reporter.log("Full name is entered properly",true);

		//enter the registered email id
		contact.getEmailIdTextfield().clear();
		contact.getEmailIdTextfield().sendKeys(data[2]);
		String actualEmailValue=contact.getEmailIdTextfield().getAttribute("value");
		Assert.assertEquals(actualEmailValue, data[2],"Email id is not entered properly");
		Reporter.log("Email id is entered properly",true);
		
		//enter the mobile no
		long mobileNo=(long) Double.parseDouble(data[3]);
		contact.getMobileNoTextfield().sendKeys(mobileNo+"");
		String actualNo = contact.getMobileNoTextfield().getAttribute("value");
		Assert.assertEquals(actualNo,mobileNo+"","Mobile no is not entered properly");
		Reporter.log("Mobile no is entered properly",true);
		
		//enter the description
		contact.getDescriptionTextAreaField().click();
		contact.getDescriptionTextAreaField().sendKeys(data[4]);
		String actualDescription = contact.getDescriptionTextAreaField().getAttribute("value").trim();
		Assert.assertEquals(actualDescription,data[4],"Description is not entered properly");
		Reporter.log("Description is entered properly",true);
		
		//click submit button
		contact.getSubmitButton().click();
		Alert alert = driver.switchTo().alert();
		String actualInfoMsg = alert.getText().trim();
		alert.accept();
		Assert.assertEquals(actualInfoMsg, data[5],"password is not changed");
		Reporter.log("password is changed",true);
		
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
