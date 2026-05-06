package steps;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.LoginPage;
import static org.junit.Assert.*;

public class CartSteps {

    private CartPage cartPage;
    private LoginPage loginPage;

    @Given("el usuario está logueado en la aplicación")
    public void elUsuarioEstaLogueadoEnLaAplicacion() {
        loginPage = new LoginPage(Hooks.driver);
        cartPage = new CartPage(Hooks.driver);
        loginPage.navigateTo();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("el usuario agrega el producto {string} al carrito")
    public void elUsuarioAgregaElProductoAlCarrito(String productName) {
        cartPage.addProductToCart(productName);
    }

    @When("el usuario remueve el producto {string} del carrito")
    public void elUsuarioRemuevElProductoDelCarrito(String productName) {
        cartPage.removeProductFromCart(productName);
    }

    @When("el usuario abre el carrito")
    public void elUsuarioAbreElCarrito() {
        cartPage.openCart();
    }

    @Then("el carrito debe mostrar {int} producto")
    public void elCarritoDebeMostrarProducto(int count) {
        assertEquals(count, cartPage.getCartCount());
    }

    @Then("el carrito debe estar vacío")
    public void elCarritoDebeEstarVacio() {
        assertEquals(0, cartPage.getCartCount());
    }

    @Then("el precio del producto debe ser {string}")
    public void elPrecioDelProductoDebeSer(String expectedPrice) {
        assertEquals(expectedPrice, cartPage.getProductPrice("Sauce Labs Backpack"));
    }
}