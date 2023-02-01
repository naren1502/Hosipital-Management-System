package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Contact_Page {
	public Home_Contact_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[contains(@href,'contact')])[1]")
	private WebElement contactMajorTab;
	
	@FindBy(name = "fullname")
	private WebElement fullnameTextfield;
	
	@FindBy(name = "emailid")
	private WebElement emailIdTextfield;
	
	@FindBy(name = "mobileno")
	private WebElement mobileNoTextfield;
	
	@FindBy(name = "description")
	private WebElement descriptionTextAreaField;
	
	@FindBy(name = "submit")
	private WebElement submitButton;

	public WebElement getContactMajorTab() {
		return contactMajorTab;
	}

	public WebElement getFullnameTextfield() {
		return fullnameTextfield;
	}

	public WebElement getEmailIdTextfield() {
		return emailIdTextfield;
	}

	public WebElement getMobileNoTextfield() {
		return mobileNoTextfield;
	}

	public WebElement getDescriptionTextAreaField() {
		return descriptionTextAreaField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
}
