package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Logs;

public class World {

    private final String mainUrl = "https://magento.softwaretestingboard.com";
    WebDriver driver;


    @Before
    public void setUp(Scenario scenario) {
        Logs.debug("Inicializando el driver");
        driver = new ChromeDriver();

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Eliminando las cookies");
        driver.manage().deleteAllCookies();

    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {

        }

        Logs.debug("Matando al driver");
        driver.quit();
    }


    @Given("Navego a la pagina de {string}")
    public void navegarPagina(String path) {
        final var url = String.format("%s/%s", mainUrl, path);
        driver.get(url);
    }
}