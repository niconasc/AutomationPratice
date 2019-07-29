package pages;

import commons.SeleniumRobot;
import commons.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static commons.Utils.*;

public class IndexPage extends SeleniumRobot {

    /**
     * Construtor
     */
    public IndexPage() {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Mapeamento
     */

    @FindBy(className = "login")
    private WebElement linkSign;
    @FindBy(xpath = "//ul[@id='homefeatured']/descendant::div[@class='product-container']")
    private List<WebElement> listaAnuncios;

    /**
     * Metodo
     */

    public void aguardarCarregamento() {
        waitPageToLoad();
        isDisplayed(linkSign);
    }

    public void clickSign(){
        click(linkSign);
    }

    public void clicarAnuncio(){
        if (listaAnuncios.size()>0){
            click(listaAnuncios.get(getRandomNumber(4)));
        }
    }

}
