package steps;

import commons.PropertiesManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.*;

import java.io.IOException;

import static commons.Utils.getRandomNumber;
import static commons.Utils.writeTxtFile;

public class AutomationPraticeSteps {

    private String randomNumber = String.valueOf(getRandomNumber(999999999));
    private String email = "automationtest" + randomNumber + "@testador.com";
    private String password = "teste123";
    private String emailUltimoCadastro = PropertiesManager.getProp("src/main/resources/lastLogin/lastLogin.txt", "email");
    private String senhaUltimoCadastro = PropertiesManager.getProp("src/main/resources/lastLogin/lastLogin.txt", "senha");
    private String firstName = "AutomationTest ";
    private String lastName = "da Silva";
    private String addres = "wonderfull world avenue";
    private String city = "Sao Paulo";

    private IndexPage indexPage = new IndexPage();
    private AuthenticationPage authenticationPage = new AuthenticationPage();
    private YourPersonalInformationPage yourPersonalInformationPage = new YourPersonalInformationPage();
    private MyAccountPage myAccountPage = new MyAccountPage();
    private ProductPage productPage = new ProductPage();
    private SummaryPage summaryPage = new SummaryPage();
    private AddressPAge addressPAge = new AddressPAge();
    private ShippingPage shippingPage = new ShippingPage();
    private PaymentPage paymentPage = new PaymentPage();


    @Dado("que eu acesse o site")
    public void queEuAcesseSite() throws IOException {
        indexPage.aguardarCarregamento();
    }

    @E("clicar em registrar")
    public void clicarEmRegistrar() {
        indexPage.clickSign();
        authenticationPage.createAnAcount(email);
    }

    @Quando("eu preencher os campos do cadastro")
    public void euPreencherOsCamposDoCadastro() {
        yourPersonalInformationPage.fillForm(email, firstName, lastName, password, addres, city);

    }

    @Então("o cadastro será efetuado com sucesso")
    public void oCadastroSeraEfetuadoComSucesso() throws IOException {
        yourPersonalInformationPage.finalizarCadastro();
        myAccountPage.checkMyAccountPage(firstName.concat(lastName));
        writeTxtFile("src/main/resources/lastLogin/lastLogin.txt", "email = ".concat(email), "senha = ".concat(password));
    }

    @Quando("eu preencher os campos de login com usuário {string}")
    public void euPreencherOsCamposDeLoginComUsuario(String usuario) throws IOException {
        indexPage.clickSign();
        switch (usuario) {
            case "válido":
                authenticationPage.preencherLogin(emailUltimoCadastro, senhaUltimoCadastro);
                break;
            case "e-mail inválido":
                authenticationPage.preencherLogin("aaa", senhaUltimoCadastro);
                break;
            case "senha inválida":
                authenticationPage.preencherLogin(emailUltimoCadastro, "1111");
                break;
        }

    }


    @Então("o sistema deve {string}")
    public void oSistemaDeve(String resultadoEsperado) {
        switch (resultadoEsperado) {
            case "permitir o login":
                myAccountPage.checkMyAccountPage(firstName.concat(lastName));
                break;
            case "bloquear o login: e-mail":
                authenticationPage.validarLoginSemSucesso("email");
                break;
            case "bloquear o login: senha":
                authenticationPage.validarLoginSemSucesso("senha");
                break;
        }
    }

    @Dado("que eu esteja logado")
    public void queEuEstejaLogado() throws IOException {
        indexPage.clickSign();
        authenticationPage.createAnAcount(email);
        yourPersonalInformationPage.fillForm(email, firstName, lastName, password, addres, city);
        yourPersonalInformationPage.finalizarCadastro();
        myAccountPage.checkMyAccountPage(firstName.concat(lastName));
        writeTxtFile("src/main/resources/lastLogin/lastLogin.txt", "email = ".concat(email), "senha = ".concat(password));
        authenticationPage.voltarHome();
    }

    @Quando("eu realizar a compra")
    public void euRealizarACompra() {
        indexPage.clicarAnuncio();
        productPage.comprarProduto("1");
        summaryPage.continuarCompra();
        addressPAge.continuarCompra();
        shippingPage.continuarCompra();
    }

    @Então("a compra é finalizada com sucesso")
    public void aCompraEFinalizadaComSucesso() {
        paymentPage.selecionarPagamento();
        paymentPage.validarCompraComSucesso();
    }
}
