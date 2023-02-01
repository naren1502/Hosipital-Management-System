package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patients_Home_Page {
	public Patients_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'user')]")
	private WebElement patientElement;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordEelement;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSpecliazationIcon() {
		return specliazationIcon;
	}

	public WebElement getPatientElement() {
		return patientElement;
	}

	public WebElement getUserNameElement() {
		return userNameElement;
	}

	public WebElement getPassWordEelement() {
		return passWordEelement;
	}

	public WebElement getUpdateProfileElement() {
		return updateProfileElement;
	}

	public WebElement getNameElement() {
		return nameElement;
	}

	public WebElement getAddressElement() {
		return addressElement;
	}

	public WebElement getCityElement() {
		return cityElement;
	}

	public WebElement getDropdownEelement() {
		return dropdownEelement;
	}

	public WebElement getUpdateEmailElement() {
		return updateEmailElement;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement updateProfileElement;
	@FindBy(xpath = "//input[@name='fname']")
	private WebElement nameElement;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressElement;
	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityElement;

	@FindBy(xpath = "//select[@name='gender']")
	private WebElement dropdownEelement;
	@FindBy(xpath = "//a[contains(text(),'email id')]")
	private WebElement updateEmailElement;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement updateButton;

	// for logout
	@FindBy(xpath = "//span[@class='username']")
	private WebElement userNameLogout;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logOut;

	public WebElement getUserNameLogout() {
		return userNameLogout;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	// for book appointment
	@FindBy(xpath = "//span[text()=' Book Appointment ']")
	private WebElement bookingAppointmentElement;
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement specliazationIcon;
	
	@FindBy(name = "doctor")
	private WebElement selectDoctorElement;
	
	@FindBy(xpath="//span[@class='username']") private WebElement userNameProfile;;
	public WebElement getUserNameProfile() {
		return userNameProfile;
	}
	@FindBy(xpath="//a[contains(text(),'My Profile')]") private WebElement myProfileElement;

	public WebElement getMyProfileElement() {
		return myProfileElement;
	}
	@FindBy(xpath="//select[@name='gender']") private WebElement genderElement;

	public WebElement getGenderElement() {
		return genderElement;
	}
	
	@FindBy(name = "appdate")
	private WebElement dateElement;
	
	@FindBy(xpath = "//input[contains(@class,'hour')]")
	private WebElement hourElement;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	@FindBy(name = "apptime")
	private WebElement Timeelement;

	public WebElement getBookingAppointmentElement() {
		return bookingAppointmentElement;
	}

	public WebElement getSelectDoctorElement() {
		return selectDoctorElement;
	}

	public WebElement getDateElement() {
		return dateElement;
	}

	public WebElement getHourElement() {
		return hourElement;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getTimeelement() {
		return Timeelement;
	}
	@FindBy(xpath="//span[text()=' Appointment History ']") private WebElement appointHistoryElement;
	public WebElement getAppointHistoryElement() {
		return appointHistoryElement;
	}
	@FindBy(xpath="//tr//td[@class='hidden-xs']") private WebElement confirmationText;

	public WebElement getConfirmationText() {
		return confirmationText;
	}
	@FindBy(xpath="//th[text()='January 2023']/../../..//td[text()='30' and @class='day']") private WebElement enterDateforAppointment;

	public WebElement getEnterDateforAppointment() {
		return enterDateforAppointment;
	}
	@FindBy(xpath="//h2[@class='StepTitle' and text()=' Book My Appointment']/..//a[contains(text(),'Book Appointment')]")private WebElement alterForBookAppointment;

	public WebElement getAlterForBookAppointment() {
		return alterForBookAppointment;
	}
}
