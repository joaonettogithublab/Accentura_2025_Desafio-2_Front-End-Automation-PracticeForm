package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BasePage {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initialize() {
        if (driver == null) {
            // --- Configuração do ChromeDriver (Recuperação Online) ---
            // Usa o WebDriverManager para baixar o ChromeDriver automaticamente
            //WebDriverManager.chromedriver().setup();
            //WebDriverManager.edgedriver().setup();

            // --- Configuração Manual (Alternativa) ---
            // Se precisar informar manualmente, COMENTE a linha acima e DESCOMENTE e ajuste a linha abaixo:
            // System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaoc\\Drivers\\chromedriver-win64\\chromedriver.exe");
            //System.setProperty("webdriver.edge.driver", "C:\\Users\\joaoc\\Drivers\\IEDriverServer_Win32_4.14.0\\IEDriverServer.exe");

            System.setProperty("webdriver.edge.driver", "C:\\Users\\joaoc\\Drivers\\edgedriver_win64\\msedgedriver.exe");
    //      System.setProperty("webdriver.chrome.driver", "/caminho/para/o/seu/chromedriver.exe");


    //        driver = new ChromeDriver();
              driver = new EdgeDriver();

            driver.manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
