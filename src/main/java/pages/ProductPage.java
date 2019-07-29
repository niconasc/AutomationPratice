package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends SeleniumRobot {

    /**
     * Construtor
     */
    public ProductPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Mapeamento
     */

    @FindBy(id = "quantity_wanted")
    private WebElement inputQuantity;
    @FindBy(id = "group_1")
    private WebElement selectSize;
    @FindBy(id = "add_to_cart")
    private WebElement btAddToCart;
    @FindBy(xpath = "//div[@class='button-container']/a")
    private WebElement btProceedCheckout;

    /**
     * Metodo
     */

    public void comprarProduto(String qtde){
        sendKeys(inputQuantity, qtde);
        click(btAddToCart);
        click(btProceedCheckout);
    }
}
