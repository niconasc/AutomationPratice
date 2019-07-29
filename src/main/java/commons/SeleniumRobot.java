package commons;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class SeleniumRobot {

    /**
     * Variáveis
     * propertiesManager
     * webDriver
     * wait
     * url
     */
    public static PropertiesManager propertiesManager = new PropertiesManager();
    protected static WebDriver webDriver;
    private static WebDriverWait wait;
    private static String url = propertiesManager.getProp("src/main/resources/properties/web.properties","url");


    /**
     * Métodos
     */

    /**
     * Inicializa o navegador escolhido
     */
    @Before
    public WebDriver inicializarNavegador(String tipoDriver) {
        switch (tipoDriver.toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.getInstance(FIREFOX).setup();
                webDriver = new FirefoxDriver();
                break;
            case "OPERA":
                WebDriverManager.getInstance(OPERA).setup();
                webDriver = new OperaDriver();
                break;
            case "EDGE":
                WebDriverManager.getInstance(EDGE).setup();
                webDriver = new EdgeDriver();
                break;
            case "IE":
                WebDriverManager.getInstance(IEXPLORER).setup();
                webDriver = new EdgeDriver();
                break;
            case "HEADLESS":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                WebDriverManager.getInstance(CHROME).setup();
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "CHROME":
            default:
                WebDriverManager.getInstance(CHROME).setup();
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);
        String sistemaOperacional = System.getProperty("os.name");

        if (sistemaOperacional.toLowerCase().contains("mac")) {
            webDriver.manage().window().fullscreen();
        } else {
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }


    /**
     * Rerotna o driver em um método publico
     */
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Acessa URL passada no parâmetro
     * @param url
     */
    public static void goToUrl(String url) {
        webDriver.get(url);
    }

    /**
     * Aguarde presença do elemento
     * @param xpath
     */
    public static void waitPresenceOfElementLocated(String xpath) {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * Aguarda o elemento ficar visível na tela
     */
    public static void waitToBeVisible(WebElement element) {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Aguarda o elemento ficar disponível para click
     */
    public static void waitToBeClickable(WebElement element) {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Aguarda o elemento ficar visível na tela
     */
    public static void waitAlertIsPresent() {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Realiza um Scroll até o elemento e aguarda até que ele esteja visível
     */
    public static void moveAndWaitToBeClickable(WebElement element) {
        scrollToElement(element);
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clica em um elemento utilizando JavaScript
     */
    public static void clicarElementoJS(WebElement elemento) {
        waitToBeVisible(elemento);
        JavascriptExecutor executor = (JavascriptExecutor) SeleniumRobot.getWebDriver();
        executor.executeScript("arguments[0].click();", elemento);
    }

    /**
     * Executa um comando em JavaScript apartir da String passada
     */
    public static String executeJS(String script) {
        JavascriptExecutor executor = (JavascriptExecutor) SeleniumRobot.getWebDriver();
        return executor.executeScript(script).toString();
    }

    /**
     * Aguarda o carregamento total da tela
     */
    public static void waitPageToLoad() {
        while (!executeJS("return document.readyState").equals("complete")) {
            System.out.println(executeJS("return document.readyState"));
        }
    }

    /**
     * Atualiza a página
     */
    public static void atualizarPagina() {
        webDriver.navigate().refresh();
    }

    /**
     * Realiza Scroll até o elemento passado através de JavaScript
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
    }

    /**
     * Realiza Scroll da Page
     * Para scroll down utilizar valores positivos (Exemplo 250)
     * Para scroll up utilizar valores negativos (Exemplo -250)
     */
    public static void scrollPage(String value) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + value + ")");
        ;
    }

    /**
     * Valida se existe um elemento na parte web
     */
    public static boolean existElementWeb(String xpath) {
        return getWebDriver().findElements(By.xpath(xpath)).size() != 0;
    }

    /**
     * valida se o elemento existe na página
     */
    public static boolean existElementWeb(By by) {
        return getWebDriver().findElements(by).size() != 0;
    }

    /**
     * O método faz uma simulação de double click
     */
    public void doubleClickWeb(WebElement element) {
        Actions DoubleClick = new Actions(getWebDriver());
        highlightElement(element);
        DoubleClick.doubleClick(element).perform();
    }

    /**
     * Move até o elemento esperado
     */
    public static void moveToElementWeb(WebElement element) {
        Actions MoveToElement = new Actions(getWebDriver());
        MoveToElement.moveToElement(element).perform();
    }

    /**
     * Espera o Spinner ficar visível e aguarda o mesmo ficar invisível
     */
    public static void waitInvisibleSpinnerState() {
        String xpath = "//div[@class='slds-spinner_container slds-is-fixed ng-star-inserted']";

        SeleniumRobot.waitToBeVisible(SeleniumRobot.getWebDriver().findElement(By.
                xpath(xpath)));
        SeleniumRobot.waitToBeVisible(SeleniumRobot.getWebDriver().findElement(By.
                xpath(xpath)));
    }

    /**
     * confirma popup browser
     */
    public static void confirmarPopup() {
        waitAlertIsPresent();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Fecha o navegador e o driver
     */
    public static void quitDriver() {
        webDriver.quit();
    }

    /**
     * Fecha o navegador e o driver
     */
    public static void closeDriver() {
        webDriver.close();
    }

    /**
     * Alterna entre janela/aba
     */
    public static void alterarEntreJanelas(int window_number) {
        Utils.setThreadSleep(3000);
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(window_number));

    }

    public static void voltarTela() {
        webDriver.navigate().back();
    }

    public static ArrayList<String> getHandles() {
        Utils.setThreadSleep(3000);
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        return tabs;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * pega o texto do pop-up
     */
    public String pegarTextoPopup() {
        return webDriver.switchTo().alert().getText();
    }

    /**
     * aguarda até que o elemento esteja invisível
     */
    public void waitInvisibilityOf(WebElement element) {
        wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * aguarda até que o título esteja visível
     */
    public void waitTextTitle(String title) {
        wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.titleIs(title));
    }

    /**
     * Método para selecionar por texto em uma combo-box
     */
    protected void selectByVisibleText(WebElement element, String texto) {
        waitToBeVisible(element);
        highlightElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(texto);
    }

    /**
     * Método para retornar o texto da primeira opção selecionada
     */
    protected String getTextFirstSelected(WebElement elemento) {
        waitToBeVisible(elemento);
        Select select = new Select(elemento);
        WebElement element = select.getFirstSelectedOption();
        return element.getText();
    }

    /**
     * Método para selecionar pelo indice
     */
    protected void selectByIdex(WebElement element, int texto) {
        waitToBeVisible(element);
        Select select = new Select(element);
        highlightElement(element);
        select.selectByIndex(texto);
    }

    /**
     * Método para selecionar por valor em uma combo-box
     */
    protected void selectByValue(WebElement element, String texto) {
        waitToBeVisible(element);
        Select select = new Select(element);
        highlightElement(element);
        select.selectByValue(texto);
    }

    /**
     * Fecha a presente aba através de comando JavaScript
     */
    public void fecharAba() {
        executeJS("window.close();");
    }

    /**
     * Aguarda disponibilidade de click no elemento e clica
     */
    public void click(WebElement element) {
        waitToBeClickable(element);
        highlightElement(element);
        element.click();
    }

    /**
     * Aguarda disponibilidade do elemento e escreve o texto no elemento
     */
    public void sendKeys(WebElement element, String text) {
        waitToBeVisible(element);
        waitToBeClickable(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Aguarda disponibilidade do elemento e realiza um comando de teclado
     */
    public void sendKeys(WebElement element, Keys text) {
        waitToBeVisible(element);
        waitToBeClickable(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Aguarda disponibilidade do elemento e apaga o conteúdo escrito
     */
    public void clear(WebElement element) {
        waitToBeVisible(element);
        waitToBeClickable(element);
        highlightElement(element);
        element.clear();
    }

    /**
     * Aguarda disponibilidade do elemento e retorna o texto
     */
    public String getText(WebElement element) {
        waitToBeVisible(element);
        return element.getText();
    }

    /**
     * Valida se o elemento está selecionado
     */
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Valida se o elemento está visível
     */
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Valida se o elemento está ativo
     */
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Aguarda disponibilidade do elemento e retorna o tamanho da lista
     */
    public Integer size(List<WebElement> element) {
        waitToBeVisible(element.get(0));
        return element.size();
    }

    /**
     * Aguarda disponibilidade do elemento e retorna o valor do atributo
     */
    public String getAttribute(WebElement element, String atribute) {
        waitToBeVisible(element);
        return element.getAttribute(atribute);
    }

    /**
     * Move o scroll até o elemento e contorna o elemento com linha vermelha
     */
    public void highlightElement(WebElement element) {
        scrollToElement(element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.border='2px solid red'", element);
    }

}

