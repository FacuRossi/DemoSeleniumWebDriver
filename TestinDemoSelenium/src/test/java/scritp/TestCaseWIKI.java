package scritp;

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

    @Test(description = "Wikipedia Home Page contiene link a Wikipedia en español")
    public void españolOnHomepage() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://wikipedia.org");
        WebElement españolLink = driver.findElement(By.partialLinkText("Español"));
        Assert.assertNotNull(españolLink);
    }
}
