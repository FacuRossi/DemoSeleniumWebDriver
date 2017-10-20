package scritp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Facundo on 10/20/2017.
 */
public class TestCaseUTNFRC {

    private WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new FirefoxDriver();
    }

    @Test(description = "Verify Elements in UTN - FRC")
    public void verifyElements() throws Exception{
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
    }

    private void verifyUserElement() throws Exception {
        WebElement userField = driver.findElement(By.id("txtUsuario"));
        Assert.assertNotNull(userField);
        Assert.assertTrue(userField.isEnabled());
        Assert.assertTrue(userField.isDisplayed());
    }

    private void verifyPasswordElement() throws Exception {
        WebElement passwordField = driver.findElement(By.id("pwdClave"));
        Assert.assertNotNull(passwordField);
        Assert.assertTrue(passwordField.isEnabled());
        Assert.assertTrue(passwordField.isDisplayed());
    }

    private void verifyDominiosElement() throws Exception {
        WebElement dominiosField = driver.findElement(By.id("txtDominios"));
        Assert.assertNotNull(dominiosField);
        Assert.assertTrue(dominiosField.isEnabled());
        Assert.assertTrue(dominiosField.isDisplayed());
    }

    private void verifyRememberPasswordElement() throws Exception {
        WebElement rememberPasswordField = driver.findElement(By.id("rec"));
        Assert.assertNotNull(rememberPasswordField);
        Assert.assertTrue(rememberPasswordField.isEnabled());
        Assert.assertTrue(rememberPasswordField.isDisplayed());
    }

    private void verifyLoginButton() throws Exception {
        WebElement loginButton = driver.findElement(By.id("btnEnviar"));
        Assert.assertNotNull(loginButton);
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    private void verifyCorreoCheckbox() throws Exception {
        WebElement correoCheckbox = driver.findElement(By.id("chk55"));
        Assert.assertNotNull(correoCheckbox);
        Assert.assertTrue(correoCheckbox.isEnabled());
        Assert.assertTrue(correoCheckbox.isDisplayed());
    }
    private void verifyAutogestionCheckbox() throws Exception {
        WebElement autogestionCheckbox = driver.findElement(By.id("chk2"));
        Assert.assertNotNull(autogestionCheckbox);
        Assert.assertTrue(autogestionCheckbox.isEnabled());
        Assert.assertTrue(autogestionCheckbox.isDisplayed());
    }

    private void verifyUVCheckbox() throws Exception {
        WebElement UVCheckbox = driver.findElement(By.id("chk6"));
        Assert.assertNotNull(UVCheckbox);
        Assert.assertTrue(UVCheckbox.isEnabled());
        Assert.assertTrue(UVCheckbox.isDisplayed());
    }
    private void verifyForoCheckbox() throws Exception {
        WebElement foroCheckbox = driver.findElement(By.id("chk4"));
        Assert.assertNotNull(foroCheckbox);
        Assert.assertTrue(foroCheckbox.isEnabled());
        Assert.assertTrue(foroCheckbox.isDisplayed());
    }
    private void verifyPortalCheckbox() throws Exception {
        WebElement portalCheckbox = driver.findElement(By.id("chk8"));
        Assert.assertNotNull(portalCheckbox);
        Assert.assertTrue(portalCheckbox.isEnabled());
        Assert.assertTrue(portalCheckbox.isDisplayed());
    }
    private void verifyPrensaCheckbox() throws Exception {
        WebElement prensaCheckbox = driver.findElement(By.id("chk3"));
        Assert.assertNotNull(prensaCheckbox);
        Assert.assertTrue(prensaCheckbox.isEnabled());
        Assert.assertTrue(prensaCheckbox.isDisplayed());
    }
    private void verifySAPCheckbox() throws Exception {
        WebElement SAPCheckbox = driver.findElement(By.id("chk7"));
        Assert.assertNotNull(SAPCheckbox);
        Assert.assertTrue(SAPCheckbox.isEnabled());
        Assert.assertTrue(SAPCheckbox.isDisplayed());
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
