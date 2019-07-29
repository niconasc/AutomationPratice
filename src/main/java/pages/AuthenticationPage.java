package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthenticationPage extends SeleniumRobot {

    /**
     * Mapeamento
     */

    @FindBy(xpath = "//div[@class='alert alert-danger']/descendant::li")
    private List<WebElement> alertList;
    @FindBy(id = "email_create")
    private WebElement inputEmailAddress;
    @FindBy(id = "email")
    private WebElement inputEmailRegistred;
    @FindBy(id = "passwd")
    private WebElement inputPasswordRegistred;
    @FindBy(id = "SubmitCreate")
    private WebElement btCreateAnAcount;
    @FindBy(id = "SubmitLogin")
    private WebElement btSignin;
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logoImage;

    /**
     * Construtor
     */
    public AuthenticationPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Metodo
     */
    public void createAnAcount(String email) {
        sendKeys(inputEmailAddress, email);
        click(btCreateAnAcount);
    }

    public AuthenticationPage preencherLogin(String email, String password) {
        sendKeys(inputEmailRegistred, email);
        sendKeys(inputPasswordRegistred, password);
        click(btSignin);
        return this;
    }

    public void validarLoginSemSucesso(String value) {
        if (value.equalsIgnoreCase("email")) {
            assertEquals("Invalid email address.", getText(alertList.get(0)));
        } else {
            assertEquals("Invalid password.", getText(alertList.get(0)));
        }
    }

    public void voltarHome(){
        click(logoImage);
    }
}
