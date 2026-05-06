package steps;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import static org.junit.Assert.*;

public class CheckoutSteps {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("el usuario tiene productos en el carrito")
    public void elUsuarioTieneProductosEnElCarrito() {
        cartPage = new CartPage(Hooks.driver);
        checkoutPage = new CheckoutPage(Hooks.driver);
        cartPage.addProductToCart("sauce-labs-backpack");
    }

    @When("el usuario hace click en Checkout")
    public void elUsuarioHaceClickEnCheckout() {
        cartPage.clickCheckout();
    }

    @When("el usuario ingresa su nombre {string}")
    public void elUsuarioIngresaSuNombre(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @When("el usuario ingresa su apellido {string}")
    public void elUsuarioIngresaSuApellido(String lastName) {
        checkoutPage.enterLastName(lastName);
    }

    @When("el usuario ingresa su código postal {string}")
    public void elUsuarioIngresaSuCodigoPostal(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
    }

    @When("el usuario hace click en Continue")
    public void elUsuarioHaceClickEnContinue() {
        checkoutPage.clickContinue();
    }

    @When("el usuario hace click en Finish")
    public void elUsuarioHaceClickEnFinish() {
        checkoutPage.clickFinish();
    }

    @Then("el usuario debe ver el mensaje {string}")
    public void elUsuarioDebeVerElMensaje(String expectedMessage) {
        assertEquals(expectedMessage, checkoutPage.getSuccessMessage());
    }

    @Then("el usuario debe ver el mensaje de error {string}")
    public void elUsuarioDebeVerElMensajeDeErrorCheckout(String expectedMessage) {
        assertEquals(expectedMessage, checkoutPage.getErrorMessage());
    }
}