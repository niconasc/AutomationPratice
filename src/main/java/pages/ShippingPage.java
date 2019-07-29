package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends SeleniumRobot {

    /**
     * Construtor
     */
    public ShippingPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Mapeamento
     */
    @FindBy(id = "cgv")
    private WebElement checkboxTerms;
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/button")
    private WebElement btProceedCheckout;


    /**
     * Métodos
     */
        public void continuarCompra(){
            checkboxTerms.click();
            click(btProceedCheckout);
        }

}
