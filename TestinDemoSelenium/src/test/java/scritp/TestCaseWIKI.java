package scritp;

import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Facundo on 10/20/2017.
 */
public class TestCaseWIKI {

    private WebDriver driver;

    @BeforeMethod
    public void abrirBrowser(){
        driver = new FirefoxDriver();
    }

    @Test(description = "Wikipedia Home Page contiene link a Wikipedia en español")
    public void españolOnHomepage() throws Exception {
        driver.get("http://wikipedia.org");
        WebElement españolLink = driver.findElement(By.partialLinkText("Español"));
        españolLink.click();
        Assert.assertNotNull(españolLink);
    }

    @AfterMethod
    public void cerrrarBrowser(){
        driver.quit();
    }
}
