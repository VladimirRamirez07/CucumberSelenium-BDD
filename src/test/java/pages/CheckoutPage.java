package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By successMessage = By.className("complete-header");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        el.clear();
        el.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        el.clear();
        el.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput));
        el.clear();
        el.sendKeys(postalCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}