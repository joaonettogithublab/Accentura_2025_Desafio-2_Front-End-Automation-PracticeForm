package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.ThreadLocalRandom;

public class PracticeFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    @FindBy(id = "firstName") private WebElement inputFirstName;
    @FindBy(id = "lastName") private WebElement inputLastName;
    @FindBy(id = "userEmail") private WebElement inputUserEmail;
    @FindBy(xpath = "//label[text()='Male']") private WebElement radioGenderMale;
    @FindBy(id = "userNumber") private WebElement inputMobile;
    @FindBy(id = "uploadPicture") private WebElement inputUploadPicture;
    @FindBy(id = "submit") private WebElement btnSubmit;

    // Modal de Sucesso
    @FindBy(id = "example-modal-sizes-title-lg") private WebElement modalTitle;
    @FindBy(id = "closeLargeModal") private WebElement btnCloseModal;

    private final By modalLocator = By.className("modal-content");

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    private String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(ThreadLocalRandom.current().nextInt(chars.length())));
        }
        return sb.toString();
    }

    // 5. Preencher todo o formulário com valores aleatórios
    public void preencherFormularioAleatorio() {
        String randomName = generateRandomString(6);
        String randomLastName = generateRandomString(8);
        String randomMobile = String.valueOf(ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L));

        inputFirstName.sendKeys(randomName);
        inputLastName.sendKeys(randomLastName);
        inputUserEmail.sendKeys(randomName + "@teste.com");

        // Clica no Radio Button (via JS para evitar interceção)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioGenderMale);

        inputMobile.sendKeys(randomMobile);

        // Simplificação: Focando nos campos obrigatórios para a simplicidade
    }

    // 6. O Arquivo utilizado para upload, precisa ser um .txt
    public void fazerUpload() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/files/upload.txt";
        inputUploadPicture.sendKeys(filePath);
    }

    // 7. Submter o formulário
    public void submeterFormulario() {
        // Rola até o botão de submit e clica (pode estar fora da tela)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSubmit);
    }

    // 8. Garantir que um popup foi aberto após o submit
    public String getModalTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
        return modalTitle.getText();
    }

    // 9. Fechar o popup
    public void fecharPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCloseModal));
        btnCloseModal.click();
    }
}