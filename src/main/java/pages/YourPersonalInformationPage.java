package pages;

import commons.SeleniumRobot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static commons.Utils.getRandomNumber;

public class YourPersonalInformationPage extends SeleniumRobot {

    /**
     * Mapeamento
     */

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> checkboxTitle;
    @FindBy(id = "customer_firstname")
    private WebElement inputFirstName;
    @FindBy(id = "customer_lastname")
    private WebElement inputLastName;
    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "passwd")
    private WebElement inputPassword;
    @FindBy(id = "days")
    private WebElement selectDays;
    @FindBy(id = "months")
    private WebElement selectMonth;
    @FindBy(id = "years")
    private WebElement selectYears;
    @FindBy(id = "firstname")
    private WebElement inputYourAddresFirstName;
    @FindBy(id = "lastname")
    private WebElement inputYourAddresLastName;
    @FindBy(id = "address1")
    private WebElement inputYourAddresAddress;
    @FindBy(id = "city")
    private WebElement inputYourAddresCity;
    @FindBy(id = "id_state")
    private WebElement selectYourAddresState;
    @FindBy(id = "postcode")
    private WebElement inputYourAddresPostalCode;
    @FindBy(id = "id_country")
    private WebElement inputYourAddresCountry;
    @FindBy(id = "phone_mobile")
    private WebElement inputYourAddresMobilePhone;
    @FindBy(id = "alias")
    private WebElement inputYourAddressReference;
    @FindBy(id = "submitAccount")
    private WebElement btRegister;

    private Select select;


    /**
     * Construtor
     */
    public YourPersonalInformationPage() {
        PageFactory.initElements(webDriver, this);
    }

    public static void main(String[] args) {

        System.out.println(getRandomNumber(54));
    }

    /**
     * Metodo
     */
    public void fillForm(String email, String firstName, String lastName, String password, String addres, String city) {
        checkboxTitle.get(getRandomNumber(checkboxTitle.size())).click();
        sendKeys(inputFirstName, firstName);
        sendKeys(inputLastName, lastName);
        sendKeys(inputEmail, email);
        sendKeys(inputPassword, password);
        select = new Select(selectDays);
        while (getText(select.getFirstSelectedOption()).equals("-")) {
            select.selectByIndex(getRandomNumber(select.getOptions().size()));
        }
        select = new Select(selectMonth);
        while (getText(select.getFirstSelectedOption()).equals("-")) {
            select.selectByIndex(getRandomNumber(select.getOptions().size()));
        }
        select = new Select(selectYears);
        while (getText(select.getFirstSelectedOption()).equals("-")) {
//            select.selectByValue(ano);
            select.selectByIndex(getRandomNumber(select.getOptions().size()));
        }
        sendKeys(inputYourAddresFirstName, firstName);
        sendKeys(inputYourAddresLastName, lastName);
        sendKeys(inputYourAddresAddress, addres);
        sendKeys(inputYourAddresCity, city);
        select = new Select(selectYourAddresState);
        while (getText(select.getFirstSelectedOption()).equals("-")) {
            select.selectByIndex(getRandomNumber(select.getOptions().size()));
        }
        sendKeys(inputYourAddresPostalCode, "99999");
        sendKeys(inputYourAddresMobilePhone, String.valueOf(getRandomNumber(999999999)));
        select = new Select(inputYourAddresCountry);
        if (getText(select.getFirstSelectedOption()).equals("-")) {
            select.selectByIndex(getRandomNumber(select.getOptions().size()));
        }
    }

    public void finalizarCadastro(){
        click(btRegister);
    }

}
