package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	public UpdateProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='User | Edit Profile']")
	private WebElement editProfilePage;
	
	@FindBy(name = "address")
	private WebElement addressTextarea;
	
	@FindBy(name = "city")
	private WebElement cityTextfield;
	
	@FindBy(name="gender")
	private WebElement genderDropdown;
	
	@FindBy(name = "submit")
	private WebElement updateButton;
	
	@FindBy(xpath = "//h5[contains(text(),'Your Profile updated Successfully')]")
	private WebElement profileUpdatedMsg;
	
	@FindBy(linkText = "Update your email id")
	private WebElement updateEmailIdLink;
	
	@FindBy(name = "email")
	private WebElement updateEmailIdTextfield;
	
	@FindBy(xpath = "//h5[text()='Edit Profile']")
	private WebElement updateEmailPage;
	
	@FindBy(xpath = "//h5[contains(text(),'Your email updated Successfully')]")
	private WebElement updateEmailMsg;

	public WebElement getEditProfilePage() {
		return editProfilePage;
	}

	public WebElement getAddressTextarea() {
		return addressTextarea;
	}

	public WebElement getCityTextfield() {
		return cityTextfield;
	}

	public WebElement getGenderDropdown() {
		return genderDropdown;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getProfileUpdatedMsg() {
		return profileUpdatedMsg;
	}

	public WebElement getUpdateEmailIdLink() {
		return updateEmailIdLink;
	}

	public WebElement getUpdateEmailIdTextfield() {
		return updateEmailIdTextfield;
	}

	public WebElement getUpdateEmailPage() {
		return updateEmailPage;
	}

	public WebElement getUpdateEmailMsg() {
		return updateEmailMsg;
	}
	
}
