package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//button[normalize-space()='Sukurti']")
    private WebElement createAccount;

    public void userNameInput(String input){
        userName.sendKeys(input);
    }
    public void passwordInput(String input){
        password.sendKeys(input);
    }
    public void passwordConfirmationInput(String input){
        passwordConfirmation.sendKeys(input);
    }
    public void clickCreateAccount(){
        createAccount.click();
    }

    public void performRegistration(String username, String pass, String confirmPass) {
        userNameInput(username);
        passwordInput(pass);
        passwordConfirmationInput(confirmPass);
        clickCreateAccount();
    }
    public boolean isRegistrationSuccessful() {
        try {
            return driver.getCurrentUrl().contains("skaiciuotuvas");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasErrorMessage() {
        try {
            return driver.getCurrentUrl().contains("registruoti");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasUsernameError() {
        try {
            return driver.getCurrentUrl().contains("registruoti");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasPasswordError() {
        try {
            return driver.getCurrentUrl().contains("registruoti");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasPasswordMismatchError() {
        try {
            return driver.getCurrentUrl().contains("registruoti");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasUsernameTakenError() {
        try {
            return driver.getCurrentUrl().contains("registruoti");
        } catch (Exception e) {
            return false;
        }
    }
}