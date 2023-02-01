package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	public ChangePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "cpass")
	private WebElement currentPasswordTextfield;
	
	@FindBy(name = "npass")
	private WebElement newPasswordTextfield;
	
	@FindBy(name = "cfpass")
	private WebElement confirmPasswordTextfield;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	@FindBy(xpath = "//p[contains(text(),'Password Changed Successfully !!')]")
	private WebElement passwordChangeSuccessMsg;
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement profileDropdown;
	
	@FindBy(partialLinkText = "Change Password")
	private WebElement changePasswordOption;
	
	@FindBy(partialLinkText = "My Profile")
	private WebElement myProfileOption;
	
	public WebElement getMyProfileOption() {
		return myProfileOption;
	}
	@FindBy(xpath = "//h1[text()='User | Change Password']")
	private WebElement changePasswordPage;
	
	public WebElement getChangePasswordPage() {
		return changePasswordPage;
	}

	public WebElement getProfileDropdown() {
		return profileDropdown;
	}

	public WebElement getChangePasswordOption() {
		return changePasswordOption;
	}
	@FindBy(xpath = "//p[contains(text(),'Old Password not match !!')]")
	private WebElement oldPasswordMismatchMsg;

	public WebElement getCurrentPasswordTextfield() {
		return currentPasswordTextfield;
	}

	public WebElement getNewPasswordTextfield() {
		return newPasswordTextfield;
	}

	public WebElement getConfirmPasswordTextfield() {
		return confirmPasswordTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getPasswordChangeSuccessMsg() {
		return passwordChangeSuccessMsg;
	}

	public WebElement getOldPasswordMismatchMsg() {
		return oldPasswordMismatchMsg;
	}
	
	
}
