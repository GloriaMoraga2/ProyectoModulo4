package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logs;

import java.time.Duration;

public class RegistroSteps {
    private final WebDriver driver;

    public RegistroSteps(World world) {
        driver = world.driver;
    }




    @When("Completar formulario de login con el nombre {string} apellido {string} correo {string} pass {string} confirpass {string}")
    public void completarFormularioRegistro(String nombre, String apellido, String correo, String pass, String confirpass) {

        Logs.info("Escribo el FirstName");
        driver.findElement(By.id("firstname")).sendKeys(nombre);

        Logs.info("Escribo el LastName");
        driver.findElement(By.id("lastname")).sendKeys(apellido);

        Logs.info("Escribo el Email");
        driver.findElement(By.id("email_address")).sendKeys(correo);

        Logs.info("Escribo el Password");
        driver.findElement(By.id("password")).sendKeys(pass);


        Logs.info("Escribo el ConfirmPassword");
        driver.findElement(By.id("password-confirmation")).sendKeys(confirpass);

        Logs.info("Hago Click en el boton de Crea cuenta");
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();

    }

    @Then("Verifico que el mensaje de bienvenida sea {string}")
    public void verificarMensajeBienvenida(String mensajeEsperado) {
        Logs.info("Verificando mensaje de bienvenida");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mensaje = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".panel.header .greet.welcome"))
        );

        Assertions.assertAll(
                () -> Assertions.assertTrue(mensaje.isDisplayed()),
                () -> Assertions.assertEquals(mensajeEsperado, mensaje.getText())
        );
    }

    @When("Dejar todos los campos de registro vacio")
    public void dejarCamposVacios() {
        Logs.info("Hago click en Crear cuenta sin rellenar campos");
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();


    }


    @Then("Verifico que el mensaje de advertencia sea {string}")
    public void verificarMensaje(String msnEsperado) {
        Logs.info("Verifico mensaje de error para los campos requeridos");

        String[] selectoresErrores = {
                "#firstname-error",
                "#lastname-error",
                "#email_address-error",
                "#password-error",
                "#password-confirmation-error"
        };

        for (String selector : selectoresErrores) {
            final var mensajeAdvertencia = driver.findElement(By.cssSelector(selector));

            Assertions.assertAll(
                    () -> Assertions.assertTrue(mensajeAdvertencia.isDisplayed(),
                            "El mensaje no está visible para: " + selector),
                    () -> Assertions.assertEquals(msnEsperado, mensajeAdvertencia.getText(),
                            "El mensaje no coincide para: " + selector)
            );
        }
    }

}

