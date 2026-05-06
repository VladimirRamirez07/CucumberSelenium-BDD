package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("el usuario está en la página de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.navigateTo();
    }

    @When("el usuario ingresa el usuario {string}")
    public void elUsuarioIngresaElUsuario(String username) {
        loginPage.enterUsername(username);
    }

    @When("el usuario ingresa la contraseña {string}")
    public void elUsuarioIngresaLaContrasena(String password) {
        loginPage.enterPassword(password);
    }

    @When("el usuario hace click en el botón login")
    public void elUsuarioHaceClickEnElBotonLogin() {
        loginPage.clickLoginButton();
    }

    @Then("el usuario debe ver la página de productos")
    public void elUsuarioDebeVerLaPaginaDeProductos() {
        assertTrue("No se redirigió a la página de productos",
            loginPage.isOnProductsPage());
    }

    @Then("el usuario debe ver el mensaje de error {string}")
    public void elUsuarioDebeVerElMensajeDeError(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}