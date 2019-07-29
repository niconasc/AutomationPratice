package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPAge extends SeleniumRobot {

    /**
     * Construtor
     */
    public AddressPAge() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Mapeamento
     */
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/button")
    private WebElement btProceedCheckout;


    /**
     * Métodos
     */
        public void continuarCompra(){
            click(btProceedCheckout);
        }

}
