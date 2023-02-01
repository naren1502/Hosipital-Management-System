package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Home_Page {
	public Admin_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Click Here' and contains(@href,'admin')]")
	private WebElement adminElement;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordEelement;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'Patients') and @class='title']/..//i[@class='icon-arrow']")
	private WebElement patientsElement;

	@FindBy(xpath = "//span[contains(text(),'Manage Patients')]")
	private WebElement managePatients;

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement dashboardElement;

	@FindBy(xpath = "//span[text()=' Users ']")
	private WebElement usersElement;

	@FindBy(xpath = "//span[text()=' Manage Users ']")
	private WebElement manageUsersElement;

	public WebElement getUsersElement() {
		return usersElement;
	}

	public WebElement getManageUsersElement() {
		return manageUsersElement;
	}

	@FindBy(xpath = "//tr//td[@class='hidden-xs' and text()='Naveen']/..//a[@tooltip='Remove']")
	private WebElement deleteUser;

	public WebElement getDeleteUser() {
		return deleteUser;
	}

	@FindBy(xpath = "//h2[text()='Manage Users']/..//a[contains(@href,'manage-users')]")
	private WebElement alterManageUserElement;

	public WebElement getAlterManageUserElement() {
		return alterManageUserElement;
	}

	public WebElement getPatientsElement() {
		return patientsElement;
	}

	public WebElement getManagePatients() {
		return managePatients;
	}

	public WebElement getDashboardElement() {
		return dashboardElement;
	}

	public WebElement getAlterManageDoctorElement() {
		return alterManageDoctorElement;
	}

	@FindBy(xpath = "//h2[text()='Manage Doctors']/..//a[contains(text(),'Total Doctors')]")
	private WebElement alterManageDoctorElement;

	public WebElement getAdminElement() {
		return adminElement;
	}

	public WebElement getUserNameElement() {
		return userNameElement;
	}

	public WebElement getPassWordEelement() {
		return passWordEelement;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(xpath = "//span[(text()=' Doctors ')]")
	private WebElement doctorsElement;

	@FindBy(xpath = "//span[(text()=' Doctor Specialization ')]")
	private WebElement docSpecialization;

	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement enterSpecialization;

	@FindBy(name = "submit")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getDoctorsElement() {
		return doctorsElement;
	}

	public WebElement getDocSpecialization() {
		return docSpecialization;
	}

	public WebElement getEnterSpecialization() {
		return enterSpecialization;
	}

	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement addDoctorElement;
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement selectDropdown;

	public WebElement getAddDoctorElement() {
		return addDoctorElement;
	}

	public WebElement getSelectDropdown() {
		return selectDropdown;
	}

	@FindBy(xpath = "//input[@name='docname']")
	private WebElement docNameElement;
	@FindBy(xpath = "//textarea[@name='clinicaddress']")
	private WebElement docAddressElement;
	@FindBy(xpath = "//input[@name='docfees']")
	private WebElement docFeesElement;
	@FindBy(xpath = "//input[@name='doccontact']")
	private WebElement docContactElement;
	@FindBy(xpath = "//input[@name='docemail']")
	private WebElement docEmailElement;
	@FindBy(xpath = "//input[@name='npass']")
	private WebElement docPasswordElement;
	@FindBy(xpath = "//input[@name='cfpass']")
	private WebElement docConfirmPassword;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement docSubmiButton;

	public WebElement getDocNameElement() {
		return docNameElement;
	}

	public WebElement getDocAddressElement() {
		return docAddressElement;
	}

	public WebElement getDocFeesElement() {
		return docFeesElement;
	}

	public WebElement getDocContactElement() {
		return docContactElement;
	}

	public WebElement getDocEmailElement() {
		return docEmailElement;
	}

	public WebElement getDocPasswordElement() {
		return docPasswordElement;
	}

	public WebElement getDocConfirmPassword() {
		return docConfirmPassword;
	}

	public WebElement getDocSubmiButton() {
		return docSubmiButton;
	}

	// for error message
	@FindBy(xpath = "//span[@id='email-availability-status']")
	private WebElement errorMessageElement;

	public WebElement getErrorMessageElement() {
		return errorMessageElement;
	}

	// for edit doctor details
	@FindBy(xpath = "//tr //td[text()='Prajna']/..//a[@tooltip='Edit']")
	private WebElement editDoctorElement;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement updateElement;
	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement manageDoctorElement;

	public WebElement getEditDoctorElement() {
		return editDoctorElement;
	}

	public WebElement getUpdateElement() {
		return updateElement;
	}

	public WebElement getManageDoctorElement() {
		return manageDoctorElement;
	}

	@FindBy(xpath = "//h5[contains(@style,'color: green')]")
	private WebElement updateTextElement;

	public WebElement getUpdateTextElement() {
		return updateTextElement;
	}

	public WebElement getDeleteElement() {
		return deleteElement;
	}

	@FindBy(xpath = "//tr//td[text()='Prajna']/..//i[contains(@class,'fa fa-white')]")
	private WebElement deleteElement;
	@FindBy(xpath = "//tr//td[text()='bone Specialist']/..//a[@tooltip='Remove']")
	private WebElement deleteSpclElement;

	public WebElement getDeleteSpclElement() {
		return deleteSpclElement;
	}

	@FindBy(xpath = "//tr//td[text()='bone Specialist']/..//i[@class='fa fa-pencil']")
	private WebElement editDocSpclElement;

	public WebElement getEditDocSpclElement() {
		return editDocSpclElement;
	}

	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement enterDocSpclElement;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement updateDocSpclButton;

	public WebElement getEnterDocSpclElement() {
		return enterDocSpclElement;
	}

	public WebElement getUpdateDocSpclButton() {
		return updateDocSpclButton;
	}

}
