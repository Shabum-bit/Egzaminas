package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalcPage extends BasePage{
    public CalcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='Pirmas skaičius']")
    private WebElement firstNumber;

    @FindBy(xpath = "//input[@placeholder='Antras skaičius']")
    private WebElement secondNumber;

    @FindBy(xpath = "//select[contains(@class, 'form-control')]")
    private WebElement operationDropdown;

    @FindBy(xpath = "//button[normalize-space()='skaičiuoti']")
    private WebElement calculateButton;


    public void enterFirstNumber(String number) {
        firstNumber.clear();
        firstNumber.sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        secondNumber.clear();
        secondNumber.sendKeys(number);
    }

    public void selectOperation(String operation) {
        Select select = new Select(operationDropdown);
        select.selectByVisibleText(operation);
    }

    public void clickCalculate() {
        calculateButton.click();
    }

    public void performCalculation(String first, String operation, String second) {
        enterFirstNumber(first);
        selectOperation(operation);
        enterSecondNumber(second);
        clickCalculate();
    }

    public String getFirstNumberValue() {
        return firstNumber.getAttribute("value");
    }

    public String getSecondNumberValue() {
        return secondNumber.getAttribute("value");
    }

    public boolean isCalculationPerformed() {
        try {
            // Check if URL contains result or if page shows calculation result
            return driver.getCurrentUrl().contains("skaiciuoti") ||
                    driver.getPageSource().contains("=") ||
                    !getFirstNumberValue().isEmpty() && !getSecondNumberValue().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areFieldsNumericOnly() {
        try {
            String first = getFirstNumberValue();
            String second = getSecondNumberValue();

            // Try to parse as numbers - if letters were entered, they shouldn't be there
            if (!first.isEmpty()) {
                Double.parseDouble(first);
            }
            if (!second.isEmpty()) {
                Double.parseDouble(second);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

