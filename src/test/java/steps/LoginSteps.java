package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;

public class LoginSteps {
    private final WebDriver driver;

    public LoginSteps(World world) {
        driver = world.driver;
    }

    @When("Completar formulario de login con el username {string} y el password {string}")
    public void completarFormulario(String username, String password) {
        Logs.info("Escribo el username");
        driver.findElement(By.id("email")).sendKeys(username);


        Logs.info("Escibo el password");
        driver.findElement(By.id("pass")).sendKeys(password);

        Logs.info("Hago Click en el boton de login");
        driver.findElement(By.id("send2")).click();

    }

    @Then("Verifico que el mensaje de error sea {string}")
    public void verificarMensajeError(String mensajeEsperado) {
        Logs.info("Verificnado mensaje de error");

        final var  mensajeError = driver.findElement(By.className("message-error"));

        Assertions.assertAll(
                ()-> Assertions.assertTrue(mensajeError.isDisplayed()),
                ()-> Assertions.assertEquals(mensajeEsperado,mensajeError.getText())

        );
    }

    @Then("Verifico la UI de la pagina de login")
    public void veriicarUI() {
        Logs.info("Verifico la UI de la pagina de login");

        final var botonLogin = driver.findElement(By.id("send2"));
        Assertions.assertAll(
                ()-> Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed()),
                ()-> Assertions.assertTrue(driver.findElement(By.id("pass")).isDisplayed()),
                ()-> Assertions.assertTrue(botonLogin.isDisplayed()),
                ()-> Assertions.assertTrue(botonLogin.isEnabled())

        );
    }

    @Then("Verifico la UI de la pagina de login Exitoso")
    public void verificarUILoginExitoso() {
        Logs.info("Verifico la UI de la pagina de login Exitoso");
        final var titulo = driver.findElement(By.className("page-title-wrapper"));


        Assertions.assertAll(
                ()->Assertions.assertTrue(titulo.isDisplayed())


        );
    }
}
