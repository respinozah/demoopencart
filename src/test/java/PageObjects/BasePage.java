package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    static WebDriver driver;

    public BasePage(WebDriver _driver){
        this.driver = _driver;
    }

    public void waitUntilElementExists(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}