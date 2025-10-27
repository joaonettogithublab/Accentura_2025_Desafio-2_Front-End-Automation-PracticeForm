package stepdefinitions;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PracticeFormPage;

import static org.junit.Assert.assertEquals;

public class PracticeFormSteps {

    private WebDriver driver = BasePage.getDriver();
    private HomePage homePage;
    private PracticeFormPage practiceFormPage;

      // 2. Acessar o site https://demoqa.com/
    @Given("o usuario está na páginada DemoQa")
    public void o_usuario_está_na_páginada_DemoQa() {

        driver.get("https://demoqa.com/");
    }

     // 3. Escolher a opção Forms na página inicial; 4. Clicar no submenu Practice Form
    @When("^ele navega para Forms e clica em Practice Form$")
    public void eleNavegaParaFormsEClicaEmPracticeForm() {
        homePage = new HomePage(driver);
        homePage.acessarCard("Forms");
        homePage.acessarSubMenu("Practice Form");
        practiceFormPage = new PracticeFormPage(driver);
    }

    // 5. Preencher todo o formulário com valores aleatórios; 6. Fazer o upload
    @And("^preenche o formulário de registro com dados aleatórios e faz o upload do arquivo$")
    public void preencheOFormulárioDeRegistroComDadosAleatóriosEFazOUploadDoArquivo() {
        practiceFormPage.preencherFormularioAleatorio();
        practiceFormPage.fazerUpload();
    }

    // 7. Submeter o formulário
    @And("^submete o formulário$")
    public void submeteOFormulário() {
        practiceFormPage.submeterFormulario();
    }

    // 8. Garantir que um popup foi aberto
    @Then("^um popup de sucesso com o título \"([^\"]*)\" deve ser exibido$")
    public void umPopupDeSucessoComOTítuloDeveSerExibido(String expectedTitle) {
        String actualTitle = practiceFormPage.getModalTitle();
        assertEquals("O título do modal não corresponde ao esperado.", expectedTitle, actualTitle);
    }

    // 9. Fechar o popup
    @And("^ele fecha o popup com sucesso$")
    public void eleFechaOPopupComSucesso() {
        practiceFormPage.fecharPopup();
    }
}