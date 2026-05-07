package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.CheckoutPage;
import java.time.Duration;
import static org.junit.Assert.*;

public class CheckoutSteps {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private String firstName;
    private String lastName;
    private String postalCode;

    @Given("el usuario tiene productos en el carrito")
    public void elUsuarioTieneProductosEnElCarrito() {
        cartPage = new CartPage(Hooks.driver);
        cartPage.addProductToCart("sauce-labs-backpack");
    }

    @When("el usuario hace click en Checkout")
    public void elUsuarioHaceClickEnCheckout() {
        cartPage.clickCheckout();
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("checkout-step-one"));
        checkoutPage = new CheckoutPage(Hooks.driver);
    }

    @When("el usuario ingresa su nombre {string}")
    public void elUsuarioIngresaSuNombre(String firstName) {
        this.firstName = firstName;
    }

    @When("el usuario ingresa su apellido {string}")
    public void elUsuarioIngresaSuApellido(String lastName) {
        this.lastName = lastName;
    }

    @When("el usuario ingresa su código postal {string}")
    public void elUsuarioIngresaSuCodigoPostal(String postalCode) {
        this.postalCode = postalCode;
    }

    @When("el usuario hace click en Continue")
    public void elUsuarioHaceClickEnContinue() {
        // Llenar todos los campos justo antes de continuar
        if (firstName != null) {
            WebElement el = Hooks.driver.findElement(By.id("first-name"));
            el.click();
            el.sendKeys(firstName);
        }
        if (lastName != null) {
            WebElement el = Hooks.driver.findElement(By.id("last-name"));
            el.click();
            el.sendKeys(lastName);
        }
        if (postalCode != null) {
            WebElement el = Hooks.driver.findElement(By.id("postal-code"));
            el.click();
            el.sendKeys(postalCode);
        }

        // Click en Continue
        Hooks.driver.findElement(By.id("continue")).click();

        try {
            new WebDriverWait(Hooks.driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("checkout-step-two"));
            System.out.println("✅ Navegó a: " + Hooks.driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("⚠️ Se quedó en: " + Hooks.driver.getCurrentUrl());
        }
    }

    @When("el usuario hace click en Finish")
    public void elUsuarioHaceClickEnFinish() {
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("checkout-step-two"));
        WebElement btn = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }

    @Then("el usuario debe ver el mensaje {string}")
    public void elUsuarioDebeVerElMensaje(String expectedMessage) {
        String actual = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.className("complete-header"))).getText();
        assertEquals(expectedMessage, actual);
    }

    @Then("el usuario debe ver el error de checkout {string}")
    public void elUsuarioDebeVerElMensajeDeErrorCheckout(String expectedMessage) {
        // Click Continue sin llenar campos
        Hooks.driver.findElement(By.id("continue")).click();
        String actual = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h3[data-test='error']"))).getText();
        assertEquals(expectedMessage, actual);
    }
}