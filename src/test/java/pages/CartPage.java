package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName) {
        String buttonId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(buttonId)).click();
    }

    public void removeProductFromCart(String productName) {
        String buttonId = "remove-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(buttonId)).click();
    }

    public void openCart() {
        click(cartIcon);
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(
            "//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']"
        )).getText();
    }

    public void clickCheckout() {
        click(checkoutButton);
    }
}