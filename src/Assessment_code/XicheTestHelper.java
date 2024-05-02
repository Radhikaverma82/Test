package Assessment_code;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class XicheTestHelper {

    private WebDriver driver;


    
    public XicheTestHelper(String driverPath) {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();

    }

 

    public void navigateTo(String url) {

        driver.get(url);

    }

 

    public void clickElementById(String id) {

        WebElement element = driver.findElement(By.id(id));

        element.click();

    }
    public void clickElementByCSSId(String id) {

        WebElement element = driver.findElement(By.cssSelector(id));

        element.click();

    }

    public void clickElementByXpath(String id) {

        WebElement element = driver.findElement(By.xpath(id));

        element.click();

    }


 

    public void enterTextByName(String name, String text) {

        WebElement element = driver.findElement(By.id(name));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        element.sendKeys(text);

    }

    public String getText(String xpathstr) {
        // Create a WebDriverWait instance with a timeout of 10 seconds
        //WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait until the element is present on the page
        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathstr)));

        WebElement element = driver.findElement(By.xpath(xpathstr));
        return element.getText();

    }


    public String getPageTitle() {

        return driver.getTitle();

    }

 

    public boolean isElementDisplayedById(String id) {

        WebElement element = driver.findElement(By.id(id));

        return element.isDisplayed();

    }

 

    public void closeBrowser() {

        driver.quit();

    }

}

 




