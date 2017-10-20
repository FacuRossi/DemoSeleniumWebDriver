package scritp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Facundo on 10/20/2017.
 */
public class TestCaseUTNFRC {

    private WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        Reporter.log("Abro el Browser");
        driver = new FirefoxDriver();
    }

    @Test(description = "Verify Elements in UTN - FRC")
    public void verifyElements() throws Exception{
        Reporter.log("Accedo a la pagina de login de la UTN-FRC");
        driver.get("http://www.frc.utn.edu.ar/logon.frc");
        verifyUserElement();
        verifyPasswordElement();
        verifyDominiosElement();
        verifyRememberPasswordElement();
        verifyLoginButton();
        verifyUVCheckbox();
        verifyForoCheckbox();
        verifyAutogestionCheckbox();
        verifyCorreoCheckbox();
        verifyPortalCheckbox();
        verifyPrensaCheckbox();
        verifySAPCheckbox();
        loginWithUserInvalid();
    }

    private void verifyUserElement() throws Exception {
        WebElement userField = driver.findElement(By.id("txtUsuario"));
        Reporter.log("Verifico la existencia del campo Usuario");
        Assert.assertNotNull(userField);
        Assert.assertTrue(userField.isEnabled());
        Assert.assertTrue(userField.isDisplayed());
    }

    private void verifyPasswordElement() throws Exception {
        WebElement passwordField = driver.findElement(By.id("pwdClave"));
        Reporter.log("Verifico la existencia del campo Password");
        Assert.assertNotNull(passwordField);
        Assert.assertTrue(passwordField.isEnabled());
        Assert.assertTrue(passwordField.isDisplayed());
    }

    private void verifyDominiosElement() throws Exception {
        WebElement dominiosField = driver.findElement(By.id("txtDominios"));
        Reporter.log("Verifico la existencia del campo Dominio");
        Assert.assertNotNull(dominiosField);
        Assert.assertTrue(dominiosField.isEnabled());
        Assert.assertTrue(dominiosField.isDisplayed());
    }

    private void verifyRememberPasswordElement() throws Exception {
        WebElement rememberPasswordField = driver.findElement(By.id("rec"));
        Reporter.log("Verifico la existencia del checkbox Recordar");
        Assert.assertNotNull(rememberPasswordField);
        Assert.assertTrue(rememberPasswordField.isEnabled());
        Assert.assertTrue(rememberPasswordField.isDisplayed());
    }

    private void verifyLoginButton() throws Exception {
        WebElement loginButton = driver.findElement(By.id("btnEnviar"));
        Reporter.log("Verifico la existencia del boton Enviar");
        Assert.assertNotNull(loginButton);
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    private void verifyCorreoCheckbox() throws Exception {
        WebElement correoCheckbox = driver.findElement(By.id("chk55"));
        Reporter.log("Verifico la existencia del checkbox Correo");
        Assert.assertNotNull(correoCheckbox);
        Assert.assertTrue(correoCheckbox.isEnabled());
        Assert.assertTrue(correoCheckbox.isDisplayed());
    }
    private void verifyAutogestionCheckbox() throws Exception {
        WebElement autogestionCheckbox = driver.findElement(By.id("chk2"));
        Reporter.log("Verifico la existencia del checkbox Autogestion");
        Assert.assertNotNull(autogestionCheckbox);
        Assert.assertTrue(autogestionCheckbox.isEnabled());
        Assert.assertTrue(autogestionCheckbox.isDisplayed());
    }

    private void verifyUVCheckbox() throws Exception {
        WebElement UVCheckbox = driver.findElement(By.id("chk6"));
        Reporter.log("Verifico la existencia del checkbox UV");
        Assert.assertNotNull(UVCheckbox);
        Assert.assertTrue(UVCheckbox.isEnabled());
        Assert.assertTrue(UVCheckbox.isDisplayed());
    }
    private void verifyForoCheckbox() throws Exception {
        WebElement foroCheckbox = driver.findElement(By.id("chk4"));
        Reporter.log("Verifico la existencia del checkbox Foro");
        Assert.assertNotNull(foroCheckbox);
        Assert.assertTrue(foroCheckbox.isEnabled());
        Assert.assertTrue(foroCheckbox.isDisplayed());
    }
    private void verifyPortalCheckbox() throws Exception {
        WebElement portalCheckbox = driver.findElement(By.id("chk8"));
        Reporter.log("Verifico la existencia del checkbox Portal");
        Assert.assertNotNull(portalCheckbox);
        Assert.assertTrue(portalCheckbox.isEnabled());
        Assert.assertTrue(portalCheckbox.isDisplayed());
    }
    private void verifyPrensaCheckbox() throws Exception {
        WebElement prensaCheckbox = driver.findElement(By.id("chk3"));
        Reporter.log("Verifico la existencia del checkbox Prensa");
        Assert.assertNotNull(prensaCheckbox);
        Assert.assertTrue(prensaCheckbox.isEnabled());
        Assert.assertTrue(prensaCheckbox.isDisplayed());
    }
    private void verifySAPCheckbox() throws Exception {
        WebElement SAPCheckbox = driver.findElement(By.id("chk7"));
        Reporter.log("Verifico la existencia del checkbox SAP");
        Assert.assertNotNull(SAPCheckbox);
        Assert.assertTrue(SAPCheckbox.isEnabled());
        Assert.assertTrue(SAPCheckbox.isDisplayed());
    }

    private void loginWithUserInvalid(){
        WebElement userField = driver.findElement(By.id("txtUsuario"));
        Reporter.log("Ingreso el legajo 64576");
        userField.sendKeys("64576");
        WebElement passwordField = driver.findElement(By.id("pwdClave"));
        Reporter.log("Ingreso la password 585858");
        passwordField.sendKeys("585858");
        Reporter.log("Seleccion el dominio sistemas");
        List<WebElement> dominios = driver.findElements(By.xpath(".//*[@id='txtDominios']/option"));
        dominios.forEach(t ->{
            if(t.getText().contains("sistemas")){
                t.click();
            }
        });
        Reporter.log("Selecciono redirigir a Autogestion");
        WebElement autogestionCheckbox = driver.findElement(By.id("chk2"));
        autogestionCheckbox.click();
        Reporter.log("Selecciono el boton iniciar sesion");
        WebElement loginButton = driver.findElement(By.id("btnEnviar"));
        loginButton.click();
        WebElement error = driver.findElement(By.id("error"));
        Reporter.log("Verifico que no se haya iniciado sesion");
        Assert.assertTrue(error.getText().contains("Contraseña Inválida"));
    }


    @AfterMethod
    public void closeBrowser(){
        Reporter.log("Cierro el Browser");
        driver.quit();
    }
}
