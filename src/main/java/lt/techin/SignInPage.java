package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement createNewAccount;

    @FindBy(xpath = "//input[@placeholder='Prisijungimo vardas']")
    private WebElement signInName;

    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    private WebElement signInPassword;

    @FindBy(xpath = "//button[normalize-space()='Prisijungti']")
    private  WebElement signIn;


    public void clickCreateNewAccount(){
        createNewAccount.click();
    }

    public void signInNameInput(String input){
        signInName.sendKeys(input);
    }
    public void signInPasswordInput(String input){
        signInPassword.sendKeys(input);
    }
    public void clickSignIn(){
        signIn.click();
    }

    public void performSignIn(String username, String password){
        signInNameInput(username);
        signInPasswordInput(password);
        clickSignIn();
    }

    public boolean isSignInSuccessful(){
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Logout')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasSignInError(){
        return driver.getCurrentUrl().contains("prisijungti");
    }
}

