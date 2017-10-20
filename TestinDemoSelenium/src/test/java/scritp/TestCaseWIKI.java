package scritp;

import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.Bidi;

/**
 * Created by Facundo on 10/20/2017.
 */
public class TestCaseWIKI {

    private WebDriver driver;

    @BeforeMethod
    public void abrirBrowser(){
        Reporter.log("Abro el browser");
        driver = new FirefoxDriver();
    }

    @Test(description = "Wikipedia Home Page contiene link a Wikipedia en español")
    public void españolOnHomepage() throws Exception {
        Reporter.log("Accedo a wikipedia");
        driver.get("http://wikipedia.org");
        Reporter.log("Verifico la existencia del link Español");
        WebElement españolLink = driver.findElement(By.partialLinkText("Español"));
        españolLink.click();
        Assert.assertNotNull(españolLink);
        Reporter.log("Verifico la existencia del buscador");
        WebElement busquedaTxt = driver.findElement(By.id("searchInput"));
        Assert.assertNotNull(busquedaTxt);
        Assert.assertTrue(busquedaTxt.isDisplayed());
        busquedaTxt.sendKeys("Facultad Regional Cordoba");
        WebElement lupa = driver.findElement(By.id("searchButton"));
        Assert.assertNotNull(lupa);
        Assert.assertTrue(lupa.isDisplayed());
        Reporter.log("Busco Facultad regional cordoba");
        lupa.click();
        WebElement titulo = driver.findElement(By.id("firstHeading"));
        Assert.assertNotNull(titulo);
        Assert.assertTrue(titulo.isDisplayed());
        Reporter.log("Verifico que los resultados sean correctos");
        Assert.assertTrue(titulo.getText().contains("Facultad"));
    }

    @AfterMethod
    public void cerrrarBrowser(){
        Reporter.log("Cierro el browser");
        driver.quit();
    }
}
