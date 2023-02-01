package pom_Repository;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Patient_Register_Page {
	public WebDriver driver;
	public WebDriverWait explicitWait;
	public Patient_Register_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "full_name")
	private WebElement fullnameTextfield;

	@FindBy(name = "address")
	private WebElement addressTextfield;

	@FindBy(name = "city")
	private WebElement cityTextfield;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleGenderRadioButton;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleGenderRadioButton;

	@FindBy(id = "email")
	private WebElement emailTextfield;

	@FindBy(id = "password")
	private WebElement passwordTextfield;

	@FindBy(id = "password_again")
	private WebElement confirmPasswordTextfield;

	@FindBy(id = "agree")
	private WebElement agreeCheckbox;

	@FindBy(id = "submit")
	private WebElement submitButton;

	@FindBy(xpath = "//h2[text()='HMS | Patient Registration']")
	private WebElement registerPage;

	@FindBy(id = "user-availability-status1")
	private WebElement emailAvailabiltyMsg;

	public WebElement getFullnameTextfield() {
		return fullnameTextfield;
	}

	public WebElement getAddressTextfield() {
		return addressTextfield;
	}

	public WebElement getCityTextfield() {
		return cityTextfield;
	}

	public WebElement getFemaleGenderRadioButton() {
		return femaleGenderRadioButton;
	}

	public WebElement getMaleGenderRadioButton() {
		return maleGenderRadioButton;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getConfirmPasswordTextfield() {
		return confirmPasswordTextfield;
	}

	public WebElement getAgreeCheckbox() {
		return agreeCheckbox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getRegisterPage() {
		return registerPage;
	}

	public WebElement getEmailAvailabiltyMsg() {
		return emailAvailabiltyMsg;
	}
	@FindBy(partialLinkText = "Create an account")
	private WebElement createAccountLink;

	

	public void register(String userData[]) {
		explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//click on createAccount link
		createAccountLink.click();
		String actualRegisterPage = registerPage.getText().trim();
		Assert.assertEquals(actualRegisterPage, userData[1],"Register page is not displayed");
		Reporter.log("register page is displayed",true);

		//enter the full name
		fullnameTextfield.clear();
		fullnameTextfield.sendKeys(userData[2]);
		String actualFullnameValue = fullnameTextfield.getAttribute("value");
		Assert.assertEquals(actualFullnameValue, userData[2],"Full name is not entered properly");
		Reporter.log("Full name is entered properly",true);

		//enter the address
		addressTextfield.clear();
		addressTextfield.sendKeys(userData[3]);
		String actualAddressValue=addressTextfield.getAttribute("value");
		Assert.assertEquals(actualAddressValue, userData[3],"Address is not entered properly");
		Reporter.log("Address is entered properly",true);

		//enter the city
		cityTextfield.clear();
		cityTextfield.sendKeys(userData[4]);
		String actualCityValue=cityTextfield.getAttribute("value");
		Assert.assertEquals(actualCityValue, userData[4],"City value is not entered properly");
		Reporter.log("City value is entered properly",true);

		//selecting gender
		if(userData[5].equalsIgnoreCase("male")) {
			maleGenderRadioButton.click();
			boolean check = maleGenderRadioButton.isEnabled();
			Assert.assertEquals(check, true,"Male radio button is not clicked");
			Reporter.log("Male radio button is clicked",true);
		}
		else {
			femaleGenderRadioButton.click();
			boolean check = femaleGenderRadioButton.isEnabled();
			Assert.assertEquals(check, true,"Female radio button is not clicked");
			Reporter.log("Female radio button is clicked",true);
		}

		//enter the email
		emailTextfield.clear();
		emailTextfield.sendKeys(userData[6]);
		String actualEmailValue=emailTextfield.getAttribute("value");
		Assert.assertEquals(actualEmailValue, userData[6],"Email id is not entered properly");
		Reporter.log("Email id is entered properly",true);
		emailTextfield.sendKeys(Keys.TAB);
		explicitWait.until(ExpectedConditions.visibilityOf(emailAvailabiltyMsg));
		String actualEmailAvailabiltyMsg = emailAvailabiltyMsg.getText().trim();
		Assert.assertEquals(actualEmailAvailabiltyMsg, userData[7],"Email id is not available");
		Reporter.log("Email id is available",true);

		//enter the password
		passwordTextfield.clear();
		passwordTextfield.sendKeys(userData[8]);
		String actaualPasswordValue = passwordTextfield.getAttribute("value");
		Assert.assertEquals(actaualPasswordValue, userData[8],"Password is not entered properly");
		Reporter.log("Password is entered properly",true);

		// enter ConfirmPassword textfield
		confirmPasswordTextfield.clear();
		confirmPasswordTextfield.sendKeys(userData[9]);
		String actualConfirmPasswordValue =confirmPasswordTextfield.getAttribute("value");
		Assert.assertEquals(actualConfirmPasswordValue, userData[9],"ConfirmPassword is mismatched");
		Reporter.log("Confirm password is entered properly", true);
		
		//check the i agree checkbox
		if(!agreeCheckbox.isSelected()) {
			agreeCheckbox.click();
			boolean check = agreeCheckbox.isEnabled();
			Assert.assertEquals(check, true,"I agree checkbox is not checked");
			Reporter.log("I agree checkbox is checked",true);
		}
		else {
			boolean check = agreeCheckbox.isEnabled();
			Assert.assertEquals(check, true,"I agree checkbox is not checked");
			Reporter.log("I agree checkbox is checked",true);
		}
		
		//click on submit button
		explicitWait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
		Alert alert = driver.switchTo().alert();
		String actualInfoMsg = alert.getText();
		alert.accept();
		Assert.assertEquals(actualInfoMsg, userData[10],"patient is not registered");
		Reporter.log("patient is registered",true);

	}
}
