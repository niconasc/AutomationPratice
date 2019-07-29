package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static commons.Utils.getRandomNumber;
import static org.junit.Assert.assertEquals;

public class PaymentPage extends SeleniumRobot {

    /**
     * Mapeamento
     */
    @FindBy(xpath = "//p[@class='payment_module']/a")
    private List<WebElement> linkEscolhaPagamento;
    @FindBy(xpath = "//p[@id='cart_navigation']/button")
    private WebElement btConfirmMyOrder;
    @FindBy(xpath = "//div[@id='center_column']/div/p/strong")
    private List<WebElement> txtOrderComplete;
    @FindBy(xpath = "//div[@id='center_column']/p")
    private List<WebElement> alertOrderComplete;
    /**
     * Construtor
     */
    public PaymentPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Métodos
     */
    public PaymentPage selecionarPagamento() {
        click(linkEscolhaPagamento.get(getRandomNumber(2)));
        click(btConfirmMyOrder);
        return this;
    }

    public void validarCompraComSucesso() {
       if (txtOrderComplete.size()>0){
            assertEquals(getText(txtOrderComplete.get(0)), "Your order on My Store is complete.");

        }else {
            assertEquals(getText(alertOrderComplete.get(0)), "Your order on My Store is complete.");
        }
    }
}
