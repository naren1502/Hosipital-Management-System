package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctors_Home_Page {
	public Doctors_Home_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[@class='text list_1_of_2'])[2]//a") private WebElement doctorElement;
	@FindBy(xpath="//input[@name='username']") private WebElement userNameElement;
	@FindBy(xpath="//input[@name='password']") private WebElement passWordEelement;
	@FindBy(xpath="//button[@name='submit']") private WebElement loginButton;
	public WebElement getUserNameElement() {
		return userNameElement;
	}
	public WebElement getPassWordEelement() {
		return passWordEelement;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	@FindBy(xpath="//span[contains(text(),'Patients')]") private WebElement patientElement;
	@FindBy(xpath="//span[contains(text(),' Add Patient')]") private WebElement addPatientElement;
	public WebElement getDoctorElement() {
		return doctorElement;
	}
	public WebElement getPatientElement() {
		return patientElement;
	}
	public WebElement getAddPatientElement() {
		return addPatientElement;
	}
	@FindBy(xpath="//input[@name='patname']") private WebElement addName;
	@FindBy(xpath="//input[@name='patcontact']") private WebElement addContact;
	@FindBy(xpath="//input[@name='patemail']") private WebElement addEmail;
	@FindBy(xpath="//label[contains(text(),'Female')]") private WebElement addGender;
	public WebElement getAddName() {
		return addName;
	}
	public WebElement getAddContact() {
		return addContact;
	}
	public WebElement getAddEmail() {
		return addEmail;
	}
	public WebElement getAddGender() {
		return addGender;
	}
	public WebElement getAddAddress() {
		return addAddress;
	}
	@FindBy(xpath="//textarea[@name='pataddress']") private WebElement addAddress;
	@FindBy(xpath="//input[@name='patage']") private WebElement addAge;
	@FindBy(xpath="//button[@name='submit']")private WebElement addButton;
	public WebElement getAddAge() {
		return addAge;
	}
	public WebElement getAddButton() {
		return addButton;
	}

	@FindBy(xpath=" //span[contains(text(),'Manage Patient')] ") private WebElement managePatient;
	@FindBy(xpath="(//tr//i[@class='fa fa-edit'])[7]") private WebElement editDetails;
	public WebElement getManagePatient() {
		return managePatient;
	}
	public WebElement getEditDetails() {
		return editDetails;
	}
	@FindBy(xpath="//textarea[@name='medhis']")private WebElement medicalHistoryElement;
	@FindBy(xpath="//button[@id='submit']") private WebElement updateElement;
	public WebElement getMedicalHistoryElement() {
		return medicalHistoryElement;
	}
	public WebElement getUpdateElement() {
		return updateElement;
	}
	@FindBy(xpath = "//label[contains(text(),'Gender')]/..//label[contains(text(),'Male')]")
	private WebElement radioButton;
	
	public WebElement getRadioButton() {
		return radioButton;
	}
	@FindBy(xpath="//span[contains(text(),'Search')]") private WebElement searchPatient;
	@FindBy(xpath="//input[@id='searchdata']") private WebElement searchByEnteringName;
	public WebElement getSearchPatient() {
		return searchPatient;
	}
	public WebElement getSearchByEnteringName() {
		return searchByEnteringName;
	}
	@FindBy(xpath="//button[@id='submit']") private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
	}

}
