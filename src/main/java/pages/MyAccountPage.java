package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class MyAccountPage extends SeleniumRobot {

    /**
     * Construtor
     */
    public MyAccountPage() {
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Mapeamento
     */
    @FindBy(className = "account")
    private WebElement loggedAccount;

    @FindBy(className = "navigation_page")
    private WebElement titleMyAccount;

    /**
     * Métodos
     */

    public void checkMyAccountPage(String name){
        waitPageToLoad();
        highlightElement(loggedAccount);
        assertEquals("Usuário logado diferente do cadastrado", getText(loggedAccount), name);
    }
}
