package pom_Repository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ForgotPassword_Page {
	public WebDriver driver;
	public ForgotPassword_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(partialLinkText = "Forgot Password")
	private WebElement forgotPasswordLink;

	@FindBy(name = "fullname")
	private WebElement fullnameTextfield;

	@FindBy(name = "email")
	private WebElement emailTextfield;

	@FindBy(name = "submit")
	private WebElement resetButton;

	@FindBy(id = "password")
	private WebElement passwordTextfield;

	@FindBy(id = "password_again")
	private WebElement confirmPasswordTextfield;

	@FindBy(name = "change")
	private WebElement changeButton;

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getFullnameTextfield() {
		return fullnameTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getConfirmPasswordTextfield() {
		return confirmPasswordTextfield;
	}

	public WebElement getChangeButton() {
		return changeButton;
	}
	public void forgotPassword(String data[]) {

		//click on forgotpassword link
		forgotPasswordLink.click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, data[1],"Password recovery page is not displayed");
		Reporter.log("Password recovery page is displayed",true);

		//enter the  register full name
		fullnameTextfield.clear();
		fullnameTextfield.sendKeys(data[2]);
		String actualFullnameValue = fullnameTextfield.getAttribute("value");
		Assert.assertEquals(actualFullnameValue, data[2],"Full name is not entered properly");
		Reporter.log("Full name is entered properly",true);

		//enter the registered email id
		emailTextfield.clear();
		emailTextfield.sendKeys(data[3]);
		String actualEmailValue=emailTextfield.getAttribute("value");
		Assert.assertEquals(actualEmailValue, data[3],"Email id is not entered properly");
		Reporter.log("Email id is entered properly",true);

		//click on reset button
		resetButton.click();
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, data[4],"Password reset page is not displayed");
		Reporter.log("Password reset page is displayed",true);

		//enter the password
		passwordTextfield.clear();
		passwordTextfield.sendKeys(data[5]);
		String actaualPasswordValue = passwordTextfield.getAttribute("value");
		Assert.assertEquals(actaualPasswordValue,data[5],"Password is not entered properly");
		Reporter.log("Password is entered properly",true);

		// enter ConfirmPassword textfield
		confirmPasswordTextfield.clear();
		confirmPasswordTextfield.sendKeys(data[6]);
		String actualConfirmPasswordValue =confirmPasswordTextfield.getAttribute("value");
		Assert.assertEquals(actualConfirmPasswordValue, data[6],"ConfirmPassword is mismatched");
		Reporter.log("Confirm password is entered properly", true);
		
		//click on change button
		changeButton.click();
		Alert alert = driver.switchTo().alert();
		String actualInfoMsg = alert.getText();
		alert.accept();
		Assert.assertEquals(actualInfoMsg, data[7],"password is not changed");
		Reporter.log("password is changed",true);
	}


}
