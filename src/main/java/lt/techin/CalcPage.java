package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CalcPage extends BasePage{
    public CalcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement firstNumber;

    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement secondNumber;

    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement operationDropdown;

    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement calculateButton;

    @FindBy(partialLinkText = "Logout")
    private WebElement logOut;



    public void calculate(String first, String operation, String second) {

        firstNumber.sendKeys(first);

        new Select(operationDropdown).selectByValue(operation);

        secondNumber.sendKeys(second);

        calculateButton.click();
    }

    public void clickLogout(){
        logOut.click();

    }

    public boolean resultContains(String expectedResult) {
        return driver.getPageSource().contains(expectedResult);
    }

    public boolean isLoggedOut() {
        return driver.getPageSource().contains("Prisijungimas") ||
                driver.getPageSource().contains("Prisijungti") ||
                driver.getPageSource().contains("Internetinis skaičiuotuvas");
    }
}
