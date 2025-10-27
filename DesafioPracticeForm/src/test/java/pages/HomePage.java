package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void acessarCard(String nomeCard) {
        // XPath para encontrar o card Forms ou o card desejado
//         By locator = By.xpath("//h5[text()='" + nomeCard + "']/ancestor::div[@class='card mt-3 shadow-sm']");
        By locator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]");

        WebElement cardElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        // Clica via JavaScript para garantir
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cardElement);
    }

    public void acessarSubMenu(String subMenu) {
        // XPath genérico para encontrar o item de menu pelo texto
        By locator = By.xpath("//div[contains(@class, 'left-pannel')]//span[text()='" + subMenu + "']");
        WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Clica via JavaScript para garantir
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuElement);
    }
}