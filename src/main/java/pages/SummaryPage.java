package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends SeleniumRobot {

    /**
     * Construtor
     */
    public SummaryPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Mapeamento
     */
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a")
    private WebElement btProceedCheckout;


    /**
     * Métodos
     */
        public void continuarCompra(){
            click(btProceedCheckout);
        }

}
